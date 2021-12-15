package com.machine.dragon.common.tool.jackson;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.jayway.jsonpath.JsonPath;
import com.machine.dragon.common.core.bean.page.DragonPage;
import com.machine.dragon.common.tool.date.DragonDateUtil;
import com.machine.dragon.common.tool.date.DragonJavaTimeModule;
import com.machine.dragon.common.tool.exception.Exceptions;
import com.machine.dragon.common.tool.object.DragonObjectUtil;
import com.machine.dragon.common.tool.string.DragonStringUtil;
import com.machine.dragon.common.tool.string.StringPool;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

/**
 * Jackson工具类
 */
@Slf4j
public class DragonJsonUtil {

    /**
     * 拷贝对象
     *
     * @param source 源对象
     * @param clazz  类名
     * @param <T>    泛型标记
     * @return T
     */
    public static <T> T copy(@Nullable Object source, Class<T> clazz) {
        if (clazz.isInterface()) {
            throw new BeanInstantiationException(clazz, "Specified class is an interface");
        }
        return parse(toJson(source), clazz);
    }

    public static <T> List<T> copyArray(@Nullable Object source, Class<T> clazz) {
        if (clazz.isInterface()) {
            throw new BeanInstantiationException(clazz, "Specified class is an interface");
        }
        return parseArray(toJson(source), clazz);
    }

    public static <T1, T2> DragonPage<T2> convertT1ToT2(DragonPage<T1> page, Class<T2> clazz) {
        List<T1> recordsT1 = page.getRecords();

        DragonPage<T2> pageT2 = new DragonPage<>(page.getCurrent(), page.getSize(), page.getTotal());
        if (CollectionUtils.isEmpty(recordsT1)) {
            return pageT2;
        }
        pageT2.setRecords(copyArray(recordsT1, clazz));
        return pageT2;
    }

    public static <T1, T2> Page<T2> convertT1ToT2(IPage<T1> page, Class<T2> clazz) {
        List<T1> recordsT1 = page.getRecords();

        Page<T2> pageT2 = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        if (CollectionUtils.isEmpty(recordsT1)) {
            return pageT2;
        }
        pageT2.setRecords(copyArray(recordsT1, clazz));
        return pageT2;
    }

    public static String read(@Nullable String json, String jsonPath) {
        return JsonPath.read(json, jsonPath).toString();
    }

    /**
     * 将对象序列化成json字符串
     *
     * @param value javaBean
     * @return jsonString json字符串
     */
    @SneakyThrows
    public static <T> String toJson(T value) {
        return getInstance().writeValueAsString(value);
    }

    /**
     * 将对象序列化成 json byte 数组
     *
     * @param object javaBean
     * @return jsonString json字符串
     */
    @SneakyThrows
    public static byte[] toJsonAsBytes(Object object) {
        return getInstance().writeValueAsBytes(object);
    }

    /**
     * 将json反序列化成对象
     *
     * @param content   content
     * @param valueType class
     * @param <T>       T 泛型标记
     * @return Bean
     */
    @SneakyThrows
    public static <T> T parse(String content, Class<T> valueType) {
        return getInstance().readValue(content, valueType);
    }

    /**
     * 将json反序列化成对象
     *
     * @param content       content
     * @param typeReference 泛型类型
     * @param <T>           T 泛型标记
     * @return Bean
     */
    @SneakyThrows
    public static <T> T parse(String content, TypeReference<T> typeReference) {
        return getInstance().readValue(content, typeReference);
    }

    /**
     * 将json byte 数组反序列化成对象
     *
     * @param bytes     json bytes
     * @param valueType class
     * @param <T>       T 泛型标记
     * @return Bean
     */
    @SneakyThrows
    public static <T> T parse(byte[] bytes, Class<T> valueType) {
        return getInstance().readValue(bytes, valueType);
    }


    /**
     * 将json反序列化成对象
     *
     * @param bytes         bytes
     * @param typeReference 泛型类型
     * @param <T>           T 泛型标记
     * @return Bean
     */
    @SneakyThrows
    public static <T> T parse(byte[] bytes, TypeReference<T> typeReference) {
        return getInstance().readValue(bytes, typeReference);
    }

    /**
     * 将json反序列化成对象
     *
     * @param in        InputStream
     * @param valueType class
     * @param <T>       T 泛型标记
     * @return Bean
     */
    @SneakyThrows
    public static <T> T parse(InputStream in, Class<T> valueType) {
        return getInstance().readValue(in, valueType);
    }

    /**
     * 将json反序列化成对象
     *
     * @param in            InputStream
     * @param typeReference 泛型类型
     * @param <T>           T 泛型标记
     * @return Bean
     */
    @SneakyThrows
    public static <T> T parse(InputStream in, TypeReference<T> typeReference) {
        return getInstance().readValue(in, typeReference);
    }

    /**
     * 将json反序列化成List对象
     *
     * @param content      content
     * @param valueTypeRef class
     * @param <T>          T 泛型标记
     * @return List<T>
     */
    @SneakyThrows
    public static <T> List<T> parseArray(String content, Class<T> valueTypeRef) {
        if (!DragonStringUtil.startsWithIgnoreCase(content, StringPool.LEFT_SQ_BRACKET)) {
            content = StringPool.LEFT_SQ_BRACKET + content + StringPool.RIGHT_SQ_BRACKET;
        }

        List<Map<String, Object>> list = getInstance().readValue(content, new TypeReference<List<Map<String, Object>>>() {
        });

        List<T> result = new ArrayList<>();
        for (Map<String, Object> map : list) {
            result.add(toPojo(map, valueTypeRef));
        }
        return result;
    }

    /**
     * 将json字符串转成 JsonNode
     *
     * @param jsonString jsonString
     * @return jsonString json字符串
     */
    @SneakyThrows
    public static JsonNode readTree(String jsonString) {
        Objects.requireNonNull(jsonString, "jsonString is null");
        return getInstance().readTree(jsonString);
    }

    /**
     * 将json字符串转成 JsonNode
     *
     * @param in InputStream
     * @return jsonString json字符串
     */
    @SneakyThrows
    public static JsonNode readTree(InputStream in) {
        Objects.requireNonNull(in, "InputStream in is null");
        return getInstance().readTree(in);
    }

    /**
     * 将json字符串转成 JsonNode
     *
     * @param content content
     * @return jsonString json字符串
     */
    @SneakyThrows
    public static JsonNode readTree(byte[] content) {
        Objects.requireNonNull(content, "byte[] content is null");
        return getInstance().readTree(content);
    }

    /**
     * 将json字符串转成 JsonNode
     *
     * @param jsonParser JsonParser
     * @return jsonString json字符串
     */
    @SneakyThrows
    public static JsonNode readTree(JsonParser jsonParser) {
        Objects.requireNonNull(jsonParser, "jsonParser is null");
        return getInstance().readTree(jsonParser);
    }


    /**
     * 将json byte 数组反序列化成对象
     *
     * @param content   json bytes
     * @param valueType class
     * @param <T>       T 泛型标记
     * @return Bean
     */
    @Nullable
    @SneakyThrows
    public static <T> T readValue(@Nullable byte[] content, Class<T> valueType) {
        if (DragonObjectUtil.isEmpty(content)) {
            return null;
        }
        return getInstance().readValue(content, valueType);
    }

    /**
     * 将json反序列化成对象
     *
     * @param jsonString jsonString
     * @param valueType  class
     * @param <T>        T 泛型标记
     * @return Bean
     */
    @Nullable
    @SneakyThrows
    public static <T> T readValue(@Nullable String jsonString, Class<T> valueType) {
        if (DragonStringUtil.isBlank(jsonString)) {
            return null;
        }
        return getInstance().readValue(jsonString, valueType);
    }

    /**
     * 将json反序列化成对象
     *
     * @param in        InputStream
     * @param valueType class
     * @param <T>       T 泛型标记
     * @return Bean
     */
    @Nullable
    @SneakyThrows
    public static <T> T readValue(@Nullable InputStream in, Class<T> valueType) {
        if (in == null) {
            return null;
        }
        return getInstance().readValue(in, valueType);
    }

    /**
     * 将json反序列化成对象
     *
     * @param content       bytes
     * @param typeReference 泛型类型
     * @param <T>           T 泛型标记
     * @return Bean
     */
    @Nullable
    @SneakyThrows
    public static <T> T readValue(@Nullable byte[] content, TypeReference<T> typeReference) {
        if (DragonObjectUtil.isEmpty(content)) {
            return null;
        }
        return getInstance().readValue(content, typeReference);
    }

    /**
     * 将json反序列化成对象
     *
     * @param jsonString    jsonString
     * @param typeReference 泛型类型
     * @param <T>           T 泛型标记
     * @return Bean
     */
    @Nullable
    @SneakyThrows
    public static <T> T readValue(@Nullable String jsonString, TypeReference<T> typeReference) {
        if (DragonStringUtil.isBlank(jsonString)) {
            return null;
        }
        return getInstance().readValue(jsonString, typeReference);
    }

    /**
     * 将json反序列化成对象
     *
     * @param in            InputStream
     * @param typeReference 泛型类型
     * @param <T>           T 泛型标记
     * @return Bean
     */
    @Nullable
    @SneakyThrows
    public static <T> T readValue(@Nullable InputStream in, TypeReference<T> typeReference) {
        if (in == null) {
            return null;
        }
        return getInstance().readValue(in, typeReference);
    }

    /**
     * 封装 map type
     *
     * @param keyClass   key 类型
     * @param valueClass value 类型
     * @return MapType
     */
    public static MapType getMapType(Class<?> keyClass, Class<?> valueClass) {
        return getInstance().getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
    }

    /**
     * 封装 map type
     *
     * @param elementClass 集合值类型
     * @return CollectionLikeType
     */
    public static CollectionLikeType getListType(Class<?> elementClass) {
        return getInstance().getTypeFactory().constructCollectionLikeType(List.class, elementClass);
    }

    /**
     * 读取集合
     *
     * @param content      bytes
     * @param elementClass elementClass
     * @param <T>          泛型
     * @return 集合
     */
    @SneakyThrows
    public static <T> List<T> readList(@Nullable byte[] content, Class<T> elementClass) {
        if (DragonObjectUtil.isEmpty(content)) {
            return Collections.emptyList();
        }
        return getInstance().readValue(content, getListType(elementClass));
    }

    /**
     * 读取集合
     *
     * @param content      InputStream
     * @param elementClass elementClass
     * @param <T>          泛型
     * @return 集合
     */
    @SneakyThrows
    public static <T> List<T> readList(@Nullable InputStream content, Class<T> elementClass) {
        if (content == null) {
            return Collections.emptyList();
        }
        return getInstance().readValue(content, getListType(elementClass));
    }

    /**
     * 读取集合
     *
     * @param content      bytes
     * @param elementClass elementClass
     * @param <T>          泛型
     * @return 集合
     */
    @SneakyThrows
    public static <T> List<T> readList(@Nullable String content, Class<T> elementClass) {
        if (DragonObjectUtil.isEmpty(content)) {
            return Collections.emptyList();
        }
        return getInstance().readValue(content, getListType(elementClass));
    }

    /**
     * 读取集合
     *
     * @param content    bytes
     * @param keyClass   key类型
     * @param valueClass 值类型
     * @param <K>        泛型
     * @param <V>        泛型
     * @return 集合
     */
    @SneakyThrows
    public static <K, V> Map<K, V> readMap(@Nullable byte[] content, Class<?> keyClass, Class<?> valueClass) {
        if (DragonObjectUtil.isEmpty(content)) {
            return Collections.emptyMap();
        }
        return getInstance().readValue(content, getMapType(keyClass, valueClass));
    }

    /**
     * 读取集合
     *
     * @param content    InputStream
     * @param keyClass   key类型
     * @param valueClass 值类型
     * @param <K>        泛型
     * @param <V>        泛型
     * @return 集合
     */
    @SneakyThrows
    public static <K, V> Map<K, V> readMap(@Nullable InputStream content, Class<?> keyClass, Class<?> valueClass) {
        if (DragonObjectUtil.isEmpty(content)) {
            return Collections.emptyMap();
        }
        return getInstance().readValue(content, getMapType(keyClass, valueClass));
    }

    /**
     * 读取集合
     *
     * @param content    bytes
     * @param keyClass   key类型
     * @param valueClass 值类型
     * @param <K>        泛型
     * @param <V>        泛型
     * @return 集合
     */
    @SneakyThrows
    public static <K, V> Map<K, V> readMap(@Nullable String content, Class<?> keyClass, Class<?> valueClass) {
        if (DragonObjectUtil.isEmpty(content)) {
            return Collections.emptyMap();
        }
        return getInstance().readValue(content, getMapType(keyClass, valueClass));
    }

    /**
     * jackson 的类型转换
     *
     * @param fromValue   来源对象
     * @param toValueType 转换的类型
     * @param <T>         泛型标记
     * @return 转换结果
     */
    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return getInstance().convertValue(fromValue, toValueType);
    }

    /**
     * jackson 的类型转换
     *
     * @param fromValue   来源对象
     * @param toValueType 转换的类型
     * @param <T>         泛型标记
     * @return 转换结果
     */
    public static <T> T convertValue(Object fromValue, JavaType toValueType) {
        return getInstance().convertValue(fromValue, toValueType);
    }

    /**
     * jackson 的类型转换
     *
     * @param fromValue      来源对象
     * @param toValueTypeRef 泛型类型
     * @param <T>            泛型标记
     * @return 转换结果
     */
    public static <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        return getInstance().convertValue(fromValue, toValueTypeRef);
    }

    /**
     * tree 转对象
     *
     * @param treeNode  TreeNode
     * @param valueType valueType
     * @param <T>       泛型标记
     * @return 转换结果
     */
    public static <T> T treeToValue(TreeNode treeNode, Class<T> valueType) {
        try {
            return getInstance().treeToValue(treeNode, valueType);
        } catch (JsonProcessingException e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 对象转为 json node
     *
     * @param value 对象
     * @return JsonNode
     */
    public static JsonNode valueToTree(@Nullable Object value) {
        return getInstance().valueToTree(value);
    }

    /**
     * 判断是否可以序列化
     *
     * @param value 对象
     * @return 是否可以序列化
     */
    public static boolean canSerialize(@Nullable Object value) {
        if (value == null) {
            return true;
        }
        return getInstance().canSerialize(value.getClass());
    }

    @SneakyThrows
    public static Map<String, Object> toMap(String content) {
        return getInstance().readValue(content, Map.class);
    }

    @SneakyThrows
    public static <T> Map<String, T> toMap(String content, Class<T> valueTypeRef) {
        Map<String, Map<String, Object>> map = getInstance().readValue(content, new TypeReference<Map<String, Map<String, Object>>>() {
        });
        Map<String, T> result = new HashMap<>(16);
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), toPojo(entry.getValue(), valueTypeRef));
        }
        return result;
    }

    public static <T> T toPojo(Map fromValue, Class<T> toValueType) {
        return getInstance().convertValue(fromValue, toValueType);
    }

    public static ObjectMapper getInstance() {
        return JacksonHolder.INSTANCE;
    }

    private static class JacksonHolder {
        private static final ObjectMapper INSTANCE = new JacksonObjectMapper();
    }

    private static class JacksonObjectMapper extends ObjectMapper {
        private static final long serialVersionUID = 4288193147502386170L;

        private static final Locale CHINA = Locale.CHINA;

        public JacksonObjectMapper(ObjectMapper src) {
            super(src);
        }

        public JacksonObjectMapper() {
            super();
            //设置地点为中国
            super.setLocale(CHINA);
            //去掉默认的时间戳格式
            super.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            //设置为中国上海时区
            super.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            //序列化时，日期的统一格式
            super.setDateFormat(new SimpleDateFormat(DragonDateUtil.PATTERN_DATETIME, Locale.CHINA));
            // 单引号
            super.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            // 允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）
            super.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
            super.configure(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature(), true);
            super.findAndRegisterModules();
            //失败处理
            super.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //单引号处理
            super.configure(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(), true);
            //反序列化时，属性不存在的兼容处理s
            super.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            //日期格式化
            super.registerModule(new DragonJavaTimeModule());
            super.findAndRegisterModules();
        }

        @Override
        public ObjectMapper copy() {
            return new JacksonObjectMapper(this);
        }
    }

}

package com.machine.dragon.server.gateway.dynamic;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.machine.dragon.common.launch.constant.NacosConstant;
import com.machine.dragon.common.launch.property.DragonProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.net.URI;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * 动态路由监听器
 */
@Order
@Slf4j
@Component
@EnableConfigurationProperties(DragonProperties.class)
public class DynamicRouteServiceListener {

    private final DynamicRouteService dynamicRouteService;
    private final NacosDiscoveryProperties nacosDiscoveryProperties;
    private final NacosConfigProperties nacosConfigProperties;
    private final DragonProperties dragonProperties;

    public DynamicRouteServiceListener(DynamicRouteService dynamicRouteService,
                                       NacosDiscoveryProperties nacosDiscoveryProperties,
                                       NacosConfigProperties nacosConfigProperties,
                                       DragonProperties dragonProperties) {
        this.dynamicRouteService = dynamicRouteService;
        this.nacosDiscoveryProperties = nacosDiscoveryProperties;
        this.nacosConfigProperties = nacosConfigProperties;
        this.dragonProperties = dragonProperties;
        dynamicRouteServiceListener();
    }

    /**
     * 监听Nacos下发的动态路由配置
     */
    @SneakyThrows
    private void dynamicRouteServiceListener() {
        String dataId = NacosConstant.dataId(dragonProperties.getName(), dragonProperties.getEnv(), NacosConstant.NACOS_CONFIG_FORMAT);
        String group = nacosConfigProperties.getGroup();
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosDiscoveryProperties.getServerAddr());
        properties.setProperty(PropertyKeyConst.NAMESPACE, nacosDiscoveryProperties.getNamespace());
        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                List<RouteDefinition> routeDefinitions = getRouteDefinitionsByYaml(configInfo);
                dynamicRouteService.update(routeDefinitions);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
        String configInfo = configService.getConfig(dataId, group, 5000);
        if (configInfo != null) {
            List<RouteDefinition> routeDefinitions = getRouteDefinitionsByYaml(configInfo);
            dynamicRouteService.update(routeDefinitions);
        }
    }

    /**
     * 通过yaml str解析出route定义
     *
     * @param configInfo yaml str
     * @return RouteDefinition array
     */
    private List<RouteDefinition> getRouteDefinitionsByYaml(String configInfo) {
        Yaml yaml = new Yaml();
        Map<Object, Object> document = yaml.load(configInfo);
        Map<Object, Object> spring = (Map<Object, Object>) document.get("spring");
        Map<Object, Object> application = (Map<Object, Object>) spring.get("application");
        Map<Object, Object> gateway = (Map<Object, Object>) application.get("gateway");
        List<Map<String, Object>> routeList = (List<Map<String, Object>>) gateway.get("routes");
        List<RouteDefinition> targetRouteDefinitions = new ArrayList<>(routeList.size());
        for (Map<String, Object> routeItem : routeList) {
            RouteDefinition routeDefinition = new RouteDefinition();
            routeDefinition.setId((String) routeItem.get("id"));
            routeDefinition.setUri(URI.create((String) routeItem.get("uri")));
            List<String> predicateStrList = (List<String>) routeItem.get("predicates");
            List<PredicateDefinition> predicateDefinitions = predicateStrList.stream().map(PredicateDefinition::new).collect(Collectors.toList());
            routeDefinition.setPredicates(predicateDefinitions);
            List<String> filterStrList = (List<String>) routeItem.get("filters");
            if (CollectionUtils.isNotEmpty(filterStrList)) {
                List<FilterDefinition> filterDefinitions = filterStrList.stream().map(FilterDefinition::new).collect(Collectors.toList());
                routeDefinition.setFilters(filterDefinitions);
            }
            Object orderObj = routeItem.get("order");
            int order = Objects.isNull(orderObj) ? 0 : (int) orderObj;
            routeDefinition.setOrder(order);
            targetRouteDefinitions.add(routeDefinition);
        }

        return targetRouteDefinitions;
    }

}

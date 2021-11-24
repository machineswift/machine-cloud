package com.machine.dragon.common.tool.url;

import com.machine.dragon.common.tool.string.Charsets;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
 * url处理工具类
 */
public class DragonUrlUtil extends org.springframework.web.util.UriUtils {

	/**
	 * url 编码
	 *
	 * @param source source
	 * @return sourced String
	 */
	public static String encode(String source) {
		return DragonUrlUtil.encode(source, Charsets.UTF_8);
	}

	/**
	 * url 解码
	 *
	 * @param source source
	 * @return decoded String
	 */
	public static String decode(String source) {
		return DragonUrlUtil.decode(source, Charsets.UTF_8);
	}

	/**
	 * url 编码
	 *
	 * @param source  url
	 * @param charset 字符集
	 * @return 编码后的url
	 */
	@Deprecated
	public static String encodeURL(String source, Charset charset) {
		return DragonUrlUtil.encode(source, charset.name());
	}

	/**
	 * url 解码
	 *
	 * @param source  url
	 * @param charset 字符集
	 * @return 解码url
	 */
	@Deprecated
	public static String decodeURL(String source, Charset charset) {
		return DragonUrlUtil.decode(source, charset.name());
	}

	/**
	 * 获取url路径
	 *
	 * @param uriStr 路径
	 * @return url路径
	 */
	public static String getPath(String uriStr) {
		URI uri;

		try {
			uri = new URI(uriStr);
		} catch (URISyntaxException var3) {
			throw new RuntimeException(var3);
		}

		return uri.getPath();
	}

}

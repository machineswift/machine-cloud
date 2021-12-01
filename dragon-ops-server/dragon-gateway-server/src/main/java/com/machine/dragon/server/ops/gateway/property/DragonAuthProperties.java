package com.machine.dragon.server.ops.gateway.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限过滤
 */
@Data
@RefreshScope
@ConfigurationProperties("machine.dragon.secure")
public class DragonAuthProperties {

	/**
	 * 放行API集合
	 */
	private final List<String> skipUrl = new ArrayList<>();

}

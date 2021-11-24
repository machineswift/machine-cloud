package com.machine.dragon.common.tool.bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * bean map key，提高性能
 */
@EqualsAndHashCode
@AllArgsConstructor
public class DragonBeanMapKey {
	private final Class type;
	private final int require;
}

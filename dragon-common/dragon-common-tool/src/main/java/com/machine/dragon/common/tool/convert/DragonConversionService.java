package com.machine.dragon.common.tool.convert;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.lang.Nullable;
import org.springframework.util.StringValueResolver;

/**
 * 类型 转换 服务，添加了 IEnum 转换
 */
public class DragonConversionService extends ApplicationConversionService {
	@Nullable
	private static volatile DragonConversionService SHARED_INSTANCE;

	public DragonConversionService() {
		this(null);
	}

	public DragonConversionService(@Nullable StringValueResolver embeddedValueResolver) {
		super(embeddedValueResolver);
		super.addConverter(new EnumToStringConverter());
		super.addConverter(new StringToEnumConverter());
	}

	/**
	 * Return a shared default application {@code ConversionService} instance, lazily
	 * building it once needed.
	 * <p>
	 * Note: This method actually returns an {@link DragonConversionService}
	 * instance. However, the {@code ConversionService} signature has been preserved for
	 * binary compatibility.
	 * @return the shared {@code BladeConversionService} instance (never{@code null})
	 */
	public static GenericConversionService getInstance() {
		DragonConversionService sharedInstance = DragonConversionService.SHARED_INSTANCE;
		if (sharedInstance == null) {
			synchronized (DragonConversionService.class) {
				sharedInstance = DragonConversionService.SHARED_INSTANCE;
				if (sharedInstance == null) {
					sharedInstance = new DragonConversionService();
					DragonConversionService.SHARED_INSTANCE = sharedInstance;
				}
			}
		}
		return sharedInstance;
	}

}

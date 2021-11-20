package com.machine.dragon.common.launch.constant;

/**
 * 系统常量
 */
public interface DragonAppConstant {

    /**
     * 基础包
     */
    String BASE_PACKAGES = "com.machine.dragon";

    /**
     * 应用名前缀
     */
    String APPLICATION_NAME_PREFIX = "dragon-";

    /**
     * system模块名称
     */
    String APPLICATION_SYSTEM_NAME = APPLICATION_NAME_PREFIX + "system-service";

    /**
     * CRM模块名称(客户中心)
     */
    String APPLICATION_CRM_NAME = APPLICATION_NAME_PREFIX + "crm-service";

    /**
     * OMS模块名称(订单中心)
     */
    String APPLICATION_OMS_NAME = APPLICATION_NAME_PREFIX + "oms-service";

    /**
     * PSM模块名称(营销中心)
     */
    String APPLICATION_PSM_NAME = APPLICATION_NAME_PREFIX + "psm-service";

    /**
     * PSS模块名称(商品中心)
     */
    String APPLICATION_PSS_NAME = APPLICATION_NAME_PREFIX + "pss-service";

}

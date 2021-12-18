package com.machine.dragon.service.system.user.feign.outvo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonUserDetailOutVO {

    private String id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Long updateTime;
}
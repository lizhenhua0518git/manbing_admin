package net.huayiyun.manbing.annotation;

/**
 * @Project : manbing
 * @Package Name : net.huayiyun.manbing.annotation
 * @Description : TODO 权限注解
 * @Author : wyb
 * @Creation Date : 2021年04月19日 14:15
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public @interface PreAuthorize {

    /**
     * 验证用户是否具备某权限
     */
    public String hasPermit() default "";

    /**
     * 验证用户是否不具备某权限，与 hasPermit逻辑相反
     */
    public String lacksPermit() default "";

    /**
     * 验证用户是否具有以下任意一个权限
     */
    public String[] hasAnyPermit() default {};

    /**
     * 判断用户是否拥有某个角色
     */
    public String hasRole() default "";

    /**
     * 验证用户是否不具备某角色，与 isRole逻辑相反
     */
    public String lacksRole() default "";

    /**
     * 验证用户是否具有以下任意一个角色
     */
    public String[] hasAnyRoles() default {};

}

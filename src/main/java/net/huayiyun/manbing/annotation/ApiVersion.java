package net.huayiyun.manbing.annotation;


import java.lang.annotation.*;

/**
 * @Project : manbing
 * @Package Name : net.huayiyun.manbing.annotation
 * @Description : TODO 版本控制
 * @Author : wyb
 * @Creation Date : 2021年04月19日 14:07
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {

    int value();

}

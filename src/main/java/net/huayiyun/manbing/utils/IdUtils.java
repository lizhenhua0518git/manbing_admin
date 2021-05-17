package net.huayiyun.manbing.utils;

import net.huayiyun.manbing.text.UUID;

/**
 * @Project : manbing
 * @Package Name : net.huayiyun.manbing.utils
 * @Description : TODO
 * @Author : wyb
 * @Creation Date : 2021年05月08日 11:23
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class IdUtils {

    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }

    public static void main(String[] args) {
        System.out.println("UUid" + IdUtils.fastSimpleUUID());
    }

}
package net.huayiyun.manbing.common.enums;

/**
 * 用户状态
 * 
 */
public enum UserStatus
{
    OK("01", "正常"), DISABLE("02", "停用"), DELETED("03", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}

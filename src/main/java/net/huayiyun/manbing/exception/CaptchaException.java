package net.huayiyun.manbing.exception;

/**
 * 验证码错误异常类
 * 
 */
public class CaptchaException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    private Integer code;

    public CaptchaException(String msg,Integer code)
    {
        super(msg);
        this.code=code;
    }
    public Integer getCode()
    {
        return code;
    }
}

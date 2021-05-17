package net.huayiyun.manbing.pojo.qo;

import lombok.Data;

@Data
public class LoginQO {

    /**
     * 账号
     */
    private String staffAccount;

    /**
     * 密码
     */
    private String staffPassword;

    /**
     * 验证码
     */
    private String captcha;
}

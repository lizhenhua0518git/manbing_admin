package net.huayiyun.manbing.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class LoginVO implements Serializable {

    /**
     * 主键id
     */
    private String staffId;

    /**
     * 姓名
     */
    private String staffName;

    /**
     * 性别
     */
    private String staffGender;

    /**
     * 出生日期
     */
    private Timestamp staffBirth;

    /**
     * 手机号
     */
    private String staffTel;

    /**
     * 简介
     */
    String staffDesc;

    /**
     * 使用状态（01：正常  02：注销）
     */
    String staffStatus;


    /**
     * 职称
     */
    private String staffTitle;

    /**
     * token
     */
    private String token;

}

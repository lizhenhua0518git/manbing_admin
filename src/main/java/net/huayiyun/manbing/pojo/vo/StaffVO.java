package net.huayiyun.manbing.pojo.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StaffVO {

    /**
     * 医生Id
     */
    private String docId;

    /**
     * 医生姓名
     */
    private String docName;

    /**
     * 医生生日
     */
    private Timestamp docBirth;

    /**
     * 医生电话
     */
    private String docTel;

    /**
     * 医生账户
     */
    private String docAccount;

    /**
     * 医生状态
     */
    private String docStatus;

}

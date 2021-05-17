package net.huayiyun.manbing.pojo.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AuthStaffVO {

    private String staffId;
    private String creatorId;
    private String modifierId;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;
    private String staffName;
    private String staffGender;
    private String staffIdCard;
    private java.sql.Date staffBirth;
    private String staffTel;
    private String staffDesc;
    private String certificateNo;
    private String licenseNo;
    private String signatureUrl;
    private String staffAccount;
    private String staffPassword;
    private String staffStatus;
    private String staffTitle;
    private String headImgUrl;
}

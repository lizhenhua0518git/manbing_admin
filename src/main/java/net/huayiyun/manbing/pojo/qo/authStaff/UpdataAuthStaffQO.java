package net.huayiyun.manbing.pojo.qo.authStaff;

import lombok.Data;

@Data
public class UpdataAuthStaffQO {

    /**
     * 医生id
     */
    private String docId;

    /**
     * 医生姓名
     */
    private String docName;

    /**
     * 性别
     */
    private String docGender;

    /**
     *生日
     */
    private String docBirth;

    /**
     *身份证
     */
    private String docIdCard;

    /**
     * 手机
     */
    private String docTel;

    /**
     * 简介
     */
    private String docDesc;

    /**
     * 账号
     */
    private String docAccount;

    /**
     * 密码
     */
    private String docPassword;

    /**
     * 状态（"OK","FORBIDDEN"）
     */
    private String docStatus;

    /**
     * 职称
     */
    private String docTitle;

    /**
     * 资格证号
     */
    private String docCertificateNo;

    /**
     * 执业证号
     */
    private String docLicenceNo;

    /**
     * 签名图片地址
     */
    private String docSignatureUrl;

    /**
     * 头像地址
     */
    private String docHeadImgUrl;
}

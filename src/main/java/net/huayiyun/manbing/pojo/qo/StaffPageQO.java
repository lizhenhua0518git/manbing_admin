package net.huayiyun.manbing.pojo.qo;

import lombok.Data;

@Data
public class StaffPageQO extends PageQO {

    /**
     * 医院Id
     */
    private String hospId;

    /**
     * 医生姓名
     */
    private String docName;

    /**
     * 医生手机
     */
    private String docTel;

    /**
     * 明文账号
     */
    private String docAccount;

}

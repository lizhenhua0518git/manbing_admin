package net.huayiyun.manbing.common.enums;

import lombok.Getter;

/**
 * @Project : hlwyy_user
 * @Package Name : com.huayi.hlwyy_user.common.enums
 * @Description : TODO 公共枚举类
 * @Author : machunyong(springMT)
 * @Creation Date : 2020年02月15日 17:46
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class BaseDictEnumsUtils {

    //向物业小程序发送数据返回结果
    public enum REMOTE_WYAPPLETS_RESULT{

        FAIL("FAIL","失败"),
        SUCCESS("SUCCESS","成功");

        private String code;
        private String content;

        REMOTE_WYAPPLETS_RESULT(String code, String content) {
            this.code = code;
            this.content = content;
        }

        public String getCode() {
            return code;
        }

        public String getContent() {
            return content;
        }
    }

    //登录类型
    @Getter
    public enum LOGIN_TYPE{
        CODE("01","验证码"),
        PASSWORD("02","密码"),
        WX("03","微信");
        private String code;
        private String content;

        LOGIN_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //设备报警类型
    @Getter
    public enum DEVICE_POLICE{
        COMMON("01","公共"),
        HOSP("02","医院"),
        PERSON("03","个人");
        private String code;
        private String content;

        DEVICE_POLICE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //性别
    @Getter
    public enum GENDER{
        MAN("M","男"),
        WOMAN("F","女"),
        UNKOWN("O","未知");

        private String code;
        private String content;

        GENDER(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //mongodb 文件 metadata type类别
    @Getter
    public enum MONGO_METADATA_TYPE{

        ILLNESSDESC("01","病情描述图片"),//病情描述
        HEAD_IMG("02","头像图片"),//头像
        IM("03","网易IM文件");//网易IM文件

        private String code;
        private String content;

        MONGO_METADATA_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //验证码 type类别
    @Getter
    public enum VERIFICATION_CODE_TYPE{

        LOGIN("01","验证码登录"),
        SET_PASSWORD("02","设置密码"),
        UPDATE_PHONE("03","修改账号"),
        BIND_USER("04","绑定用户");

        private String code;
        private String content;

        VERIFICATION_CODE_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //数据来源
    @Getter
    public enum DATA_SOURCES{

        MANUAL_ENTRY("01","手动录入"),
        BIOLAND_BG("02","爱奥乐血糖仪"),
        BIOLAND_BP("03","爱奥乐血压计"),
        WATCH("04","智能手表"),
        SCALE("05","体脂秤");

        private String code;
        private String content;

        DATA_SOURCES(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //高血压疾病等级类型
    @Getter
    public enum HYPERTENSION_LEVEL{

        LOW_BP(1,"血压偏低"),
        NORMAL(2,"血压正常"),
        SYSTOLIC_HYPERTENSION(3,"单纯收缩期高血压"),
        LEVEL_ONE(4,"高血压一级"),
        LEVEL_TWO(5,"高血压二级"),
        LEVEL_THREE(6,"高血压三级");

        private int code;
        private String content;

        HYPERTENSION_LEVEL(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //心率类型
    @Getter
    public enum HEART_RATE_TYPE{

        LOW_HEART_RATE(1,"心率过低"),
        NORMAL_HEART_RATE(2,"心率正常"),
        HIGH_HEART_RATE(3,"心率过高");

        private int code;
        private String content;

        HEART_RATE_TYPE(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //血糖类型
    @Getter
    public enum BLOOD_SUGAR_TYPE{

        LOW_BLOOD_SUGAR(1,"血糖偏低"),
        NORMAL_BLOOD_SUGAR(2,"血糖正常"),
        HIGH_BLOOD_SUGAR(3,"血糖偏高");

        private int code;
        private String content;

        BLOOD_SUGAR_TYPE(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //bmi类型
    @Getter
    public enum BMI_TYPE{

        LOW_BMI(1,"偏低"),
        STANDARD_BMI(2,"标准"),
        OVERWEIGHT(3,"超重"),
        OBESITY(4,"肥胖");

        private int code;
        private String content;

        BMI_TYPE(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //血糖测量时间点
    @Getter
    public enum BG_TIME_POINT_TYPE{

        FASTING("01","空腹"),
        AFTER_BREAKFAST("02","早饭后"),
        BEFORE_LUNCH("03","午饭前"),
        AFTER_LUNCH("04","午饭后"),
        BEFORE_DINNER("05","晚饭前"),
        AFTER_DINNER("06","晚饭后");

        private String code;
        private String content;

        BG_TIME_POINT_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //健康数据类型
    @Getter
    public enum HEALTH_DATA_TYPE{

        BG("bg","血糖"),
        BP("bp","血压"),
        PULSE("pulse","心率"),
        BMI("bmi","BMI"),
        TEMP("temp","体温"),
        BO("bo","血氧");

        private String code;
        private String content;

        HEALTH_DATA_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //体温类型
    @Getter
    public enum TEMP_TYPE{

        LOW_TEMP(1,"体温偏低"),
        NORMAL_TEMP(2,"体温正常"),
        HIGH_TEMP(3,"体温偏高");

        private int code;
        private String content;

        TEMP_TYPE(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //血氧类型
    @Getter
    public enum BLOOD_OXYGEN_TYPE{

        LOW_BLOOD_OXYGEN(1,"血氧偏低"),
        NORMAL_BLOOD_OXYGEN(2,"血氧正常");

        private int code;
        private String content;

        BLOOD_OXYGEN_TYPE(int code, String content) {
            this.code = code;
            this.content = content;
        }
    }


    //=====================================================================

    //短信模板
    @Getter
    public enum NOTE_CODE{
        CASE_APPLY(563210,"给诊断医师发短信通知"),
        SMS_CODE(200438,"给用户发手机短信验证码");

        private int code;
        private String context;


        NOTE_CODE(int code, String context) {
            this.code = code;
            this.context = context;
        }

        NOTE_CODE() {
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }
    }


    //用户状态
    @Getter
    public enum USER_STATUS{
        NOMAL("01","正常"),
        BREAK_FAITH("02","失信"),
        LOG_OUT("03","禁用");

        private String code;
        private String content;

        USER_STATUS(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //banner 类型
    @Getter
    public enum BANNER_CODE_TYPE{

        BANNER_DOCTOR("01","医生"),
        BANNER_USER("02","用户");

        private String code;
        private String content;

        BANNER_CODE_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    //就诊人关系 类型
    @Getter
    public enum PATIENT_RELATION_TYPE{

        ME("01","本人"),
        HUSBAND_AND_WIFE("02","夫妻"),
        PARENT("03","父母"),
        CHILD("04","子女"),
        BROTHERS_AND_SISTERS("05","兄弟姐妹"),
        OTHER_RELATIVES("06","其他亲属"),
        FRIEND("07","朋友");

        private String code;
        private String content;

        PATIENT_RELATION_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    /*
     * 证件类型
     * */
    @Getter
    public enum CERTIFICATE_TYPE{

        RESIDENT_IDENTITY_CARD("01","居民身份证"),
        OFFICER_ID("02","军官证(包含现役军人,人民武装警察)"),
        H_M_PASS("03","港澳居民来往内地通行证"),
        TAIWAN_PASS("04","台湾居民来往内地通行证"),
        PASSPORT("05","护照"),
        FOREIGNERS_IDENTITY_CARD("06","外国人永久居留身份证"),
        H_M_RESIDENCE_PERMIT("07","港澳居民居住证"),
        TAIWAN_RESIDENCE_PERMIT("08","台湾居民居住证");

        private String code;
        private String content;

        CERTIFICATE_TYPE(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

    /**
     * 日志操作来源
     */
    @Getter
    public enum LOG_OPERATION_SOURCE{

        USER("SOURCE_USER","患者端（用户端）"),
        DOCTOR("SOURCE_DOC","医生端"),
        PHARMACIST("SOURCE_PHA","药师端");

        private String code;
        private String desc;

        private LOG_OPERATION_SOURCE(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    /**
     * 日志返回状态
     */
    @Getter
    public enum LOG_RESULT_STATE{

        SUCCESS("success","成功"),
        ERROR("error","失败");

        private String code;
        private String desc;

        private LOG_RESULT_STATE(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    /**
     * 所有字典的名称
     */
    @Getter
    public enum BASE_DICT_NAME{

        GENDER("gender","性别"),
        BLOOD_TYPE("blood_type","血型"),
        LEVEL_OF_EDU("level_of_edu","学历"),
        JOB_TITLE("job_title","职称");

        private String code;
        private String content;

        BASE_DICT_NAME(String code, String content) {
            this.code = code;
            this.content = content;
        }
    }

}

package net.huayiyun.manbing.common.enums;

public enum ResultCodeEnum {

    SUCCESS_SERVICE(200, "业务处理成功"),
    SUCCESS_DATA_NULL(201, "查询不到数据"),
    SUCCESS_DATA_EXIST(202, "数据已存在"),
    FAIL_SERVICE(400, "业务处理失败"),
    FAIL_CALL(401, "调用服务失败"),
    ERROR_PARAM(501, "传入参数错误"),
    ERROR_AUTHENTICATION(502, "未登录"),
    ERROR_AUTHORIZATION(503, "没有权限"),
    ERROR_VALIDATION(504, "验证错误"),
    ERROR_EXPIRED_TOKEN(505, "token过期"),
    ERROR_REG_RESTRICTIONS(506, "挂号限制"),
    ERROR_REAL_NAME_VALIDATION(507, "用户实名认证失败"),
    ERROR_CREATE_HIS_ID(508, "用户没有预约也不是复诊用户"),
    ERROR_FILE(509, "文件上传异常"),
    ACCOUNT_DISABLED(511, "账号停用"),
    ORG_NULL(513, "无关联医院"),
    ACCOUNT_PUSHER_DOWN(514, "账号被顶下线"),
    ACCOUNT_SPURN_DOWN(515, "账号被踢下线"),
    SUCCESS_OTHER_PEOPLE_DATA(203, "数据被他人占用");

    private int code;
    private String context;

    public String getContext() {
        return this.context;
    }

    public int getCode() {
        return code;
    }

    private ResultCodeEnum(int _code, String _context) {
        this.code = _code;
        this.context = _context;
    }
}

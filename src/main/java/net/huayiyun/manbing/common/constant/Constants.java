package net.huayiyun.manbing.common.constant;



import java.util.HashMap;
import java.util.Map;

/**
 * 通用常量信息
 * 
 */
public class Constants
{

    public static Map<String,String> liquorKindMap = new HashMap<>();
    public static Map<String,String> laborTypeMap = new HashMap<>();
    public static Map<String,String> sportIntensityMap = new HashMap<>();
    public static Map<String,String> unitsMap = new HashMap<>();
    public static Map<String,String> takeMedicineMap = new HashMap<>();
    public static Map<String,String> dosesMap = new HashMap<>();
    public static Map<String,String> timePointMap = new HashMap<>();
    public static Map<String,String> sportFrequency = new HashMap<>();
    public static Map<String,String> sleepDuration = new HashMap<>();
    public static Map<String,String> tastePreference = new HashMap<>();

    //静态资源加载
    static {
        //生活习惯酒种类
        liquorKindMap.put("01","白酒");
        liquorKindMap.put("02","啤酒");
        liquorKindMap.put("03","红酒");
        liquorKindMap.put("04","黄酒");
        liquorKindMap.put("05","米酒");
        liquorKindMap.put("06","药酒");
        liquorKindMap.put("99","其他");
        //劳动类型
        laborTypeMap.put("01","脑力劳动");
        laborTypeMap.put("02","体力劳动");
        laborTypeMap.put("03","综合劳动");
        //运动强度
        sportIntensityMap.put("01","轻度");
        sportIntensityMap.put("02","中度");
        sportIntensityMap.put("03","重度");
        //用药,药品单位
        unitsMap.put("01","片/颗");
        unitsMap.put("02","mg");
        unitsMap.put("03","g");
        unitsMap.put("99","其他");
        //服药方式
        takeMedicineMap.put("01","口服");
        takeMedicineMap.put("02","皮下注射");
        takeMedicineMap.put("03","外用");
        takeMedicineMap.put("99","其他");
        //服药次数
        dosesMap.put("01","每日一次");
        dosesMap.put("02","每日两次");
        dosesMap.put("03","每日三次");
        dosesMap.put("99","其他");
        //血糖时间点
        timePointMap.put("01","空腹");
        timePointMap.put("02","早餐后");
        timePointMap.put("03","午饭前");
        timePointMap.put("04","午饭后");
        timePointMap.put("05","晚饭前");
        timePointMap.put("06","晚饭后");
        //运动习惯
        sportFrequency.put("01","不运动");
        sportFrequency.put("02","每周1~3次");
        sportFrequency.put("03","每周4~7次");
        sportFrequency.put("04","每周>7次");
        //睡眠时长
        sleepDuration.put("01","<3小时");
        sleepDuration.put("02","3~6小时");
        sleepDuration.put("03","6~8小时");
        sleepDuration.put("04",">8小时");
        //口味偏好
        tastePreference.put("01","重口味");
        tastePreference.put("02","普通");
        tastePreference.put("03","清淡");
    }

    //登录验证码
    public static final String LOGIN_VERIFICATION_CODE = "LOGIN_VERIFICATION_CODE_";

    //设置密码验证码
    public static final String SET_PASSWORD_VERIFICATION_CODE = "SET_PASSWORD_VERIFICATION_CODE_";

    //设置换绑手机号验证码
    public static final String UPDATE_PHONE_VERIFICATION_CODE = "UPDATE_PHONE_VERIFICATION_CODE_";

    //绑定用户手机号验证码
    public static final String BIND_USER_VERIFICATION_CODE = "BIND_USER_VERIFICATION_CODE_";

    //请求头 token
    public static final String TOKEN = "authorization";

    //获取文件接口前缀
    public static final String INTERFACE_PREFIX = "/wyApplets/user/file/";

    //小程序消息推送 电子围栏警告模板 id
    public static final String TEMPLATE_ID = "RLxcoWVw7PkA3er8H_H1uaT9UrYeYe-D4om3lF4NzXQ";

    //小程序消息推送 电子围栏警告跳转页面
    public static final String PAGE = "pages/pages/linepage/index";

    public static final String GRANT_TYPE = "authorization_code";
    //小程序appid
    public static final String APP_ID = "wxaf8bbcc7dd8bb879";
    //小程序 appSecret
    public static final String SECRET = "43cd128dc6a088f732d09d5eb2126216";
    //微信登录凭证校验地址
    public static final String AUTH_CODE2 =
            "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";

    //微信登录凭证校验地址
    public static final String AUTH_CODE2_SESSION =
            "https://api.weixin.qq.com";

    //微信登录凭证校验地址
    public static final String AUTH_CODE2_SESSION_PATH =
            "/sns/jscode2session";

    //微信登录凭证校验地址
    public static final String GET_ACCESS_TOKEN_URL =
            "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + SECRET;

    //redis accessToken
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    //微信发送订阅信息地址
    public static final String SUBSCRIBE_MESSAGE_SEND_URL =
            "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=";


    //MongoDB数据库表名 病例表
    //public static final String CASE = "case_av";
    //MongoDB数据库表名 聊天记录表
    //public static final String IM = "im";
    //根据链接获取图片详情
    //public static final String GETCASEPICURL = "http://localhost:8080/case/getFile?id=";
    //问诊排队 redis Key：QUEUE_docId_InquiryDiagId
    //public static final String QUEUE = "APP_QUEUE_";
    //排队默认时长 单位小时
    //public static final Long QUEUE_DEFULT_TIME = 24L;
    //问诊中 redis Key:INQUIRY_inquiryDiagId
    //public static final String INQUIRY = "APP_INQUIRY_";
    //问诊默认时长 单位分钟
    //public static final Long INQUIRY_TIME = 25L;
    //挂号 reis Key:REG_regRecordId
    //public static final String REG = "APP_REG_";

    //public static final String IMG_SUFFIX_JPG = ".jpg";

    //public static final String IMG_SUFFIX_PNG = ".png";

    // 列表分页 默认当前页
    //public static final String DEFAULT_PAGE = "1";

    // 列表分页 默认页数
    //public static final String CURRENT_PAGE = "1";

    // 列表分页 每页记录数
    //public static final int PAGE_SIZE = 10;

    // 统计列表 每页记录数
    //public static final int PAGE_SIZE_COUNT = 5;

    // 百分号字符
    //public static final String PER_CENT = "%";

    // 回车字符
    public static final String ENTER_STRING = "\r\n";

    /** 开发环境 */
    //public static final String DEV_ENVIRONMENT = "dev";
    /** 生产环境 */
    //public static final String PROD_ENVIRONMENT = "prod";
    /** 测试环境 */
    //public static final String TEST_ENVIRONMENT = "test";

    //二维码 文件名 前缀
    //public static final String PREFIX_QRCODE_FILENAME = "QRCode";

    //获取文件域名前缀 患者端
    // 公共华信小程序的 https://hyhlwyy-p.huayiyun.net
    //玉树的  https://yushu-p.huayiyun.net
    //测试的 https://thlwyy-p.huayiyun.net
    //复诊的
    private static String DOMAIN_PREFIX ;

    //下载文件接口前缀----只有用户端下载app的时候用到了,其他都用的是上面的接口
    public static final String DOWNLOAD_INTERFACE_PREFIX = "/hx/user/download/";

    //验证码前缀   key : verificationCode_13366666666
    public static final String VERIFICATION_CODE = "verificationCode_";



    //视频首帧
    //public static final String VFRAME = "vframe";

    //接口调用时间  用于记录接口访问时间的记录 CALL_TIME_userTel_userId
    //public static final String CALL_TIME = "CALL_TIME_";

    //允许过期时间(毫秒值)       30分钟
    //public static final long ALLOW_EXPIRATION_TIME = 30 * 60 * 1000 ;

    //评论字数限制
    //public static final int COMMENT_WORD_LIMIT = 100 ;

    //查询就诊记录天数
    public static final String DIAG_DAYS = "90";

    //科室的 docId 标志
    public static final String DEPT_DOC_ID = "0";

    //redis 锁号      LOCK_REG_SRC_regId
    public static final String LOCK_REG = "LOCK_REG_SRC_";

    //redis 锁号 回调时间     LOCK_REG_SRC_regid_CALLBACK
    public static final String LOCK_REG_CALLBACK = "_CALLBACK";

    //redis 锁号信息     LOCK_REG_SRC_regid_INFO
    public static final String LOCK_REG_INFO = "_INFO";

    //redis 锁号过期时间 单位:分钟 24分钟
    public static final long LOCK_EXPIRATION_TIME = 24;

    //redis 微信支付最少过期时间 单位：秒 5分钟
    public static final long WX_PAY_EXPIRATION_TIME = 300;//120

    //退号错误记录 key        ACTIVE_REFUND_ERROR_ + 时间戳
    public static final String ACTIVE_REFUND_ERROR = "ACTIVE_REFUND_ERROR_";

    //退钱申请错误记录 key        REFUND_APPLY_ERROR_ + 时间戳
    public static final String REFUND_APPLY_ERROR = "REFUND_APPLY_ERROR_";

    //退号查询过期 key        REFUND_QUERY + 商户订单号
    public static final String REFUND_QUERY = "REFUND_QUERY_";

    //退号查询记录 key        REFUND_QUERY_INFO + 商户订单号 + _INFO
    public static final String REFUND_QUERY_INFO = "_INFO";

    //处方支付 key 时效24小时        WAITPAID_regHisCode
    public static final String WAITPAID_ = "WAITPAID_";

    //检查检验支付 key 时效24小时        EXAMINE_regHisCode
    public static final String EXAMINE_ = "EXAMINE_";

    //处方退钱 过期key
    public static final String PRESC_REFUND = "PRESC_REFUND_";

    //处方退钱 info
    public static final String PRESC_REFUND_INFO = "PRESC_REFUND_INFO_";

    //检查检验退钱 过期key
    public static final String EXAMINE_TEST_REFUND = "EXAMINE_TEST_REFUND_";

    //检查检验退钱 info
    public static final String EXAMINE_TEST_REFUND_INFO = "EXAMINE_TEST_REFUND_INFO_";

    //默认传给HIS的就诊人手机号
    public static final String DEFAULT_PHONE = "62150866";

    //处方支付 redis 缓存信息 WX_PRESC_PAY_INFO_ + regHisCode
    public static final String WX_PRESC_PAY_INFO = "WX_PRESC_PAY_INFO_";

    //检查检验支付 redis 缓存信息 WX_EXAMINE_TEST_PAY_INFO + regHisCode
    public static final String WX_EXAMINE_TEST_PAY_INFO = "WX_EXAMINE_TEST_PAY_INFO_";

    //挂号限制 key        REGISTRATION_RESTRICTIONS_userId
    public static final String REGISTRATION_RESTRICTIONS = "REGISTRATION_RESTRICTIONS_";

    //订单关闭 key        ORDER_CLOSE_商家订单号
    public static final String ORDER_CLOSE = "ORDER_CLOSE_";

    //自定义流水号 后缀 支付商家号+00000 退款商家号+00000
    public static final String CUSTOM_SN_SUFFIX = "00000";

//    @Value("${domain.prefix}")
//    public void setDomainPrefix(String domainPrefix) {
//        DOMAIN_PREFIX = domainPrefix;
//    }

    public static String getDomainPrefix() {
        return DOMAIN_PREFIX;
    }

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 720;

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
}

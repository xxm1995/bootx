package common.constant;

/**
 * 状态码
 * 三位:系统错误
 * 五位:业务错误
 * 倒数一位: 0无,1有,2禁止,4重复,5错误,6失败
 * 倒数二位: 1用户,3微信支付,5微信,8,考试
 * @author xxm
 * @date 2018/12/10 15:07
 * @version V1.0
 */
public final class ConstantCodePool {
     /**
      *  成功
      */
     public final static int OK = 0;
     /**
      *  失败
      */
     public final static int FAIL = 1;

     /**
      *  没有权限，服务器受到请求但拒绝提供服务
      */
     public final static int NO_AUTH = 403;
     /**
      *  未登录
      */
     public final static int NOT_LOGIN = 405;

     /**
      *  服务器内部出错
      */
     public final static int ERREO= 500;


     /**
      *  没有绑定微信
      */
     public final static int WX_NOT_BIND= 10050;

     /**
      *  微信重复绑定
      */
     public final static int WX_REP_BIND = 10054;
     /**
      *  微信登录异常
      */
     public final static int WX_LOGIN_ERR= 10055;

     /**
      *  账户不存在
      */
     public final static int DONT_USER= 10010;
     /**
      *  账户被禁用
      */
     public final static int USER_PROHIBIT= 10012;
     /**
      *  账户登录错误
      */
     public final static int USER_LOGIN_ERR= 10015;
     /**
      *  账户或密码错误(登录失败)
      */
     public final static int USER_LOGIN_FAIL= 10016;

     /**
      *  考试不存在
      */
     public final static int DONT_EXAM= 10080;
     /**
      *  考试重复报名
      */
     public final static int EXAM_REP_REG= 10084;
     /**
      * 微信支付openid为空
      */
     public final static int OPEN_ID_NULL = 10030;

     /**
      * 未获取到prepayId
      */
     public final static int PREPAYID_NULL = 10036;
}

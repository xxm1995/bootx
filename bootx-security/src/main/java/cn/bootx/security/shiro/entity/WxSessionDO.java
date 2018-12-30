package cn.bootx.security.shiro.entity;

/**
 * 微信登录返回json对应do
 * @author xxm
 * @date 2018/11/27 9:37
 * @version V1.0
 */
public class WxSessionDO {
    /** 用户唯一标识 */
    private String openid;
    /** 会话密钥 */
    private String sessionKey;
    /** 用户在开放平台的唯一标识符 */
    private String unionId;
    /** 错误码 */
    private Integer errCode;
    /** 错误信息 */
    private String errMsg;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "WxSessionDO{" +
                "openid='" + openid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionId='" + unionId + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}

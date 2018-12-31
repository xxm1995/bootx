package cn.bootx.security.shiro.entity;

import lombok.Data;

/**
 * 微信登录返回json对应do
 * @author xxm
 * @date 2018/11/27 9:37
 * @version V1.0
 */
@Data
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
}

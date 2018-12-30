package cn.bootx.security.shiro.utils;

import cn.bootx.security.shiro.entity.WxSessionDO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 微信登录工具类
 * @author xxm
 * @date 2018/11/27 9:19
 * @version V1.0
 */
public final class WxLoginUtils {
    /**
     *  登录凭证校验
     * @param appid 小程序 appId
     * @param secret 小程序 appSecret
     * @param code 登录时获取的 code
     * @return WxSessionDO
     */
    public static WxSessionDO code2Session(String appid, String secret, String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+
                "&secret="+secret+
                "&js_code="+code+
                "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        WxSessionDO wxSessionDO = new WxSessionDO();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            String sessionData = responseEntity.getBody();
            JSONObject jsonObj = JSON.parseObject( sessionData );
            String openId = jsonObj.getString( "openid" );
            String sessionKey = jsonObj.getString( "session_key" );
            String unionId = jsonObj.getString( "unionid" );
            Integer errCode = jsonObj.getInteger( "errcode" );
            String errMsg = jsonObj.getString( "errmsg" );
            wxSessionDO.setOpenid( openId );
            wxSessionDO.setSessionKey( sessionKey );
            wxSessionDO.setUnionId( unionId );
            wxSessionDO.setErrCode( errCode );
            wxSessionDO.setErrMsg( errMsg );
        }else {
            wxSessionDO.setErrCode(400);
            wxSessionDO.setErrMsg( "network error" );
        }
        return wxSessionDO;
    }
}

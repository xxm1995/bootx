package cn.bootx.security.shiro.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
* 加密工具类
* @author xxm  
* @date 2018/12/31 13:23
* @version V1.0   
*/
@Component
public class EncryptUtils {
	/*盐值*/
	private static  String SALT;
	/*加密方式*/
	private static  String ALGORITH_NAME;
	/*加密次数*/
	private static  int HASH_ITERATIONS;

	@Value( "${bootx.security.encrypt.salt:bootx fork bootdo}" )
	public void setSALT(String salt) {
		SALT = salt;
	}
	@Value( "${bootx.security.encrypt.algorith:md5}" )
	public void setAlgorithName(String algorithName) {
		ALGORITH_NAME = algorithName;
	}
	@Value( "${bootx.security.encrypt.hashnum:2}" )
	public void setHashIterations(int hashIterations) {
		HASH_ITERATIONS = hashIterations;
	}
	/**
	 * 单密码加密
	 * @param pswd 密码
	 * @return	加密后的密码
	 */
	public static String encrypt(String pswd) {
		return new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
	}

	/**
	 * 账号和密码加密密码
	 * @param username 账号
	 * @param pswd 密码
	 * @return 加密后的密码
	 */
	public static String encrypt(String username, String pswd) {
		return new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
	}

	static String getSALT() {
		return SALT;
	}

	static String getAlgorithName() {
		return ALGORITH_NAME;
	}

	static int getHashIterations() {
		return HASH_ITERATIONS;
	}
}

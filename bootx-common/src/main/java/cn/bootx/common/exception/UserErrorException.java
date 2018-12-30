package cn.bootx.common.exception;
 /**   
  * 账号错误异常
  * @author xxm  
  * @date 2018/11/8 12:09 
  * @version V1.0   
  */
public class UserErrorException extends RuntimeException {
     public UserErrorException(String info) {
         super(info);
     }
     public UserErrorException(){}
}

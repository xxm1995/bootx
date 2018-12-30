package cn.bootx.common.exception;
 /**   
  * 账号未找到异常
  * @author xxm  
  * @date 2018/11/8 12:09 
  * @version V1.0   
  */
public class UserNotFoundException extends RuntimeException {
     public UserNotFoundException(String info) {
         super(info);
     }
     public UserNotFoundException(){}
}

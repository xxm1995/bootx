package common.exception;
 /**   
  * 账号重复异常
  * @author xxm  
  * @date 2018/11/8 12:09 
  * @version V1.0   
  */
public class UserRepeatException extends RuntimeException {
     public UserRepeatException(String info) {
         super(info);
     }
     public UserRepeatException(){}
}

package common.utils;


import common.domain.IDDO;

/**
  * 字符工具类
  * @author xxm
  * @date 2018/11/19 18:30
  * @version V1.0
  */
public abstract class IDUtils {
     /**
      * 返回唯一标示
      * @return long
      */
    public static long GUID(){
        return IdGen.GUID();
    }
     /**
      * 返回唯一标示
      * @return long
      */
     public static String UUID(){
         return String.valueOf(IdGen.GUID() );
     }
     /**
      * 返回唯一标示,包括字符串和long
      * @return long
      */
     public static IDDO ID(){
         long guid = IdGen.GUID();
         return new IDDO(guid,String.valueOf(guid));
     }
}

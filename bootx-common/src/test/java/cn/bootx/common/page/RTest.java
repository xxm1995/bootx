package cn.bootx.common.page;

import cn.bootx.common.domain.FileDO;
import org.junit.Test;
 /**   
  * 响应测试方法
  * @author xxm  
  * @date 2018/12/30 13:37
  * @version V1.0   
  */
import java.util.HashMap;

public class RTest {

    @Test
    public void R() {
        System.out.println(R.OK());
        System.out.println(R.ERROR());

    }

    @Test
    public void code() {
        System.out.println(R.OK().code( 666 ));
    }

    @Test
    public void msg() {
        System.out.println(R.OK().msg( null ));
        System.out.println(R.OK().msg( "hello" ));
    }

    @Test
    public void put() {
        System.out.println((R.OK().put(null,555)));
    }

    @Test
    public void putAll() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put( "name",658 );
        map.put( "id",33 );
        System.out.println(R.OK().putAll( map ).put( "1",66 ));
        System.out.println(R.OK().putAll( null ));
    }

    @Test
    public void putObj() {
        FileDO fileDO = new FileDO();
        fileDO.setId( "hello" );
        fileDO.setUrl( "www.bootx.cn" );
        System.out.println( R.OK().putObj( null ) );
        System.out.println( R.OK().putObj( fileDO ) );
    }
}
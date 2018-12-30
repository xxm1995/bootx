package common.page;

import common.domain.FileDO;
import org.junit.Test;

import java.util.HashMap;

public class RTest {

    @Test
    public void R() {
        System.out.println(R.ERROR());
        System.out.println(R.ERROR());
        System.out.println(R.ERROR().code( 66 ));

    }

    @Test
    public void code() {
        System.out.println(R.OK().code( 666 ));
    }

    @Test
    public void msg() {
    }

    @Test
    public void put() {
    }

    @Test
    public void putAll() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put( "name",658 );
        map.put( "id",33 );
        System.out.println(R.OK().putAll( map ).put( "1",66 ));
    }

    @Test
    public void putObj() {
        FileDO fileDO = new FileDO();
        fileDO.setId( 65L );
        fileDO.setUrl( "www.bootx.cn" );
        System.out.println( R.OK().putObj( fileDO ) );
    }
}
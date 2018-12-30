package cn.bootx.common.domain;
/**
 * id类
 * @author xxm
 * @date 2018/11/19 18:34
 * @version V1.0
 */
public final class IDDO {
    private long IDByLong;
    private String IDByStr;

    public IDDO(long IDByLong, String IDByStr) {
        this.IDByLong = IDByLong;
        this.IDByStr = IDByStr;
    }

    public long getIDByLong() {
        return IDByLong;
    }

    public String getIDByStr() {
        return IDByStr;
    }
}

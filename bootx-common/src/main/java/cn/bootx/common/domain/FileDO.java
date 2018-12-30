package cn.bootx.common.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件对象
 * @author xxm
 * @date 2018/12/30 16:21
 * @version V1.0
 */
@Data
public class FileDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    // 文件类型
    private Integer type;
    // URL地址
    private String url;
    // 创建时间
    private Date createDate;

}

package cn.bootx.common.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**   
* 基础Bean
* @author xxm  
* @date 2018/12/31 13:38
* @version V1.0   
*/
@Data
public class BaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 创建者 */
    @TableField( fill = FieldFill.INSERT)
    private String createBy;
    /** 创建时间 */
    @TableField( fill = FieldFill.INSERT)
    private Date createDate;
    /** 更新者 */
    @TableField( fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    /** 更新时间 */
    @TableField( fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
    /** 备注信息 */
    private String remarks;
    /** 删除标记 */
    @TableLogic
    private String delFlag;
}

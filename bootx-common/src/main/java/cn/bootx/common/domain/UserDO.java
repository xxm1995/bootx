package cn.bootx.common.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  用户表
 * @author xxm
 * @date 2018/12/30 16:23
 * @version V1.0
 */
@Data
@TableName("sys_user")
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;
    /** id */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    /** 账号名称 */
    private String username;
    /** 用户真实姓名 */
    private String name;
    /** 密码 */
    private String password;
    /** 用户类别 */
    private String userType;
    /** 用户头像 */
    private String avatar;
    /** 状态 0:禁用，1:正常 */
    private Integer status;
    /** 创建用户id */
    @TableField( fill = FieldFill.INSERT)
    private String userIdCreate;
    /** 创建时间 */
    @TableField( fill = FieldFill.INSERT)
    private Date gmtCreate;
    /** 修改时间 */
    @TableField( fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
    /** 删除标记 */
    @TableLogic
    private String delFlag;


}

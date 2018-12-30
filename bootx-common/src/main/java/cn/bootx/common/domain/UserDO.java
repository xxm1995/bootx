package cn.bootx.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  用户表
 * @author xxm
 * @date 2018/12/30 16:23
 * @version V1.0
 */
@Data
@TableName("sys_user")
public class UserDO extends BaseBean {
    private static final long serialVersionUID = 1L;
    /** id */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    /** 账号名称 */
    private String username;
    /** 用户真实姓名 */
    private String realName;
    /** 密码 */
    private String password;
    /** 用户类别 */
    private String userType;
    /** 用户头像 */
    private String avatar;
    /** 状态 0:禁用，1:正常 */
    private Integer status;
}

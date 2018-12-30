package cn.bootx.system.dao;


import cn.bootx.common.domain.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户dao
 * @author xxm
 * @date 2018/12/30 14:39
 * @version V1.0
 */
@Mapper
public interface UserDao extends BaseMapper<UserDO> {

}

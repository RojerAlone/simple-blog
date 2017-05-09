package cn.alone.mapper;

import cn.alone.pojo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Alone on 2017/3/28.
 */
@MapperScan
public interface UserMapper {

    int insert(User user);
    User selectById(Integer id);
    User selectByName(String name);
    List<User> selectByStat(Integer stat);
    int update(User user);

}

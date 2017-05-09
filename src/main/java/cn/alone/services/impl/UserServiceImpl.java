package cn.alone.services.impl;

import cn.alone.mapper.UserMapper;
import cn.alone.pojo.User;
import cn.alone.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alone on 2017/3/28.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public boolean register(User user) {
        // 不允许出现重名的用户
        if (userMapper.selectByName(user.getUsername()) == null) {
            return userMapper.insert(user) == 1 ? true : false;
        }
        return false;
    }

    /**
     * 删除用户，不是物理删除，只是改变用户状态为不可用
     * @param uid
     * @return
     */
    public int delUser(Integer uid) {
        User user = new User();
        user.setUid(uid);
        user.setStat(User.STAT_NO);
        return userMapper.update(user);
    }

    public int auditUser(Integer uid) {
        User user = new User();
        user.setUid(uid);
        user.setStat(User.STAT_YES);
        return userMapper.update(user);
    }

    public User selectById(Integer userId) {
        return userMapper.selectById(userId);
    }

    public List<User> selectByStat(Integer stat) {
        return userMapper.selectByStat(stat);
    }

    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public boolean update(User user) {
        return userMapper.update(user) == 1 ? true : false;
    }

    public boolean login(String name, String password) {
        User user = userMapper.selectByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

package cn.alone.services;

import cn.alone.pojo.User;

import java.util.List;

/**
 * Created by Alone on 2017/3/28.
 */
public interface IUserService {

    public boolean register(User user);
    public int delUser(Integer uid);
    public int auditUser(Integer uid);
    public User selectByName(String name);
    public User selectById(Integer userId);
    public List<User> selectByStat(Integer stat);
    public boolean update(User user);
    public boolean login(String name, String password);

}

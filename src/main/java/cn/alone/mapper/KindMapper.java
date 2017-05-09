package cn.alone.mapper;

import cn.alone.pojo.Kind;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/6.
 */
public interface KindMapper {

    int insert(Kind kind);
    int deleteById(Integer kid);
    Kind selectById(Integer kid);
    int selectByName(String name);
    List<Kind> selectAll();
    int update(Kind kind);

}

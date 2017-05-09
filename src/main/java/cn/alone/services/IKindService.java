package cn.alone.services;

import cn.alone.pojo.Kind;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/9.
 */
public interface IKindService {

    public int addKind(Kind kind);
    public int delKind(Integer kid);
    public List<Kind> getAllKind();
    public Kind selectById(Integer kid);
    public int update(Kind kind);

}

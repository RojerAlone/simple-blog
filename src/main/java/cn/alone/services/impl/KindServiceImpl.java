package cn.alone.services.impl;

import cn.alone.mapper.BlogMapper;
import cn.alone.mapper.KindMapper;
import cn.alone.pojo.Kind;
import cn.alone.services.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/9.
 */
@Service
public class KindServiceImpl implements IKindService {

    @Autowired
    private KindMapper kindMapper;
    @Autowired
    private BlogMapper blogMapper;

    /**
     * 不可以添加重名的类别，但是可以修改成重名的
     * @param kind
     * @return
     */
    @Transactional
    public int addKind(Kind kind) {
        if (kindMapper.selectByName(kind.getName()) == 0) {
            return kindMapper.insert(kind);
        }
        return 0;
    }

    public int delKind(Integer kid) {
        return kindMapper.deleteById(kid);
    }

    @Transactional
    public List<Kind> getAllKind() {
        List<Kind> kinds = kindMapper.selectAll();
        for (Kind kind : kinds) {
            kind.setNums(blogMapper.getNumsByKind(kind.getKid()));
        }
        return kinds;
    }

    public Kind selectById(Integer kid) {
        return kindMapper.selectById(kid);
    }

    /**
     * 更新类别，可以重名，但是不可以添加重名的
     * @param kind
     * @return
     */
    public int update(Kind kind) {
        return kindMapper.update(kind);
    }
}

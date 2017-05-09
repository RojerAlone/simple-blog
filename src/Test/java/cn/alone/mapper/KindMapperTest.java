package cn.alone.mapper;

import cn.alone.pojo.Kind;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RojerAlone on 2017/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-dao.xml"})
public class KindMapperTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private KindMapper mapper;
    @Test
    public void insert() throws Exception {
        Kind kind = new Kind();
        kind.setName("java");
        kind.setLevel(1);
        try {
            if (1 == mapper.insert(kind)) {
                logger.info("插入成功");
            } else {
                logger.info("插入失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void deleteById() throws Exception {
        int id = 1;
        try {
            if (1 == mapper.deleteById(id)) {
                logger.info("删除成功");
            } else {
                logger.info("删除失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectById() throws Exception {
        int id = 2;
        try {
            Kind kind = mapper.selectById(id);
            if (kind != null) {
                logger.info("查询成功");
                System.out.println(kind);
            } else {
                logger.info("查询失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectByName() throws Exception {
        String name = "Java";
        try {
            int num = mapper.selectByName(name);
            logger.info(name + "的个数有：" + num + " 个");
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectAll() throws Exception {
        try {
            List<Kind> kinds = mapper.selectAll();
            logger.info("查询成功");
            System.out.println(kinds);
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void update() throws Exception {
        Kind kind = new Kind();
        kind.setKid(2);
        kind.setLevel(9);
        try {
            if (1 == mapper.update(kind)) {
                logger.info("更新成功");
            } else {
                logger.info("更新失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}
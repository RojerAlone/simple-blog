package cn.alone.services;

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
 * Created by RojerAlone on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml"})
public class IKindServiceTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IKindService service;
    @Test
    public void addKind() throws Exception {
        Kind kind = new Kind();
        kind.setName("Java");
        kind.setLevel(1);
        try {
            if (service.addKind(kind) == 1) {
                logger.info("添加成功，kid为：" + kind.getKid());
            } else {
                logger.info("添加失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void delKind() throws Exception {
        int id = 4;
        try {
            if (service.delKind(id) == 1) {
                logger.info("删除成功");
            } else {
                logger.info("删除失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void getAllKind() throws Exception {
        try {
            List<Kind> kinds = service.getAllKind();
            if (kinds == null || kinds.size() == 0) {
                logger.info("查询失败");
            } else {
                logger.info("查询成功");
                System.out.println(kinds);
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

    @Test
    public void selectById() throws Exception {
        int id = 2;
        try {
            Kind kind = service.selectById(id);
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
    public void update() throws Exception {
        Kind kind = new Kind();
        kind.setKid(3);
        kind.setName("java");
        try {
            if (service.update(kind) == 1) {
                logger.info("更改成功");
            } else {
                logger.info("更改失败");
            }
        } catch (Exception e) {
            logger.error("错误", e);
        }
    }

}
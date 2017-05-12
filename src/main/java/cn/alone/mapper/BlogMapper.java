package cn.alone.mapper;

import cn.alone.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/4.
 */
public interface BlogMapper {

    int insert(Blog blog);
    Blog selectById(Integer bid);
    Blog selectKeyInfoById(Integer bid);// 搜索关键信息，如标题、作者、时间、点击数和评论数
//    List<Blog> selectByUp();            // 获取置顶文章     包含在selectOnePage里，不需要单独获取
    List<Blog> selectByComment();       // 搜索评论最多的5篇文章
    List<Blog> selectByClicked();       // 搜索点击量最多的5篇文章
    List<Blog> selectOnePage(@Param("startPos") Integer startPos, @Param("size") Integer size);
    List<Blog> selectBlogsByKind(@Param("kind") Integer kind, @Param("startPos") Integer startPos, @Param("size") Integer size);
    int getBlogNums();
    int getNumsByKind(Integer kind);
    int update(Blog blog);
    int updateClicked(Integer bid);        // 点击数+1
    int updateUp(Integer bid);             // 更新点赞次数
    int updateComment(Integer bid);        // 更新评论个数

}

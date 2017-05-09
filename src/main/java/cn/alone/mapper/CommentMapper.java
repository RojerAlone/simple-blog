package cn.alone.mapper;

import cn.alone.pojo.Comment;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/8.
 */
public interface CommentMapper {
    int insert(Comment comment);
    List<Comment> selectByBid(Integer bid);
    List<Comment> selectByStat(int stat);
    int update(Comment comment);
}

package cn.alone.services;

import cn.alone.pojo.Comment;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/9.
 */
public interface ICommentService {

    public boolean comment(Comment comment);
    public boolean delComment(Integer cid);
    public List<Comment> getBlogComment(Integer bid);
    public List<Comment> getAuditComment();
    public boolean auditComment(Integer cid);

}

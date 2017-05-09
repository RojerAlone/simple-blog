package cn.alone.services.impl;

import cn.alone.mapper.BlogMapper;
import cn.alone.mapper.CommentMapper;
import cn.alone.pojo.Comment;
import cn.alone.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/9.
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Transactional
    public boolean comment(Comment comment) {
        if (commentMapper.insert(comment) == 1) {
            blogMapper.updateComment(comment.getBid());
            return true;
        }
        return false;
    }

    public boolean delComment(Integer cid) {
        Comment comment = new Comment();
        comment.setCid(cid);
        comment.setStat(Comment.STAT_DEL);
        return commentMapper.update(comment) == 1 ? true : false;
    }

    public List<Comment> getBlogComment(Integer bid) {
        return commentMapper.selectByBid(bid);
    }

    public List<Comment> getAuditComment() {
        return commentMapper.selectByStat(Comment.STAT_AUDIT);
    }

    public boolean auditComment(Integer cid) {
        Comment comment = new Comment();
        comment.setCid(cid);
        comment.setStat(Comment.STAT_PUBLIC);
        return commentMapper.update(comment) == 1 ? true : false;
    }
}

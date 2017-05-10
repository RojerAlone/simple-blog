package cn.alone.pojo.dto;

import cn.alone.pojo.Blog;
import cn.alone.pojo.Comment;

/**
 * Created by RojerAlone on 2017/4/23.
 */
public class BlogDTO {

    private Blog blog;
    private String username;
    private Comment comment;
    private String kind;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}

package cn.alone.pojo;

import java.sql.Timestamp;

/**
 * Created by Alone on 2017/4/2.
 */
public class Blog {

    public static final int STAT_PUBLIC = 0;    // 公开
    public static final int STAT_PRIVATE = 1;   // 私密文章
    public static final int STAT_DEL = 2;       // 已删除

    private Integer bid;
    private String title;
    private String content;
    private Integer kind;
    private Integer up;         // 是否置顶
    private Integer uid;
    private Timestamp ctime;
    private Timestamp utime;
    private Timestamp ptime;    // 发表时间
    private Integer stat;
    private Integer clicked;
    private Integer comments;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Timestamp getUtime() {
        return utime;
    }

    public void setUtime(Timestamp utime) {
        this.utime = utime;
    }

    public Timestamp getPtime() {
        return ptime;
    }

    public void setPtime(Timestamp ptime) {
        this.ptime = ptime;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getClicked() {
        return clicked;
    }

    public void setClicked(Integer clicked) {
        this.clicked = clicked;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", kind=" + kind +
                ", up=" + up +
                ", uid=" + uid +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", stat=" + stat +
                ", clicked=" + clicked +
                ", comments=" + comments +
                '}';
    }
}

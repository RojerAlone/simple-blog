package cn.alone.pojo;

import java.sql.Timestamp;

/**
 * Created by Alone on 2017/4/2.
 */
public class Comment {

    public static final int STAT_AUDIT = 0;     // 待审核
    public static final int STAT_PUBLIC = 1;    // 公开
    public static final int STAT_DEL = 2;       // 删除

    private Integer cid;
    private Integer bid;
    private Integer uid;
    private String content;
    private String ip;
    private Timestamp ctime;
    private Timestamp utime;
    private Integer stat;
    private Integer up;
    private Integer down;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", bid=" + bid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", ip='" + ip + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", stat=" + stat +
                ", up=" + up +
                ", down=" + down +
                '}';
    }
}

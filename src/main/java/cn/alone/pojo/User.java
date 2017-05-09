package cn.alone.pojo;

import java.sql.Timestamp;

/**
 * Created by Alone on 2017/3/27.
 */
public class User {

    public static final int STAT_NO = 0;
    public static final int STAT_YES = 1;

    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Long phone;
    private Timestamp ctime;
    private Timestamp utime;
    private int stat; // 0表示不可以使用，1表示可以使用

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
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

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", stat=" + stat +
                '}';
    }
}

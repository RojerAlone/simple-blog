package cn.alone.pojo;

import java.sql.Timestamp;

/**
 * Created by Alone on 2017/4/2.
 */
public class Kind {
    private Integer kid;
    private String name;
    private Integer level;
    private Timestamp ctime;
    private Timestamp utime;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    @Override
    public String toString() {
        return "Kind{" +
                "kid=" + kid +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", ctime=" + ctime +
                ", utime=" + utime +
                '}';
    }
}

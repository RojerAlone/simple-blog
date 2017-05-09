package cn.alone.pojo.dto;

import cn.alone.pojo.Blog;
import cn.alone.pojo.User;

/**
 * Created by RojerAlone on 2017/4/23.
 */
public class BlogResult<T> {

    private boolean success;       // 是否执行成功
    private T data;                 // 执行成功的话返回的数据
    private String info;            // 错误的话错误信息

    public BlogResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public BlogResult(boolean success, String info) {
        this.success = success;
        this.info = info;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

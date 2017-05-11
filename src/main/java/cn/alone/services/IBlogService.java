package cn.alone.services;

import cn.alone.pojo.Blog;
import cn.alone.pojo.dto.BlogDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/4/9.
 */
public interface IBlogService {

    public int write(Blog blog);
    public boolean delBlog(Integer bid);
    public BlogDTO selectById(Integer bid);
    public List<Blog> getByPage(Integer startPage);
    public List<Blog> getBlogsOfKind(Integer kind, Integer startPage);
    public Map<String, List<BlogDTO>> getIndexBlogs();
    public int getNumsOfKind(Integer kind);
    public boolean privateBlog(Integer bid);
    public boolean update(Blog blog);
    public int getNumOfBlogs();

}

package cn.alone.services.impl;

import cn.alone.mapper.BlogMapper;
import cn.alone.pojo.Blog;
import cn.alone.services.IBlogService;
import cn.alone.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RojerAlone on 2017/4/9.
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogMapper blogMapper;

    public int write(Blog blog) {
        return blogMapper.insert(blog);
    }

    /**
     * 删除文章，不进行物理删除，只时把文章状态设为已删除
     * @param bid
     * @return
     */
    public boolean delBlog(Integer bid) {
        Blog blog = new Blog();
        blog.setBid(bid);
        blog.setStat(Blog.STAT_DEL);
        return blogMapper.update(blog) == 1 ? true : false;
    }

    @Transactional  // 声明为一个事务，默认出现RuntimeException会回滚
    public Blog selectById(Integer bid) {
        Blog blog = blogMapper.selectById(bid);
        if (blog != null) { // 查询到结果以后，对点击数进行更新
            blogMapper.updateClicked(bid);  // 点击数+1
        }
        return blog;
    }

    /**
     * 根据页码信息获取文章列表
     * @param startPage
     * @return
     */
    @Transactional
    public List<Blog> getByPage(Integer startPage) {
        PageUtil page = new PageUtil(blogMapper.getBlogNums(), startPage);
        return blogMapper.selectOnePage(page.getStartPos(), page.getSize());
    }

    /**
     * 根据种类和文章的页数获取文章
     * @param kind
     * @param startPage
     * @return
     */
    @Transactional
    public List<Blog> getBlogsOfKind(Integer kind, Integer startPage) {
        PageUtil page = new PageUtil(blogMapper.getNumsByKind(kind), startPage);
        return blogMapper.selectBlogsByKind(kind, page.getStartPos(), page.getSize());
    }

    /**
     * 获取某类文章的个数
     * @param kind
     * @return
     */
    public int getNumsOfKind(Integer kind) {
        return blogMapper.getNumsByKind(kind);
    }

    /**
     * 将文章设为私密文章
     * @param bid
     * @return
     */
    public boolean privateBlog(Integer bid) {
        Blog blog = new Blog();
        blog.setBid(bid);
        blog.setStat(Blog.STAT_PRIVATE);
        return blogMapper.update(blog) == 1 ? true : false;
    }

    /**
     * 更新文章
     * @param blog
     * @return
     */
    public boolean update(Blog blog) {
        return blogMapper.update(blog) == 1 ? true : false;
    }

    public int getNumOfBlogs() {
        return blogMapper.getBlogNums();
    }
}

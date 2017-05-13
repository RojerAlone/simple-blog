package cn.alone.services.impl;

import cn.alone.mapper.BlogMapper;
import cn.alone.mapper.KindMapper;
import cn.alone.mapper.UserMapper;
import cn.alone.pojo.Blog;
import cn.alone.pojo.dto.BlogDTO;
import cn.alone.services.IBlogService;
import cn.alone.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/4/9.
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private KindMapper kindMapper;

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
    public BlogDTO selectById(Integer bid) {
        Blog blog = blogMapper.selectById(bid);
        if (blog != null) { // 查询到结果以后，对点击数进行更新
            blogMapper.updateClicked(bid);  // 点击数+1
        }
        BlogDTO res = new BlogDTO();
        res.setBlog(blog);
        if (blog.getKind() != null) {
            res.setKind(kindMapper.selectById(blog.getKind()).getName());
        }
        res.setUsername(userMapper.selectById(blog.getUid()).getNickname());
        return res;
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

    @Transactional
    public Map<String, List<BlogDTO>> getIndexBlogs() {
        Map<String, List<BlogDTO>> res = new HashMap<String, List<BlogDTO>>();
        // 获取热门文章
        List<Blog> hotBlogs = blogMapper.selectByClicked();
        List<BlogDTO> hotBlogDTO = new ArrayList<BlogDTO>();
        for (Blog blog : hotBlogs) {
            BlogDTO dto = new BlogDTO();
            dto.setBlog(blog);
            dto.setUsername(userMapper.selectById(blog.getUid()).getNickname());
            if (blog.getKind() != null) {
                dto.setKind(kindMapper.selectById(blog.getKind()).getName());
            }
            hotBlogDTO.add(dto);
        }
        res.put("hotBlogs", hotBlogDTO);
        // 获取文章第一页
        List<Blog> firstPage = this.getByPage(1);
        List<BlogDTO> firstPageDto = new ArrayList<BlogDTO>();
        for (Blog blog : firstPage) {
            BlogDTO dto = new BlogDTO();
            dto.setBlog(blog);
            dto.setUsername(userMapper.selectById(blog.getUid()).getNickname());
            if (blog.getKind() != null) {
                dto.setKind(kindMapper.selectById(blog.getKind()).getName());
            }
            firstPageDto.add(dto);
        }
        res.put("firstPage", firstPageDto);
        return res;
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

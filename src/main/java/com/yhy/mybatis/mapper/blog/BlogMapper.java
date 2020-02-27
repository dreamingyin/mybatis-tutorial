package com.yhy.mybatis.mapper.blog;

import com.yhy.mybatis.bean.Blog;

import java.util.List;
import java.util.Map;

/**
 * @FileName: BlogMapper
 * @Author Steven
 * @Date: 2020/2/27
 */
public interface BlogMapper {

    //新增一个博客
    int addBlog(Blog blog);

    //需求1
    List<Blog> queryBlogIf(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}

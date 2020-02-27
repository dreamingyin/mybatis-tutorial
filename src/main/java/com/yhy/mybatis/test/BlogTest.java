package com.yhy.mybatis.test;

import com.yhy.mybatis.bean.Blog;
import com.yhy.mybatis.mapper.blog.BlogMapper;
import com.yhy.mybatis.util.IDUtil;
import com.yhy.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @FileName: BlogTest
 * @Author Steven
 * @Date: 2020/2/27
 */
public class BlogTest {

    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void testQueryBlogIf(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Mybatis如此简单");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);

        System.out.println(blogs);

        session.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","秦疆");
        map.put("id","b1c6a7b4e4a64319b3889f59ecf89bed");

        mapper.updateBlog(map);


        session.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","Spring如此简单");
        map.put("author","狂神说");
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        System.out.println(blogs);

        session.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        session.close();
    }
}

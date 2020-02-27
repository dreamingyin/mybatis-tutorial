package com.yhy.mybatis.test;

import com.yhy.mybatis.bean.User;
import com.yhy.mybatis.mapper.user.UserMapper;
import com.yhy.mybatis.mapper.user.UserMapperAnnotation;
import com.yhy.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName: UserTest
 * @Author Steven
 * @Date: 2020/2/27
 */
public class UserTest {

    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(UserTest.class);
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一:
        //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testSelectUserById() {
        //获取SqlSession连接
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public  void selectUserByNP2(){
        //获取SqlSession连接
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","狂神");
        map.put("pwd","asdfgh");
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(5,"王五","zxcvbn");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        user.setPwd("asdfgh");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser(5);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void selectUser1() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    //分页查询 , 两个参数startIndex , pageSize
    @Test
    public void testSelectUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        //第几页
        int currentPage = 1;
        //每页显示几个
        int pageSize = 2;
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<User> users = mapper.selectUser1(map);

        for (User user: users){
            System.out.println(user);
        }

        session.close();
    }

    /*MyBatis：使用注解开发*/
    @Test
    public void testGetAllUser() {
        SqlSession session = MybatisUtils.getSession();
        //本质上利用了jvm的动态代理机制
        UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);

        List<User> users = mapper.getAllUser();
        for (User user : users){
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testSelectUserByIds() {
        SqlSession session = MybatisUtils.getSession();
        UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);

        User user = mapper.selectUserById(1);
        System.out.println(user);

        session.close();
    }

    @Test
    public void testAddUsers() {
        SqlSession session = MybatisUtils.getSession();
        UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);

        User user = new User(7, "秦疆", "123456");
        mapper.addUser(user);

        session.close();
    }

    @Test
    public void testUpdateUsers() {
        SqlSession session = MybatisUtils.getSession();
        UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);

        User user = new User(6, "秦疆", "zxcvbn");
        mapper.updateUser(user);

        session.close();
    }

    @Test
    public void testDeleteUsers() {
        SqlSession session = MybatisUtils.getSession();
        UserMapperAnnotation mapper = session.getMapper(UserMapperAnnotation.class);

        mapper.deleteUser(7);

        session.close();
    }

    @Test
    public void testQueryUserById(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session2.close();
    }

}

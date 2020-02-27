package com.yhy.mybatis.test;

import com.yhy.mybatis.bean.Teacher;
import com.yhy.mybatis.mapper.teacher.TeacherMapper;
import com.yhy.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @FileName: TeacherTest
 * @Author Steven
 * @Date: 2020/2/27
 */
public class TeacherTest {

    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }

    @Test
    public void testGetTeacher2(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
}

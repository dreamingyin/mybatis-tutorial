package com.yhy.mybatis.test;

import com.yhy.mybatis.bean.Student;
import com.yhy.mybatis.mapper.student.StudentMapper;
import com.yhy.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @FileName: StudentTest
 * @Author Steven
 * @Date: 2020/2/27
 */
public class StudentTest {

    @Test
    public void testGetStudents(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents();

        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }

    @Test
    public void testGetStudents2(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();

        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }
}

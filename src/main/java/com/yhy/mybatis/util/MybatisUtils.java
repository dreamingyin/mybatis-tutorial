package com.yhy.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @FileName: MybatisUtils
 * @Author Steven
 * @Date: 2020/2/27
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession连接
    public static SqlSession getSession(){
        //事务自动提交
        return getSession(true);
    }

    public static SqlSession getSession(boolean flag){
        return sqlSessionFactory.openSession(flag);
    }
}

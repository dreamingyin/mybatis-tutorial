package com.yhy.mybatis.mapper.user;

import com.yhy.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @FileName: UserMapper
 * @Author Steven
 * @Date: 2020/2/27
 */
public interface UserMapper {
    List<User> selectUser();
    //根据id查询用户
    User selectUserById(int id);

    User selectUserByNP2(Map<String,Object> map);

    //添加一个用户
    int addUser(User user);

    //修改一个用户
    int updateUser(User user);

    //根据id删除用户
    int deleteUser(int id);

    List<User> selectUser1(Map<String,Integer> map);


    //根据id查询用户
    User queryUserById(@Param("id") int id);
}

/**
 * @author: mao
 * @description
 * @date: 2024/4/7 17:40
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper;

import com.mao.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper2 {

    List<User> selectAllUser();

    /**
     * 三种传和获取的方式
     * 1 直接传参，使用@Param注解
      */
    int removeUser(@Param("id") int id);

    List<User> selectUserByUserInfo(User user);

    int insertIntoUser(User user);

    List<User> selectUserByUserInfo2(User user);

     int updateUser(User user);

    List<User> selectUserByUserInfo6(User user);

    // id的数组
    List<User> selectUserByIds(@Param("ids") List<Integer> ids);

    // int insertIntoUser2(@Param("users") ArrayList<User> users);

    List<User> selectUserSkill(@Param("u_id") int uid);

    int insertUser2(@Param("users") ArrayList<User> users);
}

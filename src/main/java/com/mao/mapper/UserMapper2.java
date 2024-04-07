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

import java.util.List;

public interface UserMapper2 {

    List<User> selectAllUser();

    /**
     * 三种传和获取的方式
     * 1 直接传参，使用@Param注解
      */
    int removeUser(@Param("id") int id);
}

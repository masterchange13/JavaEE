/**
 * @author: mao
 * @description
 * @date: 2024/3/28 17:01
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper;

import com.mao.bean.User;

import java.util.List;

public interface TestJdbcDao {
    List<User> selectAllUser();

    User selectOne(User user);
}

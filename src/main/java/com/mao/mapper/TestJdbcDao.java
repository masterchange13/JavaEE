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
import org.springframework.stereotype.Repository;

import java.util.List;

    public interface TestJdbcDao {
    List<User> selectAllUser();

    User selectOne(User user);

//    插入一条数据,返回值为影响行数
    int addUser(User user);

//    批量插入多条数据
    int[] batchAddUser(List<Object[]> users);

//    void transfer(int a_id, int b_id);

}

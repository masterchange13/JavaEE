/**
 * @author: mao
 * @description
 * @date: 2024/3/28 17:03
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper.Impl;

import com.mao.bean.User;
import com.mao.mapper.TestJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestJdbcDaoImpl implements TestJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> selectAllUser() {
        String sql = "selecet * from user";
        List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return result;
    }

    public User selectOne(User user) {
        String sql = "select * from user where u_id = ?";
        jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getU_id());
        return null;
    }
}

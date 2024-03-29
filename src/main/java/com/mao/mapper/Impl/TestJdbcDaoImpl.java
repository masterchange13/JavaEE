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
import org.springframework.jdbc.core.SqlInOutParameter;
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
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getU_id());
    }

    public int addUser(User user) {
        String sql = "insert into user (u_name, u_age, u_sex, u_phone, u_birth) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getU_name(), user.getU_age(), user.getU_sex(), user.getU_phone(), user.getU_birth());
    }

    public int[] batchAddUser(List<Object[]> users) {
        String sql = "insert into user (u_name, u_age, u_sex, u_phone, u_birth) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.batchUpdate(sql, users);
    }


//    public void transfer(int a_id, int b_id) {
//        String sql = "select u_money from user where u_id = ?";
//        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), a_id);
//        if (user.getU_money().doubleValue() >= 999) {
//            System.out.println("账户余额充足，开始扣款");
//            String sql1 = "update user set u_money = u_money - 1000 where u_id = ?";
//            int res = jdbcTemplate.update(sql1, a_id);
//            if (res > -1) {
//                System.out.println("扣款成功");
//                String sql2 = "select * from user where u_id = ?";
//                    User user1 = jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<User>(User.class), b_id);
//                if (user1 == null) {
//                    System.out.println("收款账户不成功");
//                }else{
//                    String sql3 = "update user set u_money = u_money+1000 where u_id = ?";
//                    int res1 = jdbcTemplate.update(sql4, b_id);
//                    if (res1 > 0) {
//                        System.out.println("增加999元");
//                    }
//                }
//            }
//        }
//    }
}

/**
 * @author: mao
 * @description
 * @date: 2024/3/28 16:23
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper.Impl;

import com.mao.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestMapperImpl {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    public void add() {
        System.out.println("添加方法");
    }

    public void delete() {
        System.out.println("删除方法");
    }

    public void modify() {
        System.out.println("修改方法");
    }

    public void show() {

    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = -1, readOnly = false)
    public void transfer(int a_id, int b_id) {
        String sql = "select u_money from user where u_id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), a_id);
        if (user.getU_money().doubleValue() >= 1000 ) {
            System.out.println("账户余额充足，开始扣款");
            String sql1 = "update user set u_money = u_money - 1000 where u_id = ?";
            int res = jdbcTemplate.update(sql1, a_id);
            if (res > -1) {
                System.out.println("扣款成功");
//                需要对目标对象做匹配,确保用户存在，空值预防
                String sql2 = "select * from user where u_id = ?";
                User user1 = jdbcTemplate.queryForObject(sql2, new BeanPropertyRowMapper<User>(User.class), b_id);
                if (user1 == null) {
                    System.out.println("收款账户不成功");
                    throw new RuntimeException("目标用户不存在，执行退款");
                } else {
                    String sql3 = "update user set u_money = u_money+1000 where u_id = ?";
                    int res1 = jdbcTemplate.update(sql3, b_id);
                    if (res1 > 0) {
                        System.out.println("增加1000元");
                    }
                }
            }
        }else {
            throw new RuntimeException("账户余额不足，扣款失败");
        }

    }
}

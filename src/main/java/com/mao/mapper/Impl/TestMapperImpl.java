/**
 * @author: mao
 * @description
 * @date: 2024/3/28 16:23
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper.Impl;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.stereotype.Component;

@Component
public class TestMapperImpl {
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
}

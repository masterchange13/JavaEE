/**
 * @author: mao
 * @description
 * @date: 2024/3/28 10:36
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int u_id;
    private String u_name;
    private int u_age;
    private String u_sex;
    private String u_phone;
    private String u_birth;
    private List<String> hobbies;
    private Map<String, String> map;
}

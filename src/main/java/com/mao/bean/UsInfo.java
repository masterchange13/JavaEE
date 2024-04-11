/**
 * @author: mao
 * @description
 * @date: 2024/4/11 18:29
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsInfo {
    private int us_id;
    private int u_id;
    private int s_id;
    private UsInfo usInfo;
}

/**
 * @author: mao
 * @description
 * @date: 2024/3/29 19:14
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
    private int p_id;
    private String p_name;
    private BigDecimal p_price;
    private int p_num;
    private String p_info;
}

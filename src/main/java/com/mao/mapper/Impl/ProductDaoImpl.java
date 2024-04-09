/**
 * @author: mao
 * @description
 * @date: 2024/3/29 19:13
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper.Impl;

import com.mao.bean.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class ProductDaoImpl {
    private static Map<String, Product> products = null;

    static {
        products = new HashMap<String, Product>();

        Product product = new Product();
        product.setP_id(1);
        product.setP_name("巧克力");
        product.setP_price(new BigDecimal(200));
        product.setP_info("dilicious");
        product.setP_num(1000);

        Product product1 = new Product();
        product1.setP_id(2);
        product1.setP_name("朱古力");
        product1.setP_price(new BigDecimal(200));
        product1.setP_info("dilicious");

        Product product2 = new Product();
        product2.setP_id(3);
        product2.setP_name("小馒头");
        product2.setP_price(new BigDecimal(200));
        product2.setP_info("dilicious");
        product2.setP_num(1000);
        product2.setP_num(1000);

        products.put(String.valueOf(product.getP_id()), product);
        products.put(String.valueOf(product1.getP_id()), product1);
        products.put(String.valueOf(product2.getP_id()), product2);
    }

    /**
     * 获取商品信息
     */
    public List<Product> getProductList(){

        List<Product> productList = new ArrayList<Product>();
        Set<String> keys = products.keySet();
        for (String k: keys){
            Product product = products.get(k);
            productList.add(product);
        }
        return productList;
    }

    public Product getProductById(String productId){
        Product product = products.get(productId);
        return product;
    }

    public void deleteProductById(String productId) {
        products.remove(productId);
    }

    /*
     * 更新和删除同理
     */

    public static void main(String[] args) {
        List<Product> productList = new ProductDaoImpl().getProductList();
        System.out.println(productList);
    }

    public void addProduct(Product product) {
        products.put(String.valueOf(product.getP_id()), product);
        return;
    }
}

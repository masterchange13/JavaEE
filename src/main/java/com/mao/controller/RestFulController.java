/**
 * @author: mao
 * @description
 * @date: 2024/3/29 19:12
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.controller;

import com.mao.bean.Product;
import com.mao.mapper.Impl.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class RestFulController {

    @Autowired
    private ProductDaoImpl productDao;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String toProductIndedx(Model model){
        List<Product> productList = productDao.getProductList();
        model.addAttribute("productList", productList);
        return "product/product_info";
    }

    @RequestMapping(value = "/product/{id}")
    public String getProductDetail(@PathVariable("id") String p_id, Model model){
        Product product = productDao.getProductById(p_id);
        model.addAttribute("productList", product);
        return "product/product_detail";
    }

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public String deleteProduct(String productId, Model model){
        productDao.deleteProductById(productId);
//        model.addAttribute("product", product);
        return "redirects:/products";
    }

}

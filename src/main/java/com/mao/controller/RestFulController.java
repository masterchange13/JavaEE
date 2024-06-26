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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// import javax.jws.WebParam;
import java.util.List;
import java.util.jar.JarOutputStream;

@Controller
public class RestFulController {

    @Autowired(required = false)
    private ProductDaoImpl productDao;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String toProductIndedx(Model model){
        List<Product> productList = productDao.getProductList();
        System.out.println(productList);
        model.addAttribute("productList", productList);
        return "product/product_info";
    }

    @RequestMapping(value = "/product/{id}")
    public String getProductDetail(@PathVariable("id") String p_id, Model model){
        Product product = productDao.getProductById(p_id);
        System.out.println(product);
        model.addAttribute("product", product);
        return "product/product_detail";
    }

//    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
//    public String deleteProduct(String productId, Model model){
//        productDao.deleteProductById(productId);
////        model.addAttribute("product", product);
//        return "redirects:/products";
//    }


    @RequestMapping("toAddProduct")
    public String toAddProduct(){
        return "product/product_add";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProduct (@RequestBody Product product){
        System.out.println("begin add product");
        System.out.println(product);
        productDao.addProduct(product);
        System.out.println("end");
//        返回200正确码
    }

    @RequestMapping("toAddProductTest")
    public String toAddProductTest(){
        return "product/product_add_test";
    }

    @RequestMapping(value = "deleteProduct/{id}", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable("id") String id, Model model){
        System.out.println(id);
        productDao.deleteProductById(id);
        List<Product> productList = productDao.getProductList();
        System.out.println(productList);
        model.addAttribute("productList", productList);
        return "product/product_info";
    }

    @RequestMapping(value = "toUpdateProduct/{id}")
    public String toUpdateProduct(@PathVariable("id") String id, Model model){
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "product/product_update";
    }

    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
    public String updateProduct(@RequestBody Product product) {
        // 把product的数据替换products
        productDao.updateProduct(product);
        return "redirect:/products";
    }

}

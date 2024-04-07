/**
 * @author: mao
 * @description
 * @date: 2024/3/29 15:26
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.controller;

import com.mao.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/index")
    public String toIndex2(){
        return "index";
    }

//    @RequestMapping("/")
//    @RequestBody
//    public int toIndex1(){
//        return 0;
//    }

    @RequestMapping("/login")
    public String toLogin(){
        return "login/login";
    }

//    获取页面请求中的参数，httpServletRequest,引入servlet-api
    @RequestMapping("/getParam1")
    public String getParam1(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + "password" + password);
        return "login/login";
    }

    @RequestMapping("/getParam2")
    public String getParam2(String username, String password){
        System.out.println(username + password);
        return "login/login";
    }

//    注解获取参数 @RequestParam 获取注解参数 name和value指定参数名称
    @RequestMapping("getParam3")
    public String getParam3(@RequestParam(name="username") String username, @RequestParam(name = "password", required = false) String password){
        System.out.println(username + password);
        return "login/login";
    }

//    按照实体类对应的参数列表，只需要传入实体类对象，通过get和set取值和赋值
    @RequestMapping("getParam4")
    public String getParam4(User user){
        System.out.println(user.toString());
        return "login/login";
    }

    @RequestMapping("sendParam")
    public String sendParam(Model model, HttpServletRequest request){
        request.setAttribute("requestScope", "request传值");
        HttpSession session = request.getSession();
        session.setAttribute("requestScope",  "session传值");
        model.addAttribute("msg", "天气不错！！！");
        return "login/login";
    }

    @RequestMapping("/sendParam2")
    public String sendParam2(Map<String, Object> map){
        map = new HashMap();
        map.put("1", "巧克力1");
        map.put("2", "巧克力2");
        map.put("3", "巧克力3");
        return "login/login";
    }

    @RequestMapping("/sendParam3")
    public String sendParam2(ModelMap modelMap){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("1", "巧克力1");
        map.put("2", "巧克力2");
        map.put("3", "巧克力3");
        modelMap.addAttribute("food", map);
        return "login/login";
    }

    @RequestMapping("toSendParam3")
    public String toParam3(Model model){
        model.addAttribute("message", "请求转发前的数据");
        return "forward:/sendParam3";
    }

    @RequestMapping("toSendParam32")
    public String toParam32(){
        return "redirect:/sendParam3";
    }

//    spring mvc的数据共享
    public ModelAndView show(ModelAndView mv){
        User user = new User();
        mv.setViewName("login/login");
        mv.addObject("md1", user);
        return mv;
    }

}

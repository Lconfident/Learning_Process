package demo.controller;


import demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    // 不携带数据的String页面类型
    @RequestMapping("/register")
    public void showPageByVoid() {
        System.out.println("showPageByVoid running");
    }

    @RequestMapping("/register1")
    public String showPageByString1(){
        System.out.println("showPageByString1 running");
        return "forward:/WEB-INF/pages/register.jsp";
    }

    @RequestMapping("/register2")
    public String showPageByString2(){
        System.out.println("showPageByString2 running");
        return "redirect:http://www.itheima.com";
    }

    // 携带数据的页面转发
    @RequestMapping("/showPageByRequest")
    public String showPageByRequest(HttpServletRequest request){
        System.out.println("showPageByRequest running");
        request.setAttribute("username", "Jerry");
        request.setAttribute("password","123456");
        return "request";
    }

    @RequestMapping("/showModelAndView")
    public ModelAndView showModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","Tom");
        User user = new User();
        user.setPassword("password");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("register");
        return modelAndView;
    }
}


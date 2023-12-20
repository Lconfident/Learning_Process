package demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DataController {
    @RequestMapping("/func1")
    public void showDataByResponse(HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF8");
            response.getWriter().print("response 方法执行了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/showDataByJSON")
    public void showDataByJSON(HttpServletResponse response) {
        try {
            ObjectMapper om = new ObjectMapper();
            User user = new User();
            user.setUsername("tom");
            user.setPassword("666");
            String ujson = om.writeValueAsString(user);
            response.getWriter().print(ujson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package action;

import dao.CookieDao;
import dao.UserDao;
import entity.UserShow;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserShowServlet", value = "/UserShowServlet")
public class UserShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据Cookie中id识别用户
        int id = Integer.parseInt(CookieDao.getValue(request,response,"id"));
        //根据id找到用户信息
        UserShow show = UserDao.selectShow(id);
        if(show!=null){
            // 转发到前端页面
            request.setAttribute("show",show);
            request.getRequestDispatcher("userHome.jsp").forward(request, response);
        }else{
            response.getWriter().println("该用户信息不存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}

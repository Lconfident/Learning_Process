package service;

import dao.CookieDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用户注销
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.removeAttribute("user");
        }
        // 从客户端删除登录的Cookie
        CookieDao cookieDao = new CookieDao();
        cookieDao.removeCookie(request,response,"id");
        cookieDao.removeCookie(request,response,"password");
        //请求转发到登陆页面
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

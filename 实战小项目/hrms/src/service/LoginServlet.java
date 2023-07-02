package service;

import dao.CookieDao;
import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.instrument.Instrumentation;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        // 查找是否存在指定id的用户
        User user = new UserDao().search(Integer.parseInt(id));

        if (user != null && user.getPassword().equals(password)) {
            //登陆成功
            // 创建一个 session 并将用户存储在其中
            request.getSession().setAttribute("user", user);
            //id、password存入Cookie

            // 是否是首次登录
            Cookie[] cookies = request.getCookies();
            boolean flag = true;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("id")) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    // 用户身份验证成功后创建两个Cookie对象
                    Cookie idCookie = new Cookie("id", id);
                    Cookie passwordCookie = new Cookie("password", password);

                    // 设置Cookie的过期时间
                    idCookie.setMaxAge(24 * 60 * 60); // 1天
                    passwordCookie.setMaxAge(24 * 60 * 60); // 1天

                    // 将Cookie添加到响应中
                    response.addCookie(idCookie);
                    response.addCookie(passwordCookie);
                } else {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("id")) {
                            // 更新已有的id Cookie的值
                            cookie.setValue(id);
                            response.addCookie(cookie);

                        } else if (cookie.getName().equals("password")) {
                            // 更新已有的password Cookie的值
                            cookie.setValue(password);
                            response.addCookie(cookie);
                        }
                    }
                }

                //跳转页面
                if (100 == user.getEmp_id() && "root".equals(user.getPassword())) {
                    response.sendRedirect(request.getContextPath() + "/RootShowServlet");
                } else {
                    response.sendRedirect(request.getContextPath() + "/UserShowServlet");
                }
            }else{
                // 用户身份验证成功后创建两个Cookie对象
                Cookie idCookie = new Cookie("id", id);
                Cookie passwordCookie = new Cookie("password", password);

                // 设置Cookie的过期时间
                idCookie.setMaxAge(24 * 60 * 60); // 1天
                passwordCookie.setMaxAge(24 * 60 * 60); // 1天

                // 将Cookie添加到响应中
                response.addCookie(idCookie);
                response.addCookie(passwordCookie);

                //跳转页面
                if (100 == user.getEmp_id() && "root".equals(user.getPassword())) {
                    response.sendRedirect(request.getContextPath() + "/rootHome.jsp");
                } else {
                    response.sendRedirect(request.getContextPath() + "/UserShowServlet");
                }
            }
        } else {
            // 请求转发至登录页面
            request.setAttribute("error", "用户名或密码无效");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}

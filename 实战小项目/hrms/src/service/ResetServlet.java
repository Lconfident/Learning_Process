package service;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResetServlet", value = "/ResetServlet")
public class ResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean success = false;
        int id = 0;
        //验证旧密码
        String oldPassword = request.getParameter("oldPassword");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("password")) {
                    if (c.getValue().equals(oldPassword)) {
                        request.setAttribute("oldError", null);
                    } else {
                        request.setAttribute("oldError", "原始密码输入错误");
                    }
                }
                if (c.getName().equals("id")) {
                    id = Integer.parseInt(c.getValue());
                }
            }
        }

        //验证两次密码
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (newPassword.equals(confirmPassword)) {
            request.setAttribute("twoError", null);
        } else {
            request.setAttribute("twoError", "两次密码输入不相同");
        }

        //若有错误提示，则请求转发至重置密码页
        //若成功更新密码。则删除session和cookie
        if (request.getAttribute("oldError") != null ||
                request.getAttribute("twoError") != null) {
            request.getRequestDispatcher("userReset.jsp").forward(request, response);
        } else {
            //更改数据库中的密码
            UserDao userDao = new UserDao();
            User resetUser = new User();
            resetUser.setEmp_id(id);
            resetUser.setPassword(newPassword);
            success = userDao.reset(resetUser);
            if(success){
                request.setAttribute("reset","密码修改成功");
                // 删除旧session
                HttpSession session = request.getSession(false);
                session.removeAttribute("user");
                // TODO 增加新session
                //修改cookie
                for (Cookie c : cookies) {
                    if (c.getName().equals("password")) {
                       c.setValue(newPassword);
                       response.addCookie(c);
                       break;
                    }
                }
            }else{
                request.setAttribute("reset",null);
            }
            request.getRequestDispatcher("userReset.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}

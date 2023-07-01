package service;

import dao.UserDao;
import entity.Person;
import entity.PersonalInfo;
import entity.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InfoServlet", value = "/InfoServlet")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));

        PersonalInfo info = UserDao.getStaffInfo(name, id);
        if (info != null) {
            // 转发到前端页面
            request.setAttribute("info", info);
            request.getRequestDispatcher("info.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

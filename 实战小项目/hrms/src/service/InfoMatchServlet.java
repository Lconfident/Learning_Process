package service;

import dao.PersonDao;
import dao.StaffDao;
import dao.UserDao;
import entity.Person;
import entity.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InfoMatchServlet", value = "/InfoMatchServlet")
public class InfoMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        //查询id和name是否匹配
        Staff staff = StaffDao.findStaff(id);
        Person person = PersonDao.findPerson(name);
        if (staff!=null && person !=null && staff.getEmp_name().equals(person.getEmp_name())) {
            request.setAttribute("matchMsg",null);
            request.getRequestDispatcher("InfoServlet").forward(request,response);
        } else {
            request.setAttribute("matchMsg","姓名与账号不匹配，请重新输入！");
            request.getRequestDispatcher("rootHome.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

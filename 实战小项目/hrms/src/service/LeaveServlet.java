package service;

import dao.PersonDao;
import dao.StaffDao;
import dao.UserDao;
import entity.Person;
import entity.Staff;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "LeaveServlet", value = "/LeaveServlet")
public class LeaveServlet extends HttpServlet {
    @Override
    //离职
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求数据的中文乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        //查询id和name是否匹配
        Staff staff = StaffDao.findStaff(id);
        Person person = PersonDao.findPerson(name);
        if (staff != null && person != null && staff.getEmp_name().equals(person.getEmp_name())) {
            boolean deStaff = StaffDao.deleteStaff(id);
            boolean dePerson = PersonDao.deletePerson(name);
            if (deStaff == true && dePerson == true) {
                request.setAttribute("staffDeleteMsg", "员工信息删除成功");
                request.getRequestDispatcher("staffManage.jsp").forward(request, response);
            }else{
                request.setAttribute("staffDeleteMsg", "员工信息删除失败，请从数据库删除");
                request.getRequestDispatcher("staffManage.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("staffDeleteMsg", "姓名与账号不匹配，请重新输入！");
            request.getRequestDispatcher("staffManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

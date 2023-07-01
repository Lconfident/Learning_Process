package action;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int emp_id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = new UserDao().delete(emp_id);
        if (flag) {
            request.setAttribute("deleteMsg", "账号注销成功");
            request.getRequestDispatcher("userManage.jsp").forward(request, response);
        } else {
            request.setAttribute("deleteMsg", "该账号已注销");
            request.getRequestDispatcher("userManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

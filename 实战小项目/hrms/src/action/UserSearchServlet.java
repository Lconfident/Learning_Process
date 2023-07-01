package action;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserSearchServlet", value = "/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int emp_id = Integer.parseInt(request.getParameter("idSearch"));
        User user = new UserDao().search(emp_id);
        if (user != null) {
            request.setAttribute("userSearch", user);
            request.setAttribute("searchMsg", null);
            request.getRequestDispatcher("userManage.jsp").forward(request, response);
        } else {
            request.setAttribute("userSearch", null);
            request.setAttribute("searchMsg", "该账号不存在");
            request.getRequestDispatcher("userManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

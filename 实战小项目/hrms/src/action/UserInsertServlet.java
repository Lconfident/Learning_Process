package action;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserInsertServlet", value = "/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int emp_id = Integer.parseInt(request.getParameter("idInsert"));
        UserDao userDao = new UserDao();
        User user = userDao.search(emp_id);
        boolean flag = new UserDao().insert(emp_id);
        if (user == null && flag == true) {
            request.setAttribute("insertMsg", "新账号申请成功");
            request.getRequestDispatcher("userManage.jsp").forward(request, response);
        } else {
            request.setAttribute("insertMsg", "该账号已存在");
            request.getRequestDispatcher("userManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

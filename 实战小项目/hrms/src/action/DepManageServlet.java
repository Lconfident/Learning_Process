package action;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DepManageServlet", value = "/DepManageServlet")
public class DepManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int emp_id = Integer.parseInt(request.getParameter("emp_id"));
        int dep_id = Integer.parseInt(request.getParameter("dep_id"));
        int man_id = Integer.parseInt(request.getParameter("man_id"));
        boolean flag = UserDao.updateDep(emp_id, dep_id, man_id);
        if(flag){
            request.setAttribute("depMsg","该员工岗位分配成功");
            request.getRequestDispatcher("depManage.jsp").forward(request,response);
        }else{
            request.setAttribute("depMsg","该员工已分配岗位");
            request.getRequestDispatcher("depManage.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package action;

import dao.DepDao;
import entity.Dep;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DepShowServlet", value = "/DepShowServlet")
public class DepShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        DepDao depDao = new DepDao();
        Dep dep10 = depDao.getDep(10);
        Dep dep11 = depDao.getDep(11);
        Dep dep12 = depDao.getDep(12);
        Dep dep13 = depDao.getDep(13);
        Dep dep14 = depDao.getDep(14);
        Dep dep15 = depDao.getDep(15);
        if (dep10 != null) {
            request.setAttribute("dep10", dep10);
            request.setAttribute("dep11", dep11);
            request.setAttribute("dep12", dep12);
            request.setAttribute("dep13", dep13);
            request.setAttribute("dep14", dep14);
            request.setAttribute("dep15", dep15);
            request.getRequestDispatcher("department.jsp").forward(request, response);
        } else {
            response.getWriter().println("部门信息错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package action;

import dao.DepInfoDao;
import entity.DepInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DepInfoServlet", value = "/DepInfoServlet")
public class DepInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<DepInfo> list = DepInfoDao.getDepInfo(id);
        String depName = DepInfoDao.getDepName(id);
        if(list != null){
            request.setAttribute("depName", depName);
            request.setAttribute("list",list);
            request.getRequestDispatcher("depInfo.jsp").forward(request, response);
        }else{
            response.getWriter().println("部门信息错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}

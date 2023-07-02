package action;

import dao.DepDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RootShowServlet", value = "/RootShowServlet")
public class RootShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置各部门的人数
        response.setContentType("text/html;charset=utf-8");
        DepDao depDao = new DepDao();
        int d10_number = depDao.getDepNumber(10);
        int d11_number = depDao.getDepNumber(11);
        int d12_number = depDao.getDepNumber(12);
        int d13_number = depDao.getDepNumber(13);
        int d14_number = depDao.getDepNumber(14);
        int d15_number = depDao.getDepNumber(15);
        if(d10_number!=0){
            request.setAttribute("d10_number",d10_number);
            request.setAttribute("d11_number",d11_number);
            request.setAttribute("d12_number",d12_number);
            request.setAttribute("d13_number",d13_number);
            request.setAttribute("d14_number",d14_number);
            request.setAttribute("d15_number",d15_number);
            request.getRequestDispatcher("rootHome.jsp").forward(request, response);
        }else{
            response.getWriter().println("信息错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

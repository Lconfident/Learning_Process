package service;

import dao.PersonDao;
import dao.StaffDao;
import entity.Person;
import entity.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求数据的中文乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String emp_name = request.getParameter("emp_name");
        String sex = request.getParameter("sex");
        String birth_date = request.getParameter("birth_date");
        String native_place = request.getParameter("native_place");
        String education = request.getParameter("education");
        String graduate_school = request.getParameter("graduate_school");
        String major = request.getParameter("major");
        String email = request.getParameter("email");
        int emp_id = Integer.parseInt(request.getParameter("emp_id"));
        String hire_date = request.getParameter("hire_date");

        Staff staff = new Staff();
        staff.setEmp_id(emp_id);
        staff.setEmp_name(emp_name);
        staff.setHire_date(hire_date);
        staff.setEmail(email);

        Person person = new Person();
        person.setEmp_name(emp_name);
        person.setSex(sex);
        person.setBirth_date(birth_date);
        person.setNative_place(native_place);
        person.setEducation(education);
        person.setGraduate_school(graduate_school);
        person.setMajor(major);

        boolean inStaff = StaffDao.updateStaff(staff);
        boolean inPerson = PersonDao.updatePerson(person);
        if (inStaff == true && inPerson == true) {
            request.setAttribute("staffEditMsg", "员工入职信息修改完毕");
            request.getRequestDispatcher("staffManage.jsp").forward(request, response);
        } else {
            request.setAttribute("staffEditMsg", "员工信息修改错误");
            request.getRequestDispatcher("staffManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

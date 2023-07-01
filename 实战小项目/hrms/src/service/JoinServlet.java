package service;

import dao.PersonDao;
import dao.StaffDao;
import dao.UserDao;
import entity.Person;
import entity.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "JoinServlet", value = "/JoinServlet")
public class JoinServlet extends HttpServlet {
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

        boolean inStaff = StaffDao.insertStaff(staff);
        boolean inPerson = PersonDao.insertPerson(person);
        if (inStaff == true && inPerson == true) {
            request.setAttribute("staffInsertMsg", "员工入职信息填写完毕");
            request.getRequestDispatcher("staffManage.jsp").forward(request, response);
        } else {
            request.setAttribute("staffInsertMsg", "员工信息已存在");
            request.getRequestDispatcher("staffManage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
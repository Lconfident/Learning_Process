package dao;

import entity.*;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserDao {
    //添加账号
    public boolean insert(int id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO user (emp_id)" + " VALUES (" + id + ")";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }

    //查询所有账号
    public ArrayList<User> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setEmp_id(rs.getInt("emo_id"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //根据id查询指定user
    public static User search(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE emp_id = " + id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setEmp_id(rs.getInt("emp_id"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //更改密码
    public boolean reset(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "UPDATE user"
                    + " SET password='"
                    + user.getPassword()
                    + "' WHERE emp_id=" + user.getEmp_id();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }

    //根据id删除账号
    public static boolean delete(int id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM user " +
                    " WHERE emp_id=" + id;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }

    //根据id查找到该用户的展示信息
    public static UserShow selectShow(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select emp.emp_name,emp.emp_id,emp.email," +
                    "dep.dep_name,man.emp_name as 'man_name',man.email as 'man_email'," +
                    "year(curdate()) - year(emp.hire_date)  as 'work_years' " +
                    " from employee emp , employee man,department dep " +
                    " where emp.manager_id = man.emp_id " +
                    " and emp.dep_id =  dep.dep_id " +
                    " and emp.emp_id=" + id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                UserShow p = new UserShow();
                p.setEmp_name(rs.getString("emp_name"));
                p.setEmp_id(rs.getInt("emp_id"));
                p.setEmp_email(rs.getString("email"));
                p.setDep_name(rs.getString("dep_name"));
                p.setMan_name(rs.getString("man_name"));
                p.setMan_email(rs.getString("man_email"));
                p.setWork_years(rs.getString("work_years"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //为用户分配岗位
    public static boolean updateDep(int emp_id, int dep_id, int man_id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update employee set dep_id=" + dep_id
                    + " ,manager_id=" + man_id +
                    " where emp_id=" + emp_id;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }


    //根据姓名和id查找到该员工的个人信息
    public static PersonalInfo getStaffInfo(String name, int id) {
        Staff staff = StaffDao.findStaff(id);
        Person person = PersonDao.findPerson(name);
        PersonalInfo info = new PersonalInfo();
        info.setEmp_name(person.getEmp_name());
        info.setSex(person.getSex());
        info.setBirth_date(person.getBirth_date());
        info.setNative_place(person.getNative_place());
        info.setEducation(person.getEducation());
        info.setGraduate_school(person.getGraduate_school());
        info.setMajor(person.getMajor());
        info.setEmp_id(staff.getEmp_id());
        info.setEmail(staff.getEmail());
        info.setHire_date(staff.getHire_date());
        return info;
    }

    //更新到该员工的个人详细信息
    public static boolean updateStaffInfo(Staff staff, Person person) {
        boolean upStaff = StaffDao.updateStaff(staff);
        boolean upPerson = PersonDao.updatePerson(person);
        if (upStaff == true && upPerson == true) {
            return true;
        }
        return false;
    }

    //删除该员工的个人详细信息
    public static boolean deleteStaffInfo(String name, int id) {
        boolean deStaff = StaffDao.deleteStaff(id);
        boolean dePerson = PersonDao.deletePerson(name);
        if (deStaff == true && dePerson == true) {
            return true;
        }
        return false;
    }
}

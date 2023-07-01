package dao;

import entity.Person;
import entity.Staff;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDao {
    // 插入个人信息
    public static boolean insertPerson(Person person) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into personal_information (emp_name,sex,birth_date,native_place,education,graduate_school,major) " +
                    " value (?,?,?,?,?,?,?)";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, person.getEmp_name());
            preStmt.setString(2, person.getSex());
            preStmt.setString(3, person.getBirth_date());
            preStmt.setString(4, person.getNative_place());
            preStmt.setString(5, person.getEducation());
            preStmt.setString(6, person.getGraduate_school());
            preStmt.setString(7, person.getMajor());
            int num = preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preStmt, conn);
        }
        return false;
    }

    // 查取个人信息
    public static Person findPerson(String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from personal_information where emp_name='" + name + "'";
            rs = stmt.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Person person = new Person();
                    person.setEmp_name(rs.getString("emp_name"));
                    person.setSex(rs.getString("sex"));
                    person.setBirth_date(rs.getString("birth_date"));
                    person.setNative_place(rs.getString("native_place"));
                    person.setEducation(rs.getString("education"));
                    person.setGraduate_school(rs.getString("graduate_school"));
                    person.setMajor(rs.getString("major"));
                    return person;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    // 搜索个人信息
    public static boolean searchPerson(String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from personal_information where emp_name='" + name + "'";
            rs = stmt.executeQuery(sql);
            if (rs != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    // 更新个人信息
    public static boolean updatePerson(Person person) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update personal_information "
                    + " set sex = '" + person.getSex() + "',"
                    + "birth_date = '" + person.getBirth_date() + "',"
                    + "native_place = '" + person.getNative_place() + "',"
                    + "education = '" + person.getEducation() + "',"
                    + "graduate_school = '" + person.getGraduate_school() + "',"
                    + "major = '" + person.getMajor() + "' "
                    + " where emp_name='" + person.getEmp_name() + "'";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }

    // 删除个人信息
    public static boolean deletePerson(String name) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from personal_information" +
                    " where emp_name='" + name + "'";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
        return false;
    }
}

package dao;

import entity.Person;
import entity.Staff;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffDao {
    // 插入员工信息
    public static boolean insertStaff(Staff staff) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into employee (emp_id,emp_name,hire_date,email) " +
                    " value (?,?,?,?)";
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, staff.getEmp_id());
            preStmt.setString(2, staff.getEmp_name());
            preStmt.setString(3,staff.getHire_date());
            preStmt.setString(4, staff.getEmail());
            int num = preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preStmt, conn);
        }return false;
    }

    // 查取员工信息
    public static Staff findStaff(int id){
        Connection conn = null;;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from employee where emp_id="+id;
            rs=stmt.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Staff staff = new Staff();
                    staff.setEmp_id(rs.getInt("emp_id"));
                    staff.setEmp_name(rs.getString("emp_name"));
                    staff.setHire_date(rs.getString("hire_date"));
                    staff.setEmail(rs.getString("email"));
                    return staff;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }return null;
    }

    // 搜索员工信息
    public static boolean searchStaff(int id){
        Connection conn = null;;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from employee where emp_id="+id;
            rs=stmt.executeQuery(sql);
            if(rs!=null){
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }return false;
    }

    // 更新员工信息
    public static boolean updateStaff(Staff staff) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update employee "
                    + " set emp_name = '" + staff.getEmp_name() + "',"
                    + "hire_date = '" + staff.getHire_date() + "',"
                    + "email = '" + staff.getEmail() + "' "
                    + " where emp_id=" + staff.getEmp_id();
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

    // 删除员工信息
    public static boolean deleteStaff(int id){
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from employee" +
                    " where emp_id=" +id;
            int num = stmt.executeUpdate(sql);
            if(num>0){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(stmt,conn);
        }return false;
    }
}

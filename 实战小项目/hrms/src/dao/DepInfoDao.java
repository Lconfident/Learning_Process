package dao;

import entity.DepInfo;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DepInfoDao {
    //返回各部门具体人员的信息
    public static ArrayList<DepInfo> getDepInfo(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ArrayList<DepInfo> list = new ArrayList<DepInfo>();
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select emp.emp_name,emp.emp_id,emp.email,emp.hire_date,man.emp_name as 'man_name'\n" +
                    "from employee emp,employee man\n" +
                    "where emp.manager_id = man.emp_id\n" +
                    "and emp.dep_id=" + id;
            rs = stmt.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    DepInfo depInfo = new DepInfo();
                    depInfo.setEmp_name(rs.getString("emp_name"));
                    depInfo.setEmp_id(rs.getInt("emp_id"));
                    depInfo.setEmail(rs.getString("email"));
                    depInfo.setHire_date(rs.getString("hire_date"));
                    depInfo.setMan_name(rs.getString("man_name"));
                    list.add(depInfo);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //根据传入的id信息，返回部门名称
    public static String getDepName(int id){
        switch(id){
            case 10:return "董事会";
            case 11:return "行政部";
            case 12:return "财务部";
            case 13:return "运营部";
            case 14:return "研发部";
            case 15:return "人力资源部";
            default:return "部门";
        }
    }
}

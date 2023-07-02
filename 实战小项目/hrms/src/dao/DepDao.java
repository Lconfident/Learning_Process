package dao;

import entity.Dep;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepDao {
    // 得到各部门的基本信息
    public Dep getDep(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select dep.dep_id,dep.dep_name,count(*) as 'headcount',man.emp_name as 'man_name'\n" +
                    " from department dep\n" +
                    " join employee emp\n" +
                    " on dep.dep_id = emp.dep_id \n" +
                    " join employee man \n" +
                    " on man.emp_id in (select  department.manager_id from department,employee where employee.dep_id = department.dep_id " +
                    " and department.dep_id="+id+") " +
                    " group by emp.dep_id " +
                    " having dep.dep_id=" + id;
            rs = stmt.executeQuery(sql);
            if (rs!=null) {
                while (rs.next()) {
                    Dep dep = new Dep();
                    dep.setDep_id(rs.getInt("dep_id"));
                    dep.setDep_name(rs.getString("dep_name"));
                    dep.setHeadcount(rs.getInt("headcount"));
                    dep.setMan_name(rs.getString("man_name"));
                    return dep;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    // 得到各部门的人数
    public int getDepNumber(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select count(*) as 'headcount'\n" +
                    "from employee\n" +
                    "group by dep_id\n" +
                    "having dep_id="+id;
            rs= stmt.executeQuery(sql);
            if(rs!=null){
                while(rs.next()) {
                    return rs.getInt("headcount");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,conn);
        }return 0;
    }
}

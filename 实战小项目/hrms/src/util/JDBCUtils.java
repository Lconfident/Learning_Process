package util;

import java.sql.*;

public class JDBCUtils {
    //加载驱动，建立数据库连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/staffdb?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "abc123";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    //关闭数据库，释放资源
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);
    }

    public static void release(PreparedStatement prestmt, Connection conn) {
        if (prestmt != null) {
            try {
                prestmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            prestmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, PreparedStatement prestmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(prestmt, conn);
    }
}

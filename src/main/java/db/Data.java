package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhailz
 *
 * @version 2018年3月5日 下午4:40:44
 */
public class Data {

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test1";
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "root";

	public static Connection getConnect() {
		Connection conn = null;
		// 注册 JDBC 驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setClientInfo("retainStatementAfterResultSetClose", "true");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		System.err.println(Integer.toHexString(30672));
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = getConnect();
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Student.S, Student.Sname, Student.Sage, Student.Ssex FROM Student";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				String id = rs.getString("S");
				String name = rs.getString("Sname");
				String url = rs.getString("Ssex");

				// 输出数据
				System.out.print("S: " + id);
				System.out.print(", Sname: " + name);
				System.out.print(", Ssex: " + url);
				System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
			
			
			
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		
		finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}

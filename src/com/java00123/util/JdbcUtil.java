package com.java00123.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


/**
* @author 作者 www.java00123.com
* @version 创建时间：2018年4月21日 上午7:10:01
* 类说明 JDBC数据库链接类
*/
public class JdbcUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_studentmanager2";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	/**
	 * 创建数据库链接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("数据库链接成功"+conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void relaseDb(Connection conn,PreparedStatement ps,
			ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn !=null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection conn = JdbcUtil.getConnection();

	}

}

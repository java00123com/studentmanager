package com.java00123.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


/**
* @author ���� www.java00123.com
* @version ����ʱ�䣺2018��4��21�� ����7:10:01
* ��˵�� JDBC���ݿ�������
*/
public class JdbcUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db_studentmanager2";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	/**
	 * �������ݿ�����
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("���ݿ����ӳɹ�"+conn);
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

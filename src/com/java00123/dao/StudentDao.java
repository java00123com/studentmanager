package com.java00123.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java00123.entity.Student;
import com.java00123.util.JdbcUtil;
import com.mysql.jdbc.Connection;

/**
* @author 作者 www.java00123.com
* @version 创建时间：2018年4月21日 上午9:06:35
* 类说明
*/
public class StudentDao {

	/**
	 * 保存学生信息
	 * @param student
	 * @return
	 */
	public int saveStudent(Student student){
		int result = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into student(schoolNum,"
				+ " name,age,sex,summary,status,createTime) "
				+ " values(?,?,?,?,?,?,?) ";
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getSchoolNum());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.setInt(4, student.getSex());
			ps.setString(5, student.getSummary());
			ps.setString(6, "1");
			//ps.setDate(7, new java.sql.Date(new Date().getTime()));
			ps.setTimestamp(7, new Timestamp(new Date().getTime()));
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.relaseDb(conn, ps, null);
		}
		
		return result;
	}
	
	/**
	 * 查询学生信息
	 * @param id
	 * @return
	 */
	public Student querySatudentById(int id){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		
		String sql = "select * from student where id = ? ";
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				String schoolNum = rs.getString("schoolNum");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int sex = rs.getInt("sex");
				String summary = rs.getString("summary");
				String status = rs.getString("status");
				java.sql.Date createTime = rs.getDate("createTime");
				
				student = new Student();
				student.setId(id);
				student.setSchoolNum(schoolNum);
				student.setName(name);
				student.setAge(age);
				student.setSex(sex);
				student.setSummary(summary);
				student.setCreateTime(createTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.relaseDb(conn, ps, rs);
		}
		
		return student;
	}
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	public int updateStudent(Student student){
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update student set schoolNum = ?, "
				+ " name = ?, "
				+ " age = ?, "
				+ " sex = ?,"
				+ " summary=?,"
				+ " status = ?, "
				+ " createTime=? "
				+ " where id = ? ";
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, student.getSchoolNum());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.setInt(4, student.getSex());
			ps.setString(5, student.getSummary());
			ps.setString(6, student.getStatus());
			//ps.setDate(7, new java.sql.Date(new Date().getTime()));
			ps.setTimestamp(7, new Timestamp(new Date().getTime()));
			ps.setInt(8, student.getId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.relaseDb(conn, ps, null);
		}
		
		return result;
		
	}
	
	/**
	 * 删除学生信息
	 * @param id
	 * @return
	 */
	public int deleteStudent(int id){
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "update student set status = '0' "
				+ "where id = ? ";
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.relaseDb(conn, ps, null);
		}
		
		return result;
	}
	
	/**
	 * 查询学生列表
	 * @return
	 */
	public List<Student> queryStudentList(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> list = new ArrayList<Student>();
		Student student = null;
		
		String sql = "select * from student where status = '1' "
				+ "order by id desc ";
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String schoolNum = rs.getString("schoolNum");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int sex = rs.getInt("sex");
				String summary = rs.getString("summary");
				String status = rs.getString("status");
				java.sql.Date createTime = rs.getDate("createTime");
				
				student = new Student();
				student.setId(id);
				student.setSchoolNum(schoolNum);
				student.setName(name);
				student.setAge(age);
				student.setSex(sex);
				student.setSummary(summary);
				student.setCreateTime(createTime);
				
				list.add(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.relaseDb(conn, ps, rs);
		}
		
		return list;
	}
}

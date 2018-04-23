package com.java00123.test;

import java.util.Date;

import org.junit.Test;

import com.java00123.dao.StudentDao;
import com.java00123.entity.Student;

/**
* @author 作者 www.java00123.com
* @version 创建时间：2018年4月21日 上午9:29:55
* 类说明
*/
public class StudentTest {

	@Test
	public void test() {
		StudentDao studentDao = new StudentDao();
		
		//查询学生列表
//		List<Student> lst = studentDao.queryStudentList();
//		System.out.println(lst);
		
		//保存
//		Student s = new Student(1,"4","张三",19,2,"张三的简介","1",new Date());
//		int ret = studentDao.saveStudent(s);
//		System.out.println(ret);
		
		//根据Id查询
//		int id = 1;
//		Student s = studentDao.querySatudentById(id);
//		System.out.println(s);
		
//		//修改
//		Student s = new Student(1,"1","赵六",38,1,"赵六的简介","0",new Date());
//		int ret = studentDao.updateStudent(s);
//		System.out.println(ret);
		
//		//删除
		int id = 1;
		int ret = studentDao.deleteStudent(id);
		System.out.println(ret);
	}

}

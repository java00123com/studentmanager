package com.java00123.test;

import java.util.Date;

import org.junit.Test;

import com.java00123.dao.StudentDao;
import com.java00123.entity.Student;

/**
* @author ���� www.java00123.com
* @version ����ʱ�䣺2018��4��21�� ����9:29:55
* ��˵��
*/
public class StudentTest {

	@Test
	public void test() {
		StudentDao studentDao = new StudentDao();
		
		//��ѯѧ���б�
//		List<Student> lst = studentDao.queryStudentList();
//		System.out.println(lst);
		
		//����
//		Student s = new Student(1,"4","����",19,2,"�����ļ��","1",new Date());
//		int ret = studentDao.saveStudent(s);
//		System.out.println(ret);
		
		//����Id��ѯ
//		int id = 1;
//		Student s = studentDao.querySatudentById(id);
//		System.out.println(s);
		
//		//�޸�
//		Student s = new Student(1,"1","����",38,1,"�����ļ��","0",new Date());
//		int ret = studentDao.updateStudent(s);
//		System.out.println(ret);
		
//		//ɾ��
		int id = 1;
		int ret = studentDao.deleteStudent(id);
		System.out.println(ret);
	}

}

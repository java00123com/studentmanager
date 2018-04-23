package com.java00123.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java00123.dao.StudentDao;
import com.java00123.entity.Student;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		//��ҳ
		if("index".equals(method)){
			index(request,response);
		}
		
		//��ת���ҳ��
		if("addStuIndex".equals(method)){
			addStuIndex(request,response);
		}
		
		//����ѧ����Ϣ
		if("saveStu".equals(method)){
			saveStu(request,response);
		}
		
		//ɾ��ѧ����Ϣ
		if("delStu".equals(method)){
			delStu(request,response);
		}
		
		//չʾѧ����Ϣ
		if("showStu".equals(method)){
			showStu(request,response);
		}
		
		//��ת�޸�ҳ��
		if("editStuIndex".equals(method)){
			editStuIndex(request,response);
		}
		
		//�޸�ѧ����Ϣ
		if("updateStu".equals(method)){
			updateStu(request,response);
		}
		
	}
	
	//�޸�ѧ����Ϣ
	private void updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		
		String schoolNum = request.getParameter("schoolNum");
		String name = request.getParameter("name");
		int age = new Integer(request.getParameter("age"));
		int sex = new Integer(request.getParameter("sex"));
		String summary = request.getParameter("summary");
		
		Student stu = new Student();
		stu.setId(id);
		stu.setSchoolNum(schoolNum);
		stu.setName(name);
		stu.setAge(age);
		stu.setSex(sex);
		stu.setStatus("1");
		stu.setSummary(summary);
		
		StudentDao studentDao = new StudentDao();
		int ret = studentDao.updateStudent(stu);
		System.out.println("���½����"+ret);
		if(ret>0){
			request.setAttribute("msg", "ѧ����Ϣ���³ɹ���");
		}else{
			request.setAttribute("msg", "ѧ����Ϣ����ʧ�ܣ�");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	
		
	}
	//��ת�޸�ҳ��
	private void editStuIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.querySatudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/jsp/editStudent.jsp").forward(request, response);
	}

	//չʾѧ����Ϣ
	private void showStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.querySatudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/jsp/showStudent.jsp").forward(request, response);
		
	}

	//ɾ��ѧ����Ϣ
	private void delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		int ret = studentDao.deleteStudent(id);
		System.out.println("ɾ��ѧ���ɹ�id:"+id);
		if(ret>0){
			request.setAttribute("msg", "ѧ����Ϣɾ���ɹ���");
		}else{
			request.setAttribute("msg", "ѧ����Ϣɾ��ʧ�ܣ�");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	
		
	}

	//����ѧ����Ϣ
	private void saveStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schoolNum = request.getParameter("schoolNum");
		String name = request.getParameter("name");
		int age = new Integer(request.getParameter("age"));
		int sex = new Integer(request.getParameter("sex"));
		String summary = request.getParameter("summary");
		
		Student stu = new Student();
		stu.setSchoolNum(schoolNum);
		stu.setName(name);
		stu.setAge(age);
		stu.setSex(sex);
		stu.setSummary(summary);
		
		StudentDao studentDao = new StudentDao();
		int ret = studentDao.saveStudent(stu);
		
		if(ret>0){
			request.setAttribute("msg", "ѧ����Ϣ����ɹ���");
		}else{
			request.setAttribute("msg", "ѧ����Ϣ����ʧ�ܣ�");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	}

	//��ת���ҳ��
	private void addStuIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addStudent.jsp").forward(request, response);
		
	}

	//��ҳ
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		List<Student> list = studentDao.queryStudentList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

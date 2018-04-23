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
		//首页
		if("index".equals(method)){
			index(request,response);
		}
		
		//跳转添加页面
		if("addStuIndex".equals(method)){
			addStuIndex(request,response);
		}
		
		//保存学生信息
		if("saveStu".equals(method)){
			saveStu(request,response);
		}
		
		//删除学生信息
		if("delStu".equals(method)){
			delStu(request,response);
		}
		
		//展示学生信息
		if("showStu".equals(method)){
			showStu(request,response);
		}
		
		//跳转修改页面
		if("editStuIndex".equals(method)){
			editStuIndex(request,response);
		}
		
		//修改学生信息
		if("updateStu".equals(method)){
			updateStu(request,response);
		}
		
	}
	
	//修改学生信息
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
		System.out.println("更新结果："+ret);
		if(ret>0){
			request.setAttribute("msg", "学生信息更新成功！");
		}else{
			request.setAttribute("msg", "学生信息更新失败！");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	
		
	}
	//跳转修改页面
	private void editStuIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.querySatudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/jsp/editStudent.jsp").forward(request, response);
	}

	//展示学生信息
	private void showStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.querySatudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/jsp/showStudent.jsp").forward(request, response);
		
	}

	//删除学生信息
	private void delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = new Integer(request.getParameter("id"));
		StudentDao studentDao = new StudentDao();
		int ret = studentDao.deleteStudent(id);
		System.out.println("删除学生成功id:"+id);
		if(ret>0){
			request.setAttribute("msg", "学生信息删除成功！");
		}else{
			request.setAttribute("msg", "学生信息删除失败！");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	
		
	}

	//保存学生信息
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
			request.setAttribute("msg", "学生信息保存成功！");
		}else{
			request.setAttribute("msg", "学生信息保存失败！");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
	}

	//跳转添加页面
	private void addStuIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addStudent.jsp").forward(request, response);
		
	}

	//首页
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

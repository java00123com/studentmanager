<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java00123学生信息管理</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.table tbody tr td{
            vertical-align: middle;
        }
</style>
</head>
<body>
<div class="container" style="margin-top:20px;">
		<div class="row">
			<div class="col-xs-12" >
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							java00123学生信息管理
						</h3>
					</div>
					<div class="panel-body">
						
					<table class="table table-bordered">
					  <thead>
					    <tr>
					      <th>学号</th>
					      <th>姓名</th>
					      <th>年龄</th>
					      <th>性别</th>
					      <th>简介</th>
					      <th>操作</th>
					    </tr>
					  </thead>
					  <tbody>
					  
					  <c:choose>
					  	<c:when test="${list.size()==0}">未查询到学生信息</c:when>
					  	<c:otherwise>
					  		<c:forEach var="stu" items="${list }">
					  			<tr>
							      <td>${stu.schoolNum }</td>
							      <td>${stu.name }</td>
							      <td>${stu.age }</td>
							      <td>
							      	<c:if test="${stu.sex==1 }">男</c:if>
							        <c:if test="${stu.sex==2 }">女</c:if>
							      </td>
							      <td>${stu.summary }</td>
							      <td>
							      	<a class="btn btn-success"href="${pageContext.request.contextPath }/studentServlet?method=showStu&id=${stu.id}">
			                            <i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
			                        </a>
			                        <a class="btn btn-info" href="${pageContext.request.contextPath }/studentServlet?method=editStuIndex&id=${stu.id}">
			                            <i class="glyphicon glyphicon-edit icon-white"></i>修改
			                        </a>
			                        <a class="btn btn-danger" href="${pageContext.request.contextPath }/studentServlet?method=delStu&id=${stu.id}">
			                            <i class="glyphicon glyphicon-trash icon-white"></i>删除
			                        </a>
							      </td>
							    </tr>
					  		</c:forEach>
					  	</c:otherwise>
					  </c:choose>
					  
					    <tr>
					    	<td  colspan="6">
					    		<center>
					    		<a href="${pageContext.request.contextPath }/studentServlet?method=addStuIndex" class="btn btn-primary ">添加学生</a>
					    		</center>
					    	</td>
					    </tr>
					  </tbody>
					</table>
						
					</div>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>
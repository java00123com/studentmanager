<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top:20px;">
	<div class="row">
		<div class="col-xs-6 col-md-offset-3" >
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						学生信息展示
					</h3>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
					  <tbody>
					    <tr><td style="width:30%">学号：</td><td style="width:70%">${student.schoolNum }</td></tr>
					    <tr><td>姓名：</td><td>${student.name }</td></tr>
					    <tr><td>年龄：</td><td>${student.age }</td></tr>
					    <tr><td>性别：</td><td>
					    	<c:if test="${student.sex==1 }">男</c:if>
					    	<c:if test="${student.sex==2 }">女</c:if>
					    </td></tr>
					    <tr><td>简介：</td><td>${student.summary }</td></tr>
					  </tbody>
					</table>
					<center><button type="button" class="btn btn-primary " onclick="javascript:window.location.href='${pageContext.request.contextPath }/studentServlet?method=index'">返回首页</button></center>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
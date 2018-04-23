<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java00123学生信息添加</title>
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
							学生信息添加
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/studentServlet?method=saveStu" method="post">
							<div class="form-group">
						  		<label for="firstname" class="col-xs-2 control-label">学号</label>
						  		<div class="col-xs-8">
						  			<input type="text" class=" form-control" id="schoolNum" name="schoolNum"  placeholder="请输入名称">
						  		</div>
						    </div>
						    <div class="form-group">
						  		<label for="firstname" class="col-xs-2 control-label">姓名</label>
						  		<div class="col-xs-8">
						  			<input type="text" class=" form-control" id="name" name="name"  placeholder="请输入名称">
						  		</div>
						    </div>
						    <div class="form-group">
						  		<label for="firstname" class="col-xs-2 control-label">年龄</label>
						  		<div class="col-xs-8">
						  			<input type="text" class=" form-control" id="age" name="age" placeholder="请输入名称">
						  		</div>
						    </div>
						    <div class="form-group">
						  		<label for="firstname" class="col-xs-2 control-label">性别</label>
						  		<div class="col-xs-8">
						  			<select class=" form-control" id="sex" name="sex">
						  				<option value="1">男</option>
						  				<option value="2">女</option>
						  			</select>
						  		</div>
						    </div>
						    <div class="form-group">
						  		<label for="firstname" class="col-xs-2 control-label">简介</label>
						  		<div class="col-xs-8">
						  			<textarea rows="5" cols="50" id="summary" name="summary"></textarea>
						  		</div>
						    </div>
							<div class="form-group">
						  		<center><button type="submit" class="btn btn-primary " >提交</button></center>
						    </div>
						</form>
					</div>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>
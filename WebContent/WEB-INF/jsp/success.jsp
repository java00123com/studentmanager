<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示页面</title>
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
							结果提示
						</h3>
					</div>
					<div class="panel-body">
						<p style=" display: block; font-size: 18px; margin-top: 15px; color: #333; text-align:center; padding-left:5px;">
						${msg }</p>
						<center><button type="button" class="btn btn-primary " onclick="javascript:window.location.href='${pageContext.request.contextPath }/studentServlet?method=index'">返回首页</button></center>
					</div>
				</div>
			
			</div>
		</div>
	</div>
	
</body>
</html>
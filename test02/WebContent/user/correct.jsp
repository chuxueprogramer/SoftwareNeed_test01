<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>correct</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/messages_zh.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

<!-- 利用jquery的validate验证（这种验证方法简单便捷） -->

<script type="text/javascript">
	$().ready(
			function(){
				$("#form").validate({
					rules:{
						password:{
							required:true
						},
						password1:{
							required:true
						},
						password2:{
							required:true,
							equalTo:"#password1"
						}
					},
					messages : {
						password:{
							required:"旧密码不能为空"
						},
						password1:{
							required:"新密码不能为空"
						},
						password2:{
							required:"重复新密码不能为空",
							equalTo:"重复新密码需要和密码相同"
						}
					}
				});
			});
			
</script>
</head>
<body>
	<div class = "container">
	<div style = "height:30px"></div>
	
	<h3 class = "text-center">修改密码界面</h3>
	<div class = "col-md-6 col-md-push-3">
		<form action = "${pageContext.request.contextPath }/servlet/userServlet?method=correct" method = "post" class = "form" id = "form">
			<div class = "form-group">
				<input type = "password" class = "form-control"  name = "password" placeholder = "旧密码">
			</div>
			<div class = "form-group">
				<input type = "password" class = "form-control" id = "password1" name = "password1" placeholder = "新密码">
			</div>
			<div class = "form-group">
				<input type = "password" class = "form-control" name = "password2" placeholder = "重复新密码">
			</div>
			
			<button type = "submit" class = "btn btn-primary" style = "margin-left:70%;">修改</button>
		</form>
		<div class = "col-md-12">
		<c:if test="${param.status==1 }">
			<div class= "alert alert-success">
				修改成功！
			</div>
			
		</c:if>
		<c:if test="${param.status==2 }">
			<div class= "alert alert-danger">
				修改失败！
			</div>
			
		</c:if>
	</div>
		</div>
	</div>
</body>
</html>
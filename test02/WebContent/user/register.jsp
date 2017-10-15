<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
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
						username:{
							required:true
						},
						password:{
							required:true
						},
						password1:{
							required:true,
							equalTo:"#password"
						},
						phone:{
							required:true,
							rangelength:[11,11],
							digits:true
						},
						workplace:{
							required:true
						}
					},
					messages : {
						username:{
							required : "用户姓名不能为空"
						},
						password:{
							required:"密码不能为空"
						},
						password1:{
							required:"重复密码不能为空",
							equalTo:"重复密码需要和密码相同"
						},
						phone:{
							required:"联系电话不能为空",
							rangelength:"电话号码为11位数字",
							digits:"电话号码只能是数字"
						},
						workplace:{
							required:"所属单位不能为空"
						}
					}
				});
			});
			
</script>
</head>
<body>
	<div class = "container">
	<div style = "height:30px"></div>
	
	<h3 class = "text-center">用户注册界面</h3>
	<div class = "col-md-6 col-md-push-3">
		<form action = "${pageContext.request.contextPath }/servlet/userServlet?method=register" method = "post" class = "form" id = "form">
			<div class = "form-group">
				<input type ="text" class = "form-control" name = "username" placeholder = "用户姓名">
			</div>
			<div class = "form-group">
				<input type = "password" class = "form-control" id = "password" name = "password" placeholder = "密码">
			</div>
			<div class = "form-group">
				<input type = "password" class = "form-control" name = "password1" placeholder = "重复密码">
			</div>
			<div class = "form-group">
				<input type = "text" class = "form-control" name = "phone" placeholder = "手机号码">
			</div>
			<div class = "form-group">
				<input type = "text" class = "form-control" name = "workplace" placeholder = "所属单位">
			</div>
			<button type = "submit" class = "btn btn-primary" style = "margin-left:70%;">提交</button>
			<a href = "./login.jsp" class = "btn btn-primary" target= "_parent" >登录</a><!-- 在父框架集中打开 -->
		</form>
		<div class = "col-md-12">
		<c:if test="${param.status==1 }">
			<div class= "alert alert-success">
				注册成功！
			</div>
			
		</c:if>
		<c:if test="${param.status==2 }">
			<div class= "alert alert-danger">
				注册失败！
			</div>
			
		</c:if>
	</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/messages_zh.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$().ready(
			function(){
				$("#form").validate({
					rules:{
						nd_name:{
							required:true
						},
						nd_ms:{
							required:true,
							maxlength:500
						},
						
						nd_money:{
							required:true,
							number:true
						}
					},
					messages : {
						nd_name:{
							required : "技术需求名称不能为空"
						},
						nd_ms:{
							required:"描述不能为空",
							maxlength:"不能超过500字"
		
						},
						nd_money:{
							required:"金额不能为空",
							number:"必须输入数字"
						}
					}
				});
			});
			
</script>
</head>
<body>
	<div class = "container">
	<h3 class="text-center">河北省重大技术需求征集表</h3>
	<div class= "col-md-10 col-md-push-1">
	<form id = "form" role = "form" class = "form" method = "post" action = "${pageContext.request.contextPath }/servlet/needServlet?method=addNeed">
	<table class = " table table-bordered ">
		<tr>
			<td><lable for = "nd_name">技术需求名称</lable></td>
			<td colspan = "2"><input type = "text" name = "nd_name" style = "width:100%;height:20px;border:none;outline:none;"></td>
		</tr>
		<tr>
			<td colspan = "3"><textarea name = "nd_ms" class = "textarea" style = "width:100%;height:120px;border:none;outline:none;" >重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）</textarea></td>
		</tr>
		<tr>
			<td>研究类型</td>
			<td colspan = "2">
				<input type = "checkbox" name  = "nd_type" value = "1">基础研究
				<input type = "checkbox" name  = "nd_type" value = "2">应用研究
				<input type = "checkbox" name  = "nd_type" value = "3">试验发展
				<input type = "checkbox" name  = "nd_type" value = "4">研究发展与成果应用
				<input type = "checkbox" name  = "nd_type" value = "5">技术推广与科技服务
			</td>
		</tr>
		<tr>
			<td>技术需求合作模式</td>
			<td colspan = "2">
				<input type =  "radio" name = "nd_pa" value = "1">独立开发
				<input type =  "radio" name = "nd_pa" value = "2">技术转让
				<input type =  "radio" name = "nd_pa" value = "3">技术入股
				<input type =  "radio" name = "nd_pa" value = "4">合作开发
			</td>
		</tr>
		<tr>
			<td>计划总投资</td>
			<td><input type = "text" name = "nd_money" style = "width:100%;height:100%;border:none;outline:none;"></td>
			<td>万元</td>
		</tr>
	</table>
	<div>
	<button class = "btn btn-primary "  type = "submit" style = "margin-left:90%;">提交</button>
	</div>
	</form>
	<div class = "col-md-12">
		<c:if test="${param.status==1 }">
			<div class= "alert alert-success">
				添加成功！
			</div>
			
		</c:if>
		<c:if test="${param.status==2 }">
			<div class= "alert alert-danger">
				添加失败！
			</div>
			
		</c:if>
	</div>
	</div> 
	</div> 
</body>
</html>
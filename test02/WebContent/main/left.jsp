<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<style type="text/css">
	a{
		text-decoration:none;
		color:#000;
	}
	body{
		margin:0px;
		border-top:3px solid #ccc;
		border-right:3px solid #ccc;
	}
</style>
</head>

<body>
	<table style = "width:220px;height:200px;color:#000;">
	<thead><th style = "background:url(./images/index_06.JPG),repeat;color:#fff;height:40px;">系统菜单</th></thead>
	<tbody>
		<tr><td style = "background:url(./images/index_07.JPG),repeat;"><img style = "margin-left:15px;" src = "./images/index_08.png"><a href = "../need/add.jsp" target="mainAction">需求征集</a></td></tr>
		<tr><td style = "background:url(./images/index_07.JPG),repeat;"><img style = "margin-left:15px;" src = "./images/index_08.png"><a href = "${pageContext.request.contextPath }/servlet/needServlet?method=listNeed" target="mainAction">浏览需求</a></td></tr>
		<tr><td style = "background:url(./images/index_07.JPG),repeat;"><img style = "margin-left:15px;" src = "./images/index_08.png"><a href = "${pageContext.request.contextPath }/servlet/needServlet?method=lookNeed" target="mainAction">需求审核</a></td></tr>
		<tr><td style = "background:url(./images/index_07.JPG),repeat;"><img style = "margin-left:15px;" src = "./images/index_08.png"><a href = "../user/register.jsp" target="mainAction">用户注册</a></td></tr>
		<tr><td style = "background:url(./images/index_07.JPG),repeat;"><img style = "margin-left:15px;" src = "./images/index_08.png"><a href = "../user/correct.jsp" target="mainAction">修改密码</a></td></tr>
	</tbody>
		
	</table>
</body>
</html>

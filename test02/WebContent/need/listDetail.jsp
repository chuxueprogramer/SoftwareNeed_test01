<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listDetail</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container">
		<div style = "height:50px;width:100%;"></div>
	<h3 class = "text-center">技术需求详细信息</h3>
		<table class = "table table-striped">
			<tr>
				<td>序号</td>
				<td>${needBean.nd_id}</td>
			</tr>
			<tr>
				<td>技术需求名称</td>
				<td>${needBean.nd_name}</td>
			</tr>
			<tr>
				<td>重大科技需求概述</td>
				<td>${needBean.nd_ms}</td>
			</tr>
			<tr>
				<td>研究类型</td>
				<td>${needBean.nd_type}</td>
			</tr>
			<tr>
				<td>技术需求合作模式</td>
				
				<c:if test="${needBean.nd_pa==1 }">
					<td>独立开发</td>
				</c:if>
				<c:if test="${needBean.nd_pa==2 }">
					<td>技术转让</td>
				</c:if>
				<c:if test="${needBean.nd_pa==3 }">
					<td>技术入股</td>
				</c:if>
				<c:if test="${needBean.nd_pa==4 }">
					<td>合作开发</td>
				</c:if>
			</tr>
			<tr>
				<td>计划总投资</td>
				<td>${needBean.nd_money}</td>
			</tr>
			<tr>
				<td>审核状态</td>
				<c:if test="${needBean.nd_state==1 }">
					<td>未审核</td>
				</c:if>
				<c:if test="${needBean.nd_state==2 }">
					<td>已审核</td>
				</c:if>
				<c:if test="${needBean.nd_state==3 }">
					<td>被退回</td>
				</c:if>
			</tr>
			<tr>
				<td>提交日期</td>
				<td>${needBean.nd_time}</td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>look</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
</head>
<body>

	<div class = "container">
	<c:if test="${ param.status==1}">
	<h3 class = "text-center">河北省重大技术需求征集清单</h3>
	
	<div style = "height:50px;"></div>
		<table class = "table table-striped">
			<thead>
				<th>序号</th>
				<th>技术需求名称</th>
				<th>提交日期</th>
				<th>需求状态</th>
			</thead>
			<tbody>
				<c:forEach items="${needBeans }" var="item">
					<tr>
						<td>${item.nd_id}</td>
						<td><a href = "${pageContext.request.contextPath }/servlet/needServlet?method=lookNeed&nd_id=${item.nd_id}">${ item.nd_name}</a></td>
						<td>${item.nd_time}</td>
						<c:if test="${item.nd_state==1 }">
							<td>未审核</td>
						</c:if>
						<c:if test="${item.nd_state==2 }">
							<td>已审核</td>
						</c:if>
						<c:if test="${item.nd_state==3 }">
							<td>被退回</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${ param.status==3}">
		<div class = "col-md-12 alert alert-success">
			审核成功！
		</div>
	</c:if>	
	<c:if test="${ param.status==4}">
		<div class = "col-md-12 alert alert-danger">
			审核失败！
		</div>
	</c:if>
	</c:if>
	<c:if test="${ param.status==2}">
		<div class = "col-md-12 alert alert-danger">
			尚未录入需求信息！
		</div>
	</c:if>
	</div>
</body>
</html>
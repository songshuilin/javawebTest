<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">欢迎来到学生管理系统</h1>

	<table border="2" width="70%" align="center">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>专业</th>
			<th>电话</th>
			<th>兴趣</th>
			<th>描述自己</th>
		</tr>
		<c:forEach items="${requestScope.bean.list}" var="student">
			<tr>
				<td>${student.number}</td>
				<td>${student.name}</td>
				<td>${student.sex}</td>
				<td>${student.major}</td>
				<td>${student.phone}</td>
				<td>${student.hobby}</td>
				<td>${student.desc}</td>
				<td><a
					href="<c:url value='/StudentServlet?method=find&number=${student.number}'/>">编辑</a>
					<a
					href="<c:url value='/StudentServlet?method=delete&number=${student.number}'/>">删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>


	<center>
		第${bean.currentPage}页/共${bean.totlePage}页 <a
			href="<c:url value='/StudentServlet?method=findAll&currentPage=1'/>">首页</a>


		<%-- 计算begin、end --%>
		<c:choose>
			<%-- 如果总页数不足10页，那么把所有的页数都显示出来！ --%>
			<c:when test="${bean.totlePage <= 10 }">
				<c:set var="begin" value="1" />
				<c:set var="end" value="${bean.totlePage }" />
			</c:when>
			<c:otherwise>
				<%-- 当总页数>10时，通过公式计算出begin和end --%>
				<c:set var="begin" value="${bean.currentPage-5 }" />
				<c:set var="end" value="${bean.currentPage+4 }" />
				<%-- 头溢出 --%>
				<c:if test="${begin < 1 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="10" />
				</c:if>
				<%-- 尾溢出 --%>
				<c:if test="${end > bean.totlePage }">
					<c:set var="begin" value="${bean.totlePage - 9 }" />
					<c:set var="end" value="${bean.totlePage }" />
				</c:if>
			</c:otherwise>
		</c:choose>
		<%-- 循环遍历页码列表 --%>
		<c:forEach var="i" begin="${begin }" end="${end }">
		<a href="<c:url value='/StudentServlet?method=findAll&currentPage=${i}'/>">[${i }]</a>
		</c:forEach>

		<c:if test="${bean.currentPage<bean.totlePage}">
			<a
				href="<c:url value='/StudentServlet?method=findAll&currentPage=${bean.currentPage+1}'/>">下一页</a>
		</c:if>

		<a
			href="<c:url value='/StudentServlet?method=findAll&currentPage=${bean.totlePage}'/>">尾页</a>

	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">欢迎来到学生管理系统 </h1>

<table border="2"  width="70%" align="center">
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
<td>
${student.number}
</td>
<td>
${student.name}
</td>
<td>
${student.sex}
</td>
<td>
${student.major}
</td>
<td>
${student.phone}
</td>
<td>
${student.hobby}
</td>
<td>
${student.desc}
</td>
<td>
<a href="<c:url value='/StudentServlet?method=find&number=${student.number}'/>">编辑</a>
<a href="<c:url value='/StudentServlet?method=delete&number=${student.number}'/>">删除</a>
</td>
</tr>
</c:forEach>

</table>


<center>
第${bean.currentPage}页/共${bean.totlePage}页

<a href="<c:url value='/StudentServlet?method=findAll&currentPage=1'/>">首页</a>

<c:if test="${bean.currentPage>1}">
<a href="<c:url value='/StudentServlet?method=findAll&currentPage=${bean.currentPage-1}'/>">上一页</a>
</c:if>


<c:if test="${bean.currentPage<bean.totlePage}">
<a href="<c:url value='/StudentServlet?method=findAll&currentPage=${bean.currentPage+1}'/>">下一页</a>
</c:if>

<a href="<c:url value='/StudentServlet?method=findAll&currentPage=${bean.totlePage}'/>">尾页</a>

</center>
</body>
</html>
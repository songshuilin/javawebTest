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
<h1>学生编辑界面</h1>
<form  action="<c:url value='/StudentServlet?method=edit'/>" method="post" >
学  号：<input type="text" readonly="readonly" name="number" value="${requestScope.student.number }"><br/>
姓  名：<input type="text" name="name" value="${requestScope.student.name }"><br/>
性  别：<input type="text" name="sex" value="${requestScope.student.sex }"><br/>
专  业：<input type="text" name="major" value="${requestScope.student.major }"><br/>
电  话：<input type="text" name="phone" value="${requestScope.student.phone }"><br/>
兴  趣：<input type="text" name="hobby" value="${requestScope.student.hobby }"><br/>
简单介绍：<input type="text" name="desc"  value="${requestScope.student.desc}"><br/>
<input type="submit" value="确定">
<input type="reset" value="重置">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>注册界面</h1>
<form action="<c:url value='/RegistServlet?method=regist'/>" method="post">
用户名：<input type="text" name="username" value=""><br/>
密    码：<input type="password" name="password" value=""><br/>
<input type="submit" value="注册">
<input type="reset" value="重置">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/WEB-INF/tag/song.tld" %>
<%@ taglib prefix="my" uri="http://www.tgb.com/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("name", "zhangsan");
%>
<s:song/>
<s:song1>
${name}
</s:song1>
<br/>
<s:song3 a="true">
${name}wwwwww
</s:song3>
<br/>

</body>
</html>
<%@page import="com.spsp.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%
	String id = request.getParameter("uid");
	UserService service = new UserService();
	service.deleteUserById(id);
	
	response.sendRedirect("message.jsp?message=delete successful");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
</head>
<br>
<body>
</body>

</html>
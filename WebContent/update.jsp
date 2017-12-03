<%@page import="com.spsp.model.UserBean"%>
<%@page import="com.spsp.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<%
	String id = request.getParameter("uid");
	UserService service = new UserService();
	UserBean u = service.getUserById(id);
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户</title>
</head>
<body>
<form action="UserUpdateServlet">
	<table align="center" border="1" >
		<tr>
			<td>ID*：<input name="id" type="text" readonly="readonly" value="<%=u.getId() %>"></td>
		</tr>
		<tr>
			<td>姓名*：<input name="name" type="text" value="<%=u.getName() %>"></td>
		</tr>
		<tr>
			<td>年龄：<input name="age" type="text" value="<%=u.getAge() %>"></td>
		</tr>
		<tr>
			<td><input type="submit" value="更新"></td>
		</tr>
	</table>
</form>
</body>
</html>
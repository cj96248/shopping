<%@page import="com.spsp.model.UserBean"%>
<%@page import="com.spsp.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.spsp.*, java.util.*" %>

<%
	UserService service = new UserService();
	List<UserBean> list = service.getUsers();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1">
	<thead>
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>年齡</td>
			<td>注册时间</td>
			<td>状态</td>
			<td align="center">操作</td>
		</tr>
	</thead>
		<%
		for(Iterator<UserBean> it = list.iterator() ; it.hasNext();){
			UserBean u = it.next();
		%>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getName() %></td>
			<td><%= u.getAge() %></td>
			<td><%= u.getRdate() %></td>
			<td><%= u.getStatus().equals("A") ? "正常": "冻结" %>
			<td><a href="update.jsp">更新</a>&nbsp;&nbsp;<a href="delete.jsp">删除</a></td>
		</tr>	
		 <%
			}
		%>
</table>
</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spsp.service.*, com.spsp.model.*, java.util.*" %>
<%@ include file="menu.jsp" %>
<%
	String action = request.getParameter("action");
	List<UserBean> list1 = new ArrayList<>();
	if(action != null && action.equals("search")){
		String id = request.getParameter("search_id");
		String name = request.getParameter("search_name");
		
		UserService service = new UserService();
		if(id != null && !id.equals("")){
			UserBean user = service.getUserById(id);
			list1.add(user);
		} else if(name != null && !name.equals("")){
			list1 = service.getUserByName(name);
		}
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>
</head>
<body>
<br>
<div align="center">
<form action="search.jsp">
	<input type="hidden" name="action" value="search">
	<span>用户id<input type="text" name="search_id"></span>
	<span>姓名（关键字）<input type="text" name="search_name"></span>
	<input type="submit" value="搜索">
</form>
</div>
<br>
<table align="center" border="1">
	<%
		if(list1.size() >0 ){
	%>		
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
		}
	%>
		<%
		for(Iterator<UserBean> it = list1.iterator() ; it.hasNext();){
			UserBean u = it.next();
		%>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getName() %></td>
			<td><%= u.getAge() %></td>
			<td><%= u.getRdate() %></td>
			<td><%= u.getStatus().equals("A") ? "正常": "冻结" %>
			<td><a href="update.jsp?uid=<%=u.getId() %>">更新</a>&nbsp;&nbsp;<a href="frezon.jsp?uid=<%=u.getId() %>">冻结</a></td>
		</tr>	
		 <%
			}
		%>
</table>
</body>
<a href="#"><%=list1.size() %></a>
</html>
<%@page import="com.spsp.model.UserBean"%>
<%@page import="com.spsp.service.UserService"%>
<%@ page import="java.sql.*, com.spsp.*, java.util.*, com.spsp.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<%
	
	int pageSize = Prop.getProperties("num");
	int pageNo = 1;
	String pageNoString = request.getParameter("pageNo");
	if(pageNoString != null && !pageNoString.equals("")){
		pageNo = Integer.parseInt(pageNoString);
	}
	UserService service = new UserService();
	List<UserBean> list = service.getUsers((pageNo-1)*pageSize, pageSize);
	List<UserBean> listAll = service.getUsers();
	int totalPage = (listAll.size()+pageSize-1)/pageSize;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<br>
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
			<% if(u.getStatus().equals("A")){ %>
			<td><a href="update.jsp?uid=<%=u.getId() %>">更新</a>&nbsp;&nbsp;<a href="frezon.jsp?uid=<%=u.getId() %>">冻结</a></td>
			<% }%>
		</tr>	
		 <%
			}
		%>

</table>
<center>
Current : <%=pageNo %>
<% if(pageNo > 1){
	
	%>
<a href="list.jsp?pageNo=<%=pageNo-1 %>">Previous</a>&nbsp;&nbsp;&nbsp;
	<%
} %>
<% if(list.size() >= 5){
%>
<a href="list.jsp?pageNo=<%=pageNo+1 %>">Next</a>&nbsp;&nbsp;&nbsp; 
	<%
} %>
Total : <%=totalPage %>
</center>
</body>
<br>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到我的书店</title>
<style type="text/css">
body{
	background-color: #FFFABC;

}

</style>
</head>

<body>
<h3 align="center">书店后台登录</h3>
<form action="LoginServlet" method="post">
	<table align="center" border="1">
		<tr>
			<td>用户名<input name="user" type="text"></td>
		</tr>
		<tr>
			<td>密码<input name="password" type="password"></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></td>
		</tr>
	</table>
</form>
</body>
</html>
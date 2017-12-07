<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
This is index.jsp !

<form action="ssmuser/login" method="post">
用户名：<input type="text" name="username" value="solo"> <br>
密码：<input type="password" name="password" value="123"><br>
<input type="submit" value="登录">
<input type="reset" value="重置"><br>
</form>
<a href="ssmuser/regist">注册</a>





</body>
</html>
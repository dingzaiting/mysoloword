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
欢迎来到注册页面：<br>
<form action="ssmuser/regist" method="post">
用户名：<input type="text" name="username" value="solo"> <br>
密码：<input type="password" name="password" value="123"><br>
<input type="submit" value="注册">
<input type="reset" value="重置"><br>
</form>
<br>
<form  action="ssmuser/addFile" enctype="multipart/form-data" method="post">
<input type="file" name="pic">
<input type="submit" value="保存图片" >
</form >


</body>
</html>
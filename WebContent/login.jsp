<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<title>登录</title>
</head>
<body background="./img/bark.jpg" width="100%" height="100%">
<div class="text-center">
	<div class="bg-warning">${errMsg}</div>
	<form action="./login.do" method="post">
		<h1>登录</h1>
		用户名：<input type="text" name="username"/>
		密码：<input type="password" name="password"/>
		<input type="submit" value="提交"/>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body background="./img/bark.jpg" width="100%" height="100%">
<div class="text-center">
	<h1>您好，${currentUser.username}</h1>
	<img alt="头像" src="./uploads/${currentUser.filename}"/>
	<a href="./add.jsp"><h2>添加文章</h2></a>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>您好，${currentUser.username}</h1>
	<a href="./add.jsp">添加文章</a>
	<img alt="头像" src="./uploads/${currentUser.filename}"/>
</body>
</html>
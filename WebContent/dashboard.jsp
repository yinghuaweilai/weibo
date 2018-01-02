<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<title>我的微博主页</title>
</head>
<body background="./img/bark.jpg" width="100%" height="100%">
<div class="text-center">
	
	<h1>${currentUser.username}老板:</h1>
	
		<div id="shijian"></div>
	
	<img alt="头像" src="./uploads/${currentUser.filename}"/>
	
	<a href="./add.jsp"><h1>添加文章</h1></a>
	<a href="./list.do"><h1>管理微博</h1></a>
	<a href="./Logout"><h1>登出</h1></a>
</div>
</body>
<script type="text/javascript" src="./js/shijian.js"></script>
</html>
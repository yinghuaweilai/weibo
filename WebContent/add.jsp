<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<title>添加文章</title>
</head>
<body background="./img/bark.jpg" width="100%" height="100%">
<div class="text-center">
	<form action="./add.do" method="post">
		<img alt="头像" src="./uploads/${currentUser.filename}"/>
		<h2>奋笔疾书新文章</h2>
		标题：<input type="text" name="title"/>
		内容：<textarea rows="1" name="content"></textarea>
		<input type="submit" value="提交"/>
	</form>
	<a href="./dashboard.jsp"><h2>回到我的微博主页</h2></a>
	<a href="./list.do"><h2>回到我的微博管理</h2></a>
	<a href="./Logout"><h2>登出</h2></a>
</div>
</body>
</html>
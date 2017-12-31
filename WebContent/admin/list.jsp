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
<title>老板你乱写的所有文章</title>
</head>
<body>
	
	<img alt="头像" src="./uploads/${currentUser.filename}"/>
	<a href="./add.jsp">本老板还要乱写文章</a>
	<h1>瞎乱写文章列表</h1>
	<ul>
		<c:forEach var="t" items="${articles}">
			<li>
				<h3>${t.title}</h3>
				<p>${t.content}</p>
				<p>
					发表日期：<span>${t.publishDate}</span>
				</p> <a href="./del.do?id=${t.id}">删除</a>
			</li>
		</c:forEach>
	</ul>

	<div>
		<ul class="pagination">
			<c:if test="${current<=1 }">
			<li class="disabled">
				<a href="./list.do?page=${current}"><span aria-hidden="true">&laquo;</span></a>
			</li>
			</c:if>
			<c:if test="${current>1 }">
			<li class="abled">
				<a href="./list.do?page=${current-1}"><span aria-hidden="true">&laquo;</span></a>
			</li>
			</c:if>		
			<c:if test="${current <= 4}">
				<c:forEach var="num" begin="1" end="8">
					<li class="${num == current ? 'active' : ''}">
						<a href="./list.do?page=${num}">${num}</a>
					</li>
				</c:forEach>	
				<li><a>...</a></li>
				<li>
					<a href="./list.do?page=${total}">${total}</a>
				</li>	
			</c:if>
			<c:if test="${current > 4 && total-current > 4}">
				<li><a href="./list.do?page=1">1</a></li>
				<li><a>...</a></li>
				<c:forEach var="num" begin="${current-3}" end="${current+3}">
					<li class="${num == current ? 'active' : ''}">
						<a href="./list.do?page=${num}">${num}</a>
					</li>
				</c:forEach>	
				<li><a>...</a></li>
				<li>
					<a href="./list.do?page=${total}">${total}</a>
				</li>	
			</c:if>
	
			<c:if test="${total-current <= 4}">
							<li><a href="./list.do?page=1">1</a></li>
			
				<li><a>...</a></li>
				<c:forEach var="num" begin="${total-8}" end="${total}">
					<li class="${num == current ? 'active' : ''}">
						<a href="./list.do?page=${num}">${num}</a>
					</li>
				</c:forEach>	
			</c:if>
			<c:if test="${current>=total }">
			<li class="disabled">
				<a href="./list.do?page=${current}"><span aria-hidden="true">&raquo;</span></a>
			</li>
			</c:if>
			<c:if test="${current>=1 && current<total}">
			<li class="abled">
				<a href="./list.do?page=${current+1}"><span aria-hidden="true">&raquo;</span></a>
			</li>
			</c:if>	
			
		</ul>
	</div>

	
</body>
</html>
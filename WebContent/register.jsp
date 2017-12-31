<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/main.css" rel="stylesheet">
<title>用户注册</title>
</head>
<body background="./img/bark.jpg" width="100%" height="100%">
	<div class="container">
		<div class="panel panel-default col-md-offset-3 col-md-6 register-panel">
			<div class="h2 text-center">用户注册</div>
			<div class="pannel-body">
				<form class="form-horizontal" action="./uploadMulti.do" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-md-4">用户名</label>
						<div class="col-md-8">
							<input type="text" class="form-control" 
								name="username" id="username"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">密码</label>
						<div class="col-md-8">
							<input type="password" class="form-control" name="pwd"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">重新输入密码</label>
						<div class="col-md-8">
							<input type="password" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">性别</label>
						<div class="col-md-8">
							<label class="radio-inline">
								<input type="radio" name="sex" value="M">男
							</label>
							<label class="radio-inline">
								<input type="radio" name="sex" value="F">女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">上传头像</label>
						<div class="col-md-4">
							<input type="file" name="file" class="form-control" id="filechooser">
						</div>
						<div class="col-md-4 img-previewer">
							<img alt="图片预览" height="160" width="160" id="previewer"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4">兴趣爱好</label>					
						<select multiple name="interests" class="col-md-8">
							<option value="books">看书</option>
							<option value="balls">打球</option>
							<option value="music">音乐</option>
						</select>						
					</div>
					<div class="from-group">
						<label class="control-label col-md-4">验证码</label>
						<div class="col-md-4">
							<input type="text" name="vcode"/>
						</div>
						<div class="col-md-4">
							<img alt="验证码" src="./vcode"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-4">
							<button type="submit" class="btn btn-primary btn-block">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="./js/reg.js"></script>
</body>
</html>
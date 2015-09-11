<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/JTMS/core/loginStyle/css/bootstrap.min.css" />
<link rel="stylesheet" href="/JTMS/core/loginStyle/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/JTMS/core/loginStyle/css/unicorn.login.css" />
<title>欢迎进入JTMS</title>
</head>
<body>
	<div id="logo" style="text-align: center;color: white;">
		<h1>Welcome To JTMS</h1>
	</div>
	<div id="loginbox">
		<form id="loginform" class="form-vertical" action="/JTMS/login" method="post">
			<p>请输入账号和密码.</p>
			<div class="control-group">
				<div class="controls">
					<div class="input-prepend">
						<span class="add-on"><i class="icon-user"></i></span><input type="text" name="name" placeholder="Username" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="input-prepend">
						<span class="add-on"><i class="icon-lock"></i></span><input type="password" name="password" placeholder="Password" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<span class="pull-left"><a href="#" class="flip-link" id="to-recover">切换通道</a></span> <span
					class="pull-right"><input type="submit" class="btn btn-inverse" value="登录" /></span>
			</div>
		</form>
		<form id="recoverform" action="/JTMS/ext" class="form-vertical">
			<p>进入ext测试环境</p>
			<div class="control-group">
				<div class="controls">
					<div class="input-prepend">
						<span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="什么也不用填" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<span class="pull-left"><a href="#" class="flip-link" id="to-login">&lt; 返回至登录</a></span> <span
					class="pull-right"><input type="submit" class="btn btn-inverse" value="LET'S GO" /></span>
			</div>
		</form>
	</div>

	<script src="core/jquery/jquery-1.11.2.min.js"></script>
	<script src="core/loginStyle/js/unicorn.login.js"></script>
</body>
</html>
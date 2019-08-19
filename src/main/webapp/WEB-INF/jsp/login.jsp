<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<style type="text/css">
	body{
		background-image: url("http://pic2bj.shejibao.com/img/2016/07/06/2a9ee09a5d549166b80e49ac08bba39d.jpg@!width_800");
		background-repeat: no-repeat;
		background-size: 100%;
	}
	.container{
		padding:10px;
		margin:5px;
	}
	h3{
		margin: 5px;
		padding: 5px;
	}
	label{
		display:inline-block;
		width:70px;
		height: 24px;
		text-align: right;
		padding: 5px;
		margin: 5px;
	}
	.loginContainer{
		position:absolute;
		left:70%;
		background-color: #fff;
		padding:20px;
		width:300px;
		height: 300px;
		box-shadow: 2px 2px 10px #888888;
		margin-top: 80px;
		border-radius: 4px;
	}
	.loginrow{
		margin:5px;
	}
	.inputbox{
		height: 30px;
		width: 160px;
		padding:2xp;
		padding-left:8px;
		margin: 5px;
		border-radius: 16px;
	}
	#username{
		margin-top: 15px;
	}
	#loginBtn{
		position:relative;
		left:15px;
		height: 40px;
		width: 250px;
		padding:4xp;
		margin: 8px;
		border-radius: 10px;
		color:#fff;
		background-color: #2fb3ff;
	}
	#loginBtn:hover{
		background-color: #2fb3ee;
	}
	a{
		text-decoration: none;
		font-size: 80%;
		color:#000;
		margin-right: 10px;
		margin-left: 10px;
	}
	a:hover {
		color: #2fb3fc
	}
	#help{
		text-align: right;
	}
</style>
</head>
<body>
	<div class="container">
	<div class="loginContainer">
	<h3>用户登录</h3>
		<form id="loginform" action="login" method="post">
			<p class="loginrow"><label>登录类型</label>
			<input type="radio" name="role" value="2" checked>用户
			<input type="radio" name="role" value="1">管理员
			</p>
			<p class="loginrow" id="username">
			<label>用户名</label><input class="inputbox" type="text" name="username" placeholder="用户名" required></p>
			<p class="loginrow">
			<label>密码</label><input class="inputbox" type="password" name="password" placeholder="密码" required></p>
			<p class="loginrow"><input id="loginBtn" type="submit" value="登录">
		</form>
		<p id="help"><a href="#">忘记密码</a>|<a href="register">注册</a>|<a href="#">帮助</a> | <a href="home">游客访问</a></p>
	</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册新用户</title>
<style type="text/css">
body {
	background-image:url("http://pic2bj.shejibao.com/img/2016/07/06/2a9ee09a5d549166b80e49ac08bba39d.jpg@!width_800");
	background-repeat:no-repeat;
	background-size:100%;
}

.container {
	padding: 10px;
	margin: 5px;
}
.registrtionForm {
	position: absolute;
	left: 5%;
	background: rgba(0, 0, 0, 0.1);
	padding: 15px;
	padding-left:50px;
	width: 340px;
	height: auto;
	box-shadow: 2px 2px 10px #888888;
	border-radius: 4px;
}
.label {
	display: inline-block;
	width: 66px;
	height: 24px;
	text-align: right;
	padding: 4px;
	margin: 3px;
	margin-right: 0;
	background-color: #fff;
	border-top-left-radius: 16px;
	border-bottom-left-radius: 16px;
	border-style: inset;
	border-right-style: none;
	text-align: center;
}
.inputbox {
	height: 30px;
	width: 196px;
	padding-left: 8px;
	margin: 3px;
	border-radius: 16px;
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
	margin-left: 0;
	border-style: inset;
	border-left: 1px solid #ddd;
}
.inputbox:hover{
	background-color: rgb(165,229,254);
}
.inputbox:focus{
	background-color: rgb(165,229,254);
}
#username {
	margin-top: 15px;
}
.btn {
	height: 40px;
	width: 120px;
	padding: 4xp;
	margin: 5px;
	border-radius: 10px;
	color: #fff;
	background-color: #2fb3ee;
	font-size: 110%;
}
.btn:hover {
	background-color: #2fb3ff;
}
a {
	text-decoration: none;
	font-size: 80%;
	color: #000;
	margin-right: 10px;
	margin-left: 10px;
}
a:hover {
	color: #2fb3fc
}

h2 {
	font-size: 1.31em;
}
</style>
</head>
<body>
	<div class="container">
		<div class="registrtionForm">
		<h2>注册新用户</h2>
		<form action="register" method="post">
			<p><label class="label">用户名</label><input class="inputbox" type="text" placeholder="用户名-必填" name="username" required></p>
			<p><label class="label">密码</label><input class="inputbox" type="password" placeholder="密码-必填" name="password" required></p>
			<p><label class="label">确认密码</label><input class="inputbox" type="password" placeholder="确认密码-必填" name="repeatPassword" required></p>
			<p><label class="label">昵称</label><input class="inputbox" name="displayName" placeholder="昵称-必填" required></p>
			<p><label class="label">性别</label>
			<input  type="radio" name="sex" value="男" checked>男
			<input type="radio" name="sex" value="女">女
			</p>
			<p><input class="btn" type="submit" value="注 册">
			<input class="btn" type="reset" value="重 置"></p>
		</form>
		<p style="text-align: left;margin:15px">已有账号？立即<a href="login" >登录</a></p>
		</div>
	</div>
</body>
</html>
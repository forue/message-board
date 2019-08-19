<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录结果</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<h2>用户登录结果</h2>
<p>{ result }</p>
<p>欢迎回来，${ sessionScope["scopedTarget.userState"].username }</p>
<p>点击进入<a href="/">首页</a>登录</p>
</body>
</html>
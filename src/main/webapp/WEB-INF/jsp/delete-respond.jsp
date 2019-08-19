<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除回复</title>
</head>
<body>
	你确定要删除回复吗？
	<form action="delete-respond" method="post">
		<p><input name="rid" value="${ rid }" hidden="true"></p>
		<p><input type="submit" value="确定"></p>
	</form>
	<p>返回<a href="home">首页</a>
</body>
</html>
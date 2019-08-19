<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改回复</title>
</head>
<body>
<h3>更改回复</h3>
<form action="modify-respond" method="post">
	<p><input name="rid" value="${ rid }" hidden="true"></p>
	<p><input name="context" value="${ context }">
	<p><input type="submit" value="更改"></p>
</form>
<p>返回<a href="home">首页</a></p>
</body>
</html>
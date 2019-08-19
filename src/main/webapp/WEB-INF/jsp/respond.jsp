<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回复${ users.username }</title>
</head>
<body>
<form action="respond" method="post">
	<p><input name="mid" value="${ mid }" hidden="true"></p>
	<p><input type="text" name="context"></p>
	<p><input type="submit" value="回复">
</form>
<p>返回<a href="home">首页</a></p>
</body>
</html>
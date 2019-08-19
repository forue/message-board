<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改留言</title>
</head>
<body>
<h3>更改留言</h3>
<form action="modify-message" method="post">
	<p><input name="mid" value="${ message.id }" hidden="true"></p>
	<p><textarea name="context" cols="60" rows="3">${ message.context }</textarea></p>
	<p><input type="submit" value="更改"></p>
</form>
<p>返回<a href="home">首页</a></p>
</body>
</html>
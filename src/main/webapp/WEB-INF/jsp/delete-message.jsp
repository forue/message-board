<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除留言</title>
</head>
<body>
	你确定要删除留言吗？
	<form action="delete-message" method="post">
		<input name="mid" value="${ message.id }" hidden="true">
		<input type="submit" value="确定">
	</form>
	<p>返回<a href="home">首页</a>
</body>
</html>
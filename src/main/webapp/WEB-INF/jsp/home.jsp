<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言板主页</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/css/mystyle.css"/>
<style type="text/css">
	body {
		background-image:url("http://pic2bj.shejibao.com/img/2016/07/06/2a9ee09a5d549166b80e49ac08bba39d.jpg@!width_800");
		background-repeat:no-repeat;
		background-attachment:fixed;
		background-size:100%;
	}
	.message-display{
		position:relative;
		left:15%;
		height:auto;
		width: 70%;
		background-color: #f1f1f1;
		border-radius: 4px;
		padding: 10px;
		padding-left:30px;
		padding-right:30px;
		margin-bottom: 15px;
	}
	.pagenagivat{
		text-align: center;
	}
	.operation{
		margin:40px;
		text-align: center;
	}
	.messageedit{
		text-align: right;
	}
	.reply-diplay{
		position:relative;
		left:30%;
		height:auto;
		width: 55%;
		background-color: #f1f1f1;
		border-radius: 4px;
		padding: 10px;
		padding-left:30px;
		padding-right:30px;
		margin-bottom: 15px;
		display: none;
	}
	ul{
		position:relative;
		left:28%;
		list-style-position: outside;
	}
	ul li{
		list-style:none;
		float: left;
		margin:0;
		border-radius: 2px;
	}
	.editMessage{
		padding:20px;
		margin: 10px;
	}
	.loginwindow,.ensure{
		height: auto;
		width: 250px;
		position: fixed;
		top: 15%;
		left: 40%;
		border:1px solid #fff;
		border-radius:4px;
		margin:15px;
		padding:20px;
		display: none;
		background-color: #fff;
	}
	
</style>
</head>
<body>
<div class="container">
<h2>留言板主页</h2>
<p>当前用户：${ sessionScope["scopedTarget.userState"].username==null?
	"游客 ":sessionScope["scopedTarget.userState"].username }&nbsp 
	<c:choose>
		<c:when test="${ sessionScope['scopedTarget.userState'].loggiedIn}">
			<a href="javascript:;" id="logoutbtn">注销</a></c:when>
		<c:otherwise> 
			<a href="login" >登录</a> <a href="register">注册</a> 
		</c:otherwise>
	</c:choose></p>
<c:forEach var="message" items="${ messages }">
	<div class="message-display" >
	<p>${ message.user.username } : ${ message.context }</p>
	<fmt:formatDate var="publishedTime" value="${ message.publishedTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
	<p>&nbsp;&nbsp;--&nbsp;${ publishedTime } </p>
	<c:choose>
	<c:when test="${ message.user.username eq sessionScope['scopedTarget.userState'].username 
		and sessionScope['scopedTarget.userState'].role == 2}">
		<p class="messageedit">
		<a class="btn btn-primary" href="modify-message?mid=${ message.id }">修改留言</a> 
		<a class="btn btn-primary" href="delete-message?mid=${ message.id }">删除留言</a> 
		<button class="btn btn-primary" id="${ message.id }b" >展开回复</button></p>
	</c:when>
	<c:when test="${ sessionScope['scopedTarget.userState'].role == 1 }">
		<p class="messageedit">
		<a class="btn btn-primary" href="delete-message?mid=${ message.id }">删除留言</a>
		<c:if test="${ message.respond == null }">
			<a class="btn btn-primary" href="respond?mid=${ message.id }">回复留言</a>
		</c:if> 
		 <button class="btn btn-primary" id="${ message.id }b" >展开回复</button></p>
	</c:when>
	<c:otherwise>
		<p class="messageedit">
		<button class="btn btn-primary" id="${ message.id }b">展开回复</button></p>
	</c:otherwise>
	</c:choose>
	</div>
	<div class="reply-diplay" id="${ message.id }br">
	<c:choose>
		<c:when test="${ message.respond.context == null }">
			<p>管理员暂未回复</p>
		</c:when>
		<c:otherwise>
			<p>管理员 ：${ message.respond.context }</p>
			<c:if test="${ sessionScope['scopedTarget.userState'].role == 1 }">
			<p style="text-align: right;">
			<a class="btn btn-primary" href="delete-respond?rid=${ message.respond.id }">删除回复</a>
			<a class="btn btn-primary" href="modify-respond?rid=${ message.respond.id }">修改回复</a>
			</p>
			</c:if>
		</c:otherwise>
	</c:choose>
	</div>
</c:forEach>

<div class="operation">
<c:choose>
	<c:when test="${ sessionScope['scopedTarget.userState'].loggiedIn}">
		<ul>
			<c:forEach var="page" begin="1" end="10">
				 <li><a class="btn btn-info" href="?page=${ page }">${ page }</a></li> 
			</c:forEach>
		</ul><br><br>
		<c:if test="${ sessionScope['scopedTarget.userState'].role == 2 }">
			<div class="editMessage">
			<f:form action="home">
				<textarea rows="3" cols="60" name="newMessage">${ newMessage }</textarea>
				<p><input class="btn btn-success" type="submit" value="发表留言"/>	
				<input class="btn btn-warning" type="reset" value="清空"/></p>
			</f:form>
			</div>
		</c:if>
	</c:when>
	<c:otherwise> 
		<p>查看更多留言请 <a class="btn btn-primary" id="loginbtn" href="javascript:;">登录</a></p>
		<p>还没有账号？立即 <a href="register">注册</a></p>
	</c:otherwise>
</c:choose>
	<div class="loginwindow" >
	<button type="button" class="close" aria-label="Close">
		<span aria-hidden="true">&times;</span></button>
		<form action="login" method="post">
			<h3><small>用户登录</small></h3>
			<p>
			<input type="radio" name="role" value="2" checked>用户
			<input type="radio" name="role" value="1">管理员
			</p>
			<p><input type="text" name="username" placeholder="用户名" required></p>
			<p><input type="password" name="password" placeholder="密码" required></p>
			<p>
			<input type="submit" value="登录" class="btn btn-success">
			<input class="btn btn-danger" type="button" value="取消">
			</p>
		</form>
	</div> 
	<div class="ensure" id="logoutensure">
	<button type="button" class="close" aria-label="Close">
		<span aria-hidden="true">&times;</span></button>
		<h3><small>注销确认</small></h3>
		<form action="logout" method="post">
			<p>您确定注销吗？</p>
			<p><input type="submit" value="确定">
		</form>
	</div>
</div>
<script>
	$(document).ready(function(){
		$("button").click(function(){
			var id = $(this).attr("id");
			var respondId = id+"r";
			$("#"+respondId).toggle(400);
			if($("#"+id).text() == "收起回复"){
				$("#"+id).text("展开回复");
			}else{
				$("#"+id).text("收起回复");
			}
		});
		$("#loginbtn").click(function(){
			  $(".loginwindow").show(300);
		});
		$("#logoutbtn").click(function(){
			  $("#logoutensure").show(300);}
		);
		$(".close").click(function(){
			 $(".loginwindow").hide(300);
			 $("#logoutensure").hide(300);
		});
		$(".btn-danger").click(function(){
			 $(".loginwindow").hide(300);
			 $("#logoutensure").hide(300);
		});
	});
</script>
</div>
</body>
</html>
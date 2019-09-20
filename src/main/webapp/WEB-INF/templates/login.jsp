<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<script type="text/javascript" src="./static/js/jquery.min.js"></script>
		<link rel="stylesheet" href="./static/css/bootstrap.css">
		<script type="text/javascript" src="./static/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container" style="width: 30%;">
			<form class="form-signin" action="./login" method="post">
				<h2 class="form-signin-heading">LOGIN</h2>
				<label for="inputEmail" class="sr-only">Email address</label>
		        <input type="text" id="name" class="form-control" name="name" required autofocus>
		        <label for="inputPassword" class="sr-only">Password</label>
		        <input type="password" id="password" class="form-control" name="password" required>
		        <input type="submit" value="LOGIN" class="btn btn-block">
			</form>
		</div>
	</body>
</html>

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
		<link rel="stylesheet" href="./static/css/common.css">
	</head>
	<body>
		<div class="container login-container">
			<form class="form-signin" action="./login" method="post">
				<h2 class="form-signin-heading text-center">LOGIN</h2>
				<div class="form-group">
					<label for="name">Username</label>
			        <input type="text" id="name" class="form-control" name="name" required autofocus>
		        </div>
		        <div class="form-group">
			        <label for="password">Password</label>
			        <input type="password" id="password" class="form-control" name="password" required>
			    </div>
		        <input type="submit" value="LOGIN" class="btn btn-block btn-primary">
			</form>
		</div>
	</body>
</html>

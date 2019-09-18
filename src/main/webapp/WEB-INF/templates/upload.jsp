<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>UPLOAD</title>
		<script type="text/javascript" src="./static/js/jquery.min.js"></script>
		<link rel="stylesheet" href="./static/css/bootstrap.css">
		<script type="text/javascript" src="./static/js/bootstrap.min.js"></script>
	</head>
	<body>
		<form action="upload" method="post" enctype="multipart/form-data" class="">
			<input type="file" name="userFile" id="userFile" class="form-control"/><br />
			<input type="submit" value="上传" class="btn btn-default"/>
		</form>
	</body>
</html>
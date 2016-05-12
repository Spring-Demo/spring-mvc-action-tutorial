<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!</h1>
	<form action="../mvc/upload" method="post" enctype="multipart/form-date">
		<input type="file" name="file" /><br>
		<input type="submit" value="submit" />
	</form>


	<form action="rest/user/1" method="post">
		<input type="hidden" name="_method" value="PUT"> 
		<input type="submit" value="put">
	</form>

	<form action="rest/user/1" method="post">
		<input type="submit" value="post">
	</form>

	<form action="rest/user/1" method="get">
		<input type="submit" value="get">
	</form>

	<form action="rest/user/1" method="post">
		<input type="hidden" name="_method" value="DELETE"> 
		<input type="submit" value="delete">
	</form>
</body>
</html>
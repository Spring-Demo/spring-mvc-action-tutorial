<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//cdn.bootcss.com/jquery/2.2.3/jquery.js"></script>
<title>Ajax Page</title>
</head>
<body>
	<h1>Ajax Page!</h1>
	name: <input type="text" id="name" placeholder="please type the name" /><br>
	<button id="btn">点击调用Ajax</button>
</body>

<script>
	$(function() {
		$("#btn").click(function() {
			$.post("../getPerson", {
				name : $("#name").val()
			}, function(data) {
				alert(data);
			});
		});
	});
</script>
</html>
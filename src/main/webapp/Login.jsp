<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style type="text/css">
*{
margin: 0px;
}
form{
border: 1px solid black;
height: 100vh;
}
div {
	border: 1px solid black;
	height: 250px;
	width: 515px;
	padding: 25px;
	margin-left: 25%;
	margin-top: 15%;
	position: absolute;
}
#pro{
height: 10px;
width: 10px;
position: absolute;
border-radius: 50px;
}
i{
font-size: 50px; 
}
#content{
position: absolute;
}
</style>
</head>
<body>
	<form action="login" method="post">
		<div>
		<div id="pro"><i class="fa-solid fa-user"></i></div>
		<div id="content">
		Email: <input type="text" name="email"><br><br>
		Password: <input type="text" name="password"><br><br>
		<button>Login</button>
		</div>
		
		</div>
	</form>

	<%
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (message != null) {
	%>
	<%=message%>
	<%
	}
	%>
	
	<script src="https://kit.fontawesome.com/4364a58746.js" crossorigin="anonymous"></script>
</body>
</html>
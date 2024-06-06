<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin: 0px;
padding: 0px;
}
a{
height: 25px;
width: 25px;
background-color: white;
text-decoration: none;
padding: 20px 35px 20px 25px;
border-radius: 15px;
background-color: navy;
color: white;
font-family: sans-serif;
font-size: 20px;
font-weight: 700;
position: relative;
opacity: .6;
margin-left: 25px;
}
#maindiv{
height: 100vh;
background-image: url("https://cdn.pixabay.com/photo/2022/03/31/10/48/plain-background-7102746_1280.png");
background-repeat: no-repeat;
background-size: cover;
display: flex;
align-items: center;
}

#div1{
border: 1px solid black;
padding: 15%;
padding-right: 25%;
margin-left: 30%;
margin-top: 6%;
background-color: white;
opacity: .1;
border-radius: 25px;
position: absolute;
}

#anch{
margin-top: 6%;
margin-left: 38.8%;
}


</style>
</head>
<body>
<div id="maindiv">
<div id="div1" ></div>
<div id="anch"><a href="Login.jsp">Login</a>
<a href="Signup.jsp">SignUp</a></div>
</div>
<div id="subdiv">
</div>
</body>
</html>
<%@page import="DTO.Task" %>
<%@page import="DTO.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Task task = (Task) request.getAttribute("task"); %>

<form action="update" method="post">
Task Id: <input type="text" name="taskid" ><br><br>
Task Title: <input type="text" name="tasktitle"><br><br>
Task Description: <input type="text" name="taskdescription"><br><br>

Current Task Priority: <h3><%= task.getTaskPriority() %></h3>

Task Priority: <input type="radio" name="taskpriority" value="low">Low
<input type="radio" name="taskpriority" value="high">High <br><br>
Task Due Date: <input type="date" name="taskduedate"><br><br>
<input type="submit">


</form>
</body>
</html>
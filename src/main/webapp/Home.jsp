<%@page import="DTO.Task" %>
<%@page import="DTO.User" %>
<%@page import="java.util.List" %>
<%@page import="DAO.Dao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style type="text/css">
#anchor1{
padding: 10px;
background-color: purple;
color: white;
text-decoration: none;
}
</style>
</head>
<body>
<h1>Home Page</h1>
<a href="AddTask.jsp" id="anchor1">Add Task</a>

<% User u = (User)request.getSession().getAttribute("user"); %>
<% int userid = u.getUserId(); %>

<% Dao dao = new Dao(); 

 List<Task> tasks= dao.getAllTaskById(u.getUserId()); %>

<table>
<tr>
<th>Id</th>
<th>Title</th>
<th>Description</th>
<th>Priority</th>
<th>Due Date</th>
<th>Delete</th>
</tr>

<%for(Task task: tasks){ %>
<tr>
<td><%= task.getTaskId() %></td>
<td><%= task.getTaskTitle() %></td>
<td><%= task.getTaskDescription() %></td>
<td><%= task.getTaskPriority() %></td>
<td><%= task.getTaskDueDate() %></td>
<td> <a href="delete?id=<%= task.getTaskId() %>">Delete </a></td>

<%} %>
</tr>
</table>
</body>
</html>
<%@page import="application.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Note</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f5f5f5;
        margin: 20px;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4285f4;
        color: #fff;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #357ae8;
    }
</style>
</head>
<body>
<% Notes n = (Notes) request.getAttribute("note"); %>
<form method="post" action="update">
    <input type="hidden" name="id" value="<%= n.getId()%>">
    <input type="hidden" name="userId" value="<%= n.getUserId()%>">
    <input type="text" name="title" value="<%=n.getTitle() %>" >
    <br> <br>
    <input value="<%=n.getNote() %>" name="note" >
    <input type="submit" value="Update Note">
</form>
</body>
</html>

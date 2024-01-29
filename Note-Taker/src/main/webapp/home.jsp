<%@page import="application.Notes"%>
<%@page import="java.util.List"%>
<%@page import="application.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            width: 60%;
            margin: auto;
            background-color: #f8f9fa;
        }

        h1 {
            color: #007bff; 
            margin-bottom: 10px;
        }

        a {
            text-decoration: none;
            color: #28a745; 
            font-weight: bold;
            margin-bottom: 20px;
            display: inline-block;
            padding: 10px 15px;
            border-radius: 4px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        a:hover {
            background-color: #218838; 
            color: #fff;
        }

        hr {
            border: 1px solid #ccc;
            margin: 20px 0;
        }

        form {
            margin-top: 20px;
            display: flex;
            align-items: center;
        }

        input[type="search"] {
            flex: 1;
            padding: 8px;
            margin-right: 10px;
            border: 1px solid #6c757d;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 15px;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3; 
        }

        strong {
            color: #007bff;
        }

        h1 {
            color: #333;
            margin-bottom: 5px;
        }

        p {
            color: #666;
            margin-bottom: 10px;
        }

        button {
            background-color: #d9534f;
            color: #fff;
            border: none;
            padding: 5px 10px;
            margin-right: 10px;
            cursor: pointer;
        }

        button:hover {
            background-color: #c9302c;
        }

        .note {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .note-container {
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            background-color: #fff;
            margin-bottom: 20px;
        }

        .note-details {
            flex: 1;
        }

        .note-buttons {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <%
        Register r = (Register) request.getAttribute("register");
        List<Notes> note = (List<Notes>) request.getAttribute("note");
    %>

    <h1>Welcome, <%= r.getUserName() %>!</h1>
    
    <a href="<%= "add?id=" + r.getUserId() %>">Add New Note</a>
    
    
    <hr>
    
    <div class="note">
        <form method="post" action="crud">
            <%
            for (Notes n : note) {
            %>
            <a href="<%= "detail?id=" + n.getId()%>">
				<div class="note-container">
                <div class="note-details">
                    <strong><%= n.getId() %></strong>
                    <h1><%= n.getTitle() %></h1>
                    <p><%= n.getTime() %></p>
                </div>
                <div class="note-buttons">
                    <input value="<%= n.getId() %>" type="hidden" name="id">
                    <input value="<%= r.getUserId() %>" type="hidden" name="user">
                    <button type="submit" name="action" value="delete">Delete</button>
                    <button type="submit" name="action" value="edit">Edit</button>
                </div>
            </div>            
            </a>
            <%
            }
            %>
        </form>
    </div>
</body>
</html>

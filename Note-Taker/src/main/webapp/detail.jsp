<%@page import="application.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Note Detail</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background-color: #f8f9fa; /* Light Gray */
        }

        h1 {
            color: #007bff; /* Blue */
            margin-bottom: 10px;
        }

        .note-details {
            width: 60%;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .note-content {
            color: #333;
            margin-bottom: 15px;
            line-height: 1.6;
        }

        .timestamp {
            color: #666;
        }
    </style>
</head>
<body>
    <% Notes n = (Notes) request.getAttribute("note"); %>

    <div class="note-details">
        <h1><%= n.getTitle() %></h1>
        <div class="note-content"><%= n.getNote() %></div>
        <p class="timestamp">Created on: <%= n.getTime() %></p>
    </div>
</body>
</html>

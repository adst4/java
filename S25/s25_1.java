<%@ page language="java" %> 
<%@ page import="java.io.*, java.util.*" %> 
<%
    String name = request.getParameter("name"); 
    int age = Integer.parseInt(request.getParameter("age")); 
    String message;
    if (age >= 18) { 
        message = name + ", you are eligible to vote.";
    } else { 
        message = name + ", you are not eligible to vote.";
    } 
%> 
<!DOCTYPE html>
<html>
<head>
    <title>Voting Eligibility Checker</title>
</head>
<body>
    <h3><%= message %></h3>
    <form method="post" action="">
        <label for="name">Name:</label> 
        <input type="text" name="name" id="name" required><br><br> 

        <label for="age">Age:</label> 
        <input type="number" name="age" id="age" required><br><br> 

        <input type="submit" value="Check Eligibility"> 
    </form>
</body>
</html>

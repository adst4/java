<%@ page language="java" %> 
<%@ page import="java.io.*, java.util.*" %> 
<% 
 String username = request.getParameter("username"); 
 String password = request.getParameter("password"); 
 if (username.equals(password)) { 
 response.sendRedirect("Login.html?message=Login Successfully"); 
 } else { 
 response.sendRedirect("Error.html?message=Login Failed"); 
 } 
%>
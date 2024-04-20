<%@page language="java" %>

<%
	
	String no = request.getParameter("no");
	int length = no.length();
	int first =  Integer.parseInt("" +no.charAt(0));
	int last = Integer.parseInt("" +no.charAt(length-1));
	int sum = first + last;
	out.println("<b style=\"color : red\" >Sum Is : " +sum +"</b>");

%>

<%@ page language="java" %> 
<html> 
<head> 
 <title>Reverse String</title> 
</head> 
<body> 
 <h2>Enter a string to reverse:</h2> 
 <form method="post" action="reverse.jsp"> 
 <input type="text" name="stringToReverse"> 
 <input type="submit" value="Reverse"> 
 </form> 
 <% 
 String inputString = request.getParameter("stringToReverse"); 
 if (inputString != null) { 
     // Reverse the input string
     StringBuilder reversedString = new StringBuilder(inputString);
     reversedString.reverse();
     
     // Display the reversed string
     out.print("<h2>Reversed string: " + reversedString + "</h2>"); 
 } 
 %> 
</body> 
</html>

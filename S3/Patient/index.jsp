<!DOCTYPE html>
<html lang="en">
<head>
    
</head>
<body>
    <form action="index.jsp">
        Enter P.No :
        <input type="text" name="pno">
        <br>
        Enter PName :
        <input type="text" name="name">
        <br>
        Enter Address :
        <input type="text" name="add">
        <br>
        Enter Age :
        <input type="text" name="age">
        <br>
        Enter Disease :
        <input type="text" name="disease">
        <br>
        <input type="submit" value="Show Table">
    </form>

<table border="1">
    <tr>
        <th>Pno</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Disease</th>
    </tr>
    <tr>
        <td><%=request.getParameter("pno") %></td>
        <td><%=request.getParameter("name") %></td>
        <td><%=request.getParameter("add") %></td>
        <td><%=request.getParameter("age") %></td>
        <td><%=request.getParameter("disease") %></td>
    </tr>
</table>


</body>
</html>



<%@page language="java" %>
<%
    int no = Integer.parseInt(request.getParameter("no"));

    for(int i=2;i<=no/2;i++)
    {
        if(no%i==0)
        {
            out.println("<span style='color:red;'>" + no + " Is Not Prime Number</span>");

            return;
        }
    }

   out.println("<span style='color:red;'>" + no + " Is Prime Number</span>");

%>


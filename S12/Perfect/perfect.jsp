<%@page language="java" %>
<%@include file="index.html" %>
<%

	int no = Integer.parseInt(request.getParameter("no"));
	int sum=0;
	
	for(int i=1;i<=no/2;i++)
	{
		if(no%i==0)
		{
			sum+=i;
		}
	}
	
	
	if(sum==no)
		out.print("The Number Is Perfect");
	else
		out.print("Number Is Not Perfect");
		

%>

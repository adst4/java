<%@page language="java" %>

<%

	int no = Integer.parseInt(request.getParameter("no"));
	int no1 = no;
	String ans="";
	
	while(no>0)
	{
		int rem = no%10;
		
		switch(rem)
		{
			case 1:
				ans = "One" +" " +ans;
				break;
				
			case 2:
				ans = "Two" +" " +ans;
				break;
				
			case 3:
				ans = "Three" +" " +ans;
				break;
				
			case 4:
				ans = "Four" +" " +ans;
				break;
				
			case 5:
				ans = "Five" +" " +ans;
				break;
				
			case 6:
				ans = "Six" +" " +ans;
				break;
				
			case 7:
				ans = "Seven" +" " +ans;
				break;
				
			case 8:
				ans = "Eight" +" " +ans;
				break;
				
			case 9:
				ans = "Nine" +" " +ans;
				break;
				
			case 0:
				ans = "Zero" +" " +ans;
				break;
		}
		
		no=no/10;
	}
	
	out.println(no1 +"\t=\t" +ans);

%>

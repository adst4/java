import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PageAccess extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException
	{
		Cookie ca[] = request.getCookies();
		
		PrintWriter out = response.getWriter();
		if(ca!=null)
		{			
			for(Cookie tc : ca)
			{
				if(tc.getName().equals("cnt"));
				{
					int temp = Integer.parseInt(tc.getValue());
					out.println("Page Access Count : " +temp);
					temp=temp+1;
					tc.setValue(""+temp);
					response.addCookie(tc);
				}
			}
		}
		else
		{	
			int cnt = 0;
			Cookie c = new Cookie("cnt",""+cnt);
			response.addCookie(c);
			out.print("Welcome Java");
		}
	}
}

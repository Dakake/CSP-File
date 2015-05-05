package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.*;
import javax.jdo.*;

import javax.servlet.http.*;

public class EntryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
		Calendar cal = Calendar.getInstance();
		Cookie[] cookieList = req.getCookies();
		HttpSession session = req.getSession();
		
		Query qry = MyPersistenceManager.getManager().newQuery(UserLoginToken.class);
		List<UserLoginToken> userLogin = (List<UserLoginToken>) qry.execute();
				
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		for(Cookie c : cookieList)
		{
			if(c.getName().equals("token"))
			{
				String asd = c.getValue();
				resp.getWriter().println(asd);
				/*if(userLogin.get(0).getToken().equals(c.getValue()))
				{
					if(c.getMaxAge() > 0)
					{
						String id = userLogin.get(0).getUserAccount();
						Long key = userLogin.get(0).getKey();
						
						String uuid = UUID.randomUUID().toString();
						Cookie cookie = new Cookie("token", uuid);
						cookie.setMaxAge(60*60*24*30);
						resp.addCookie(cookie);
					
						PersistenceManager pm = MyPersistenceManager.getManager();
						pm.deletePersistent(key);
						UserLoginToken loginToken = new UserLoginToken(uuid, id,String.valueOf(DateString(cal)));
						pm.makePersistent(loginToken);
						
						if(session.isNew())
							session.setMaxInactiveInterval(60*10);
						session.setAttribute("userID", id);
						
						resp.sendRedirect("/index.html");
					}
				}*/
			}
			else
			{
				resp.sendRedirect("/Login.html");
			}
		}
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

	public static String DateString(Calendar c)
	{
		return String.valueOf(c.get(Calendar.YEAR) + "-" + 
				(c.get(Calendar.MONTH) + 1) + "-"+ c.get(Calendar.DATE));
	}
}

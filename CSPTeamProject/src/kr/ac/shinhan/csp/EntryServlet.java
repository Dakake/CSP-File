package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;

public class EntryServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String id = null;
		int i = 0;
		Cookie[] cookieList = req.getCookies();
		HttpSession session = req.getSession();
		
		Query qry = MyPersistenceManager.getManager().newQuery(UserLoginToken.class);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		if(cookieList != null)
		{
		for(Cookie cookie : cookieList)
		{
			if(cookie.getName().equals("token"))
			{
				String uuid = UUID.randomUUID().toString();
				List<UserLoginToken> userLogin = (List<UserLoginToken>) qry.execute(cookie.getValue());
				for(UserLoginToken ult : userLogin)
				{

					id = ult.getUserAccount();
					ult.setToken(uuid);
				}
				cookie.setValue(uuid);
				resp.addCookie(cookie);
				
					if(session.isNew())
						session.setMaxInactiveInterval(60*10);
					session.setAttribute("userID", id);
						
					resp.sendRedirect("/index.html");
					i = 1;
			}
		}
		}
			if(i == 0)
			{
				resp.sendRedirect("/Login.html");
			}
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}

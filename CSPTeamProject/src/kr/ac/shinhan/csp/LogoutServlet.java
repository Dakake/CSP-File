package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		int i = 0;
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query qry = pm.newQuery(UserLoginToken.class);
		HttpSession session = req.getSession();
		Cookie[] cookieList = req.getCookies();
		session.invalidate();
		
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
				List<UserLoginToken> userLogin = (List<UserLoginToken>) qry.execute(cookie.getValue());
				for(UserLoginToken ult : userLogin)
				{
					pm.deletePersistent(ult);
				}
					cookie.setValue(null);
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					resp.sendRedirect("/Login.html");
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

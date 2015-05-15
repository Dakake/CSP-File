package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		boolean remember = req.getParameter("remember") != null;	
		boolean success = false;
		
		Query qry = MyPersistenceManager.getManager().newQuery(UserAccount.class);
		qry.setFilter("userID == idParam");
		qry.declareParameters("String idParam");
		
		List<UserAccount> userAccount = (List<UserAccount>)qry.execute(id);
		
		if(userAccount.size() == 0)
		{
			success = false;
		}
		else if(userAccount.get(0).getPassword().equals(password))
		{
			success = true;
		}
		else
		{
			success = false;
		}
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		if(!success)
		{
			resp.getWriter().println("로그인에 실패하였습니다.\n");
			resp.getWriter().println("<a href='Login.html'>여기</a> 를 눌러 다시 시도하세요.");
		}
		if(success)
		{
			HttpSession session = req.getSession();
			if(session.isNew())
				session.setMaxInactiveInterval(60*10);
			session.setAttribute("userID", id);
			if(remember == true)
			{
				String uuid = UUID.randomUUID().toString();
			
				Calendar now = Calendar.getInstance();
				now.add(Calendar.DATE,30);
				String exprieDate = now.getTime().toString();
				
				PersistenceManager pm = MyPersistenceManager.getManager();
				UserLoginToken loginToken = new UserLoginToken(uuid, id,exprieDate);
				pm.makePersistent(loginToken);
				
				Cookie cookie = new Cookie("token", uuid);
				cookie.setMaxAge(60*60*24*30);
				resp.addCookie(cookie);	
			}
			resp.sendRedirect("/index.html");
		}
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}

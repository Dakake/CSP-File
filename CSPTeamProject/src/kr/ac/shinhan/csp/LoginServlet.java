package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.Query;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		boolean success = false;
		
		MyPersistenceManager.getManager();
		
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
			
			resp.sendRedirect("/index.html");
		}
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}

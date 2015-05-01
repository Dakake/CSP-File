package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;
import javax.jdo.Query;
import javax.servlet.http.*;

public class SignUpServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		boolean idCheck = false;
		
		Query qry = MyPersistenceManager.getManager().newQuery(UserAccount.class);
		List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);
		
		for(UserAccount u : userAccount)
		{
			if(u.getUserID().equals(id))
			{
				idCheck = true;
			}
		}
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		if(idCheck == true)
		{
			resp.getWriter().println("등록된 아이디가 있습니다.\n");
			resp.getWriter().println("<a href='SignUp.html'> 여기 </a> 를 눌러 다시 시도하세요.");
		}
		if(idCheck == false)
		{
			UserAccount ua = new UserAccount(id,password,name);
			MyPersistenceManager.getManager().makePersistent(ua);
			resp.sendRedirect("Login.html");
		}

	}
}

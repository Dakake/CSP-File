package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DeleteMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
		String key =  req.getParameter("key");
		Long longKey = Long.parseLong(key);
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		Member m = pm.getObjectById(Member.class,longKey); //키에 따른 팀 멤버중 한명을 뎃고오는 메소드가 필요하다
		pm.deletePersistent(m);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		resp.getWriter().println("<h1>" +"삭제가 완료되었습니다!" + "<h2>");
		resp.getWriter().println("<a href=" +"retriveTeamMember" + ">" + "뒤로가기" + "</a>"+"</br>");
		resp.getWriter().println("<a href=" +"index.html" + ">" + "처음으로" + "</a>"+"</br>");
	
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}

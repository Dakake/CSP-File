package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.*;

public class RetriveTeamMemberServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws IOException
		{
			List<Member> memberList = MemberManager.getAllMembers();
			int i = memberList.size();
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");
		
			resp.getWriter().println("<HTML>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<table border = " + i + ">");
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>" + "Name" + "</td><td>" + "stdID" + "</td><td>" + "Tel" + "</td><td>" + "E-mail" 
			+ "</td><td>" + "kakaoID" + "</td><td>" + "Reader" + "</td><td>" + "githubID" + "</td><td>" + "Delete" + "</td>");
			resp.getWriter().println("</tr>");
			
			for(Member m : memberList)
			{
				resp.getWriter().println("<tr>");
				resp.getWriter().println("<td>"+ "<a href =/readTeamMember?key="+m.getKey()+">"+ m.getName()+"</td>");
				resp.getWriter().println("<td>" + m.getStdID()+ "</td>");
				resp.getWriter().println("<td>" + m.getTelephone()+ "</td>");
				resp.getWriter().println("<td>" + m.getEmail()+ "</td>");
				resp.getWriter().println("<td>" + m.getKakaoID()+ "</td>");
				if(m.isCheckInfo() == true)
				resp.getWriter().println("<td>" + "Team Reader" + "</td>");
				else
				resp.getWriter().println("<td>" + "Team Member" + "</td>");
				resp.getWriter().println("<td>" + m.getGithubID()+ "</td>");
				resp.getWriter().println("<td>" + "<a href =/deleteMember?key="+m.getKey()+ ">"+"Delete" + "</td>");
				resp.getWriter().println("</tr>");
			}
			resp.getWriter().println("</table>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
		}

}

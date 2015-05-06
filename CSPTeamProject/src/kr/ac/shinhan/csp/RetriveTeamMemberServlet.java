package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RetriveTeamMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException
		{
			HttpSession session = req.getSession();
			List<Member> memberList = MemberManager.getAllMembers();
			int i = memberList.size();
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			resp.getWriter().println("<HTML>");
			resp.getWriter().println("<body>");
			resp.getWriter().println("<table border = " + i + ">");
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>" + "Name" + "</td><td>" + "stdID" + "</td><td>" + "Tel" + "</td><td>" + "E-mail" 
			+ "</td><td>" + "kakaoID" + "</td><td>" + "Reader" + "</td><td>" + "githubID" + "</td><td>" + "Update" + "</td><td>" + "Delete" + "</td>");
			resp.getWriter().println("</tr>");
			resp.getWriter().println(session.getAttribute("userID") + "´Ô È¯¿µÇÕ´Ï´Ù.");
			for(Member m : memberList)
			{
				resp.getWriter().println("<tr>");
				resp.getWriter().println("<td>" + m.getName()+"</td>");
				resp.getWriter().println("<td>" + m.getStdID()+ "</td>");
				resp.getWriter().println("<td>" + m.getTelephone()+ "</td>");
				resp.getWriter().println("<td>" + m.getEmail()+ "</td>");
				resp.getWriter().println("<td>" + m.getKakaoID()+ "</td>");
				if(m.isCheckInfo() == true){
					resp.getWriter().println("<td>" + "Team Reader" + "</td>");
				}
				else {
				resp.getWriter().println("<td>" + "Team Member" + "</td>");
				}
				resp.getWriter().println("<td>" + m.getGithubID()+ "</td>");
				resp.getWriter().println("<td>" + "<a href =/readTeamMember?id="+m.getId() + "> Update </a> </td>");
				resp.getWriter().println("<td>" + "<a href =/deleteMember?id="+m.getId()+ "> Delete </a> </td>");
				resp.getWriter().println("</tr>");
			}
			resp.getWriter().println("<a href='logout'>·Î±×¾Æ¿ô</a>");
			resp.getWriter().println("</table>");
			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");
		}

}

package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DeleteMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String id =  req.getParameter("id");
		Member m = MemberManager.getMember(id);
	
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		resp.getWriter().println("<h1> 삭제가 완료되었습니다! </h1>");
		resp.getWriter().println("삭제한 내용은 다음과 같습니다. </br>");
		resp.getWriter().println("이름 : " +m.getName() + "</br>" + "학번 : " + m.getStdID() + "</br>" + "전화번호 : " + m.getTelephone() + "</br>"
				+ "이메일 : " + m.getEmail() + "</br>" + "카카오ID : " + m.getKakaoID() + "</br>" + "팀장여부 : " + m.isCheckInfo() + "</br>"
				+ "githubID : " + m.getGithubID() + "</br>");
		
		resp.getWriter().println("<a href= /retriveTeamMember> 뒤로가기 </a> </br>");
		resp.getWriter().println("<a href= /index.html> 처음으로 </a> </br>");
	
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		MemberManager.deleteMember(id);
	}

}

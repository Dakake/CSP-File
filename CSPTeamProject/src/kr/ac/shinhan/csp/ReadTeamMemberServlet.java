package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ReadTeamMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String id =  req.getParameter("id");
		Member m = MemberManager.getMember(id);
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1> Update Member </h1>");
		resp.getWriter().println("<form method='post' action='/updateMember'>");
		resp.getWriter().println("<tr> <input type='hidden' name='id' value=" + m.getId() + "> </tr> </br>");
		resp.getWriter().println("<tr> 이름 : </tr> <tr> <input type='text' name='name' value=" + m.getName() + "> </tr> </br>");
		resp.getWriter().println("<tr> 학번 : </tr> <tr> <input type='text' name='stdID' value=" + m.getStdID() + "> </tr> </br>");
		resp.getWriter().println("<tr> 전화번호 : </tr> <tr> <input type='text' name='telephone' value=" + m.getTelephone() + "> </tr> </br>");
		resp.getWriter().println("<tr> 이메일 : </tr> <tr> <input type='text' name='email' value=" + m.getEmail() + "> </tr> </br>");
		resp.getWriter().println("<tr> 카카오ID : </tr> <tr> <input type='text' name='kakaoID' value=" + m.getKakaoID() + "> </tr> </br>");
		if(m.isCheckInfo() == true) { 
			resp.getWriter().println("<tr> 팀장여부 : </tr> <tr> <input type='checkbox' name='checkInfo' checked='checked'> </tr> </br>"); 
		}
		else {
			resp.getWriter().println("<tr> 팀장여부 : </tr> <tr> <input type='checkbox' name='checkInfo'> </tr> </br>");
		}
		resp.getWriter().println("<tr> GitHub_ID : </tr> <tr> <input type='text' name='githubID' value=" + m.getGithubID() + "> </tr> </br>");
		resp.getWriter().println("<td> <input type='submit' value='정보수정' </td>");
		resp.getWriter().println("</from>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}

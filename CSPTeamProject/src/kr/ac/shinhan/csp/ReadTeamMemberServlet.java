package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

public class ReadTeamMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String key =  req.getParameter("key");
		Long longKey = Long.parseLong(key);
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		Member m = pm.getObjectById(Member.class, longKey);
		
		String name = m.getName();
		String stdID = m.getStdID();
		String telephone = m.getTelephone();
		String email = m.getEmail();
		String kakaoID = m.getKakaoID();
		boolean checkInfo = m.isCheckInfo();
		String githubID = m.getGithubID();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>"+ "팀원 정보 수정" + "<h1>");
		resp.getWriter().println("<form method ="+"'POST'" + "action =/updateMember?key="+ m.getKey() +">");
		resp.getWriter().println("<table border=" + "1"+">");
		
		resp.getWriter().println("<tr>"+"<td>"+"이름"+"</td>"+"<td>"+"<input type ="+"'text'" +"name="+ "'name'" + "value="+name+  ">" + "</td>"+"</tr>");
		resp.getWriter().println("<tr>"+"<td>"+"학번"+"</td>"+"<td>"+"<input type ="+"'text'" +"name="+ "'id'" +  "value="+stdID+ ">" + "</td>"+"</tr>");
		resp.getWriter().println("<tr>"+"<td>"+"전화번호"+"</td>"+"<td>"+"<input type ="+"'text'" +"name="+ "'num'" + "value="+telephone+  ">" + "</td>"+"</tr>");
		resp.getWriter().println("<tr>"+"<td>"+"메일주소"+"</td>"+"<td>"+"<input type ="+"'text'" +"name="+ "'email'" + "value="+email+  ">" + "</td>"+"</tr>");
		resp.getWriter().println("<tr>"+"<td>"+"카카오톡 아이디"+"</td>"+"<td>"+"<input type ="+"'text'" +"name="+ "'kakaoid'" + "value="+kakaoID+  ">" + "</td>"+"</tr>");
		resp.getWriter().println("<tr>"+"<td>"+"팀장여부"+"</td>"+"<td>"+"<input type ="+"'checkbox'" +"name="+ "'checkInfo'" + "value="+"'true'" + ">" + "</td>"+"</tr>");
		resp.getWriter().println("<tr>"+"<td>"+"GitHub Id"+"</td>"+"<td>"+"<input type ="+"'text'" +"name="+ "'gitid'" + "value="+githubID+  ">" + "</td>"+"</tr>");
	
		resp.getWriter().println("</table>");
		resp.getWriter().println("<input type="+"'submit'" + "value="+"'update'"+  ">");
		resp.getWriter().println("</form>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}

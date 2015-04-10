package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

public class UpdateMemberServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
		String key =  req.getParameter("key");
		Long longKey = Long.parseLong(key);
		
		String name = req.getParameter("name");
		String stdID = req.getParameter("stdID");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		String kakaoID = req.getParameter("kakaoID");
		String githubID = req.getParameter("githubID");		
		boolean checkInfo = req.getParameter("checkInfo") != null;
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		Member m =  pm.getObjectById(Member.class,longKey);
		
		m.setName(name);
		m.setStdID(stdID);
		m.setTelephone(telephone);
		m.setEmail(email);
		m.setKakaoID(kakaoID);
		m.setGithubID(githubID);
		m.setCheckInfo(checkInfo);
		
		pm.close();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "다음과 같이 해당 팀원의 정보가 수정되었습니다" + "</h1>");
		resp.getWriter().println("<table border=1>");
		resp.getWriter().println("<tr>"+ "<td>" +"이름  " +"</td>" +"<td>" + name + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"학번  " +"</td>" +"<td>" + stdID + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"전화번호 : " +"</td>" +"<td>" + telephone + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"메일주소 : " +"</td>" +"<td>" + email + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"카카오톡 아이디 : " +"</td>" +"<td>" + kakaoID + "</td>" + "</tr>");
		if(checkInfo != true)
			resp.getWriter().println("<tr>"+ "<td>" +"팀장여부" +"</td>" +"<td>" + "Team Member" + "</td>" + "</tr>");
		else
			resp.getWriter().println("<tr>"+ "<td>" +"팀장여부" +"</td>" +"<td>" + "Team Reader" + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"GitHub ID" +"</td>" +"<td>" + githubID + "</td>" + "</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<a href=" +"retriveTeamMember" + ">" + "뒤로가기" + "</a>"+"</br>");
		resp.getWriter().println("<a href=" +"index.html" + ">" + "처음으로" + "</a>"+"</br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}

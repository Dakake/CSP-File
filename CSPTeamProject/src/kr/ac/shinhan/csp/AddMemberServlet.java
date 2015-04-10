package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.*;

public class AddMemberServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name = req.getParameter("name");
		String stdID = req.getParameter("stdID");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		String kakaoID = req.getParameter("kakaoID");
		String githubID = req.getParameter("githubID");
		boolean check = req.getParameter("checkInfo") != null;
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
	
		Member m = MemberManager.addMember(name,stdID, telephone, email, kakaoID, check, githubID);
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "팀원 등록이 완료되었습니다." + "</h1>");
		resp.getWriter().println("<table border=1>");
		resp.getWriter().println("<tr>"+ "<td>" +"이름  " +"</td>" +"<td>" + name + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"학번  " +"</td>" +"<td>" + stdID + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"전화번호 : " +"</td>" +"<td>" + telephone + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"메일주소 : " +"</td>" +"<td>" + email + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"카카오톡 아이디 : " +"</td>" +"<td>" + kakaoID + "</td>" + "</tr>");
		if(check != true)
			resp.getWriter().println("<tr>"+ "<td>" +"팀장여부" +"</td>" +"<td>" + "Team Member" + "</td>" + "</tr>");
		else
			resp.getWriter().println("<tr>"+ "<td>" +"팀장여부" +"</td>" +"<td>" + "Team Reader" + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"GitHub ID" +"</td>" +"<td>" + githubID + "</td>" + "</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}

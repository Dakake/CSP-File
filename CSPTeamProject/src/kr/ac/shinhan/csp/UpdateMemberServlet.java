package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class UpdateMemberServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String id =  req.getParameter("id");
		Member m = MemberManager.getMember(id);
		PersistenceManager pm = MyPersistenceManager.getManager();
		
		String name = req.getParameter("name");
		String stdID = req.getParameter("stdID");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		String kakaoID = req.getParameter("kakaoID");
		boolean checkInfo = req.getParameter("checkInfo") != null;
		String githubID = req.getParameter("githubID");		

		m.setName(name);
		m.setStdID(stdID);
		m.setTelephone(telephone);
		m.setEmail(email);
		m.setKakaoID(kakaoID);
		m.setCheckInfo(checkInfo);
		m.setGithubID(githubID);
		pm.close();
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "������ ���� �ش� ������ ������ �����Ǿ����ϴ�" + "</h1>");
		resp.getWriter().println("<table border=1>");
		resp.getWriter().println("<tr>"+ "<td>" +"�̸�  " +"</td>" +"<td>" + name + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"�й�  " +"</td>" +"<td>" + stdID + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"��ȭ��ȣ : " +"</td>" +"<td>" + telephone + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"�����ּ� : " +"</td>" +"<td>" + email + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"īī���� ���̵� : " +"</td>" +"<td>" + kakaoID + "</td>" + "</tr>");
		if(checkInfo != true) {
			resp.getWriter().println("<tr>"+ "<td>" +"���忩��" +"</td>" +"<td>" + "Team Member" + "</td>" + "</tr>");
		}
		else {
			resp.getWriter().println("<tr>"+ "<td>" +"���忩��" +"</td>" +"<td>" + "Team Reader" + "</td>" + "</tr>");
		}
		resp.getWriter().println("<tr>"+ "<td>" +"GitHub ID" +"</td>" +"<td>" + githubID + "</td>" + "</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<a href=" +"retriveTeamMember" + ">" + "�ڷΰ���" + "</a>"+"</br>");
		resp.getWriter().println("<a href=" +"index.html" + ">" + "ó������" + "</a>"+"</br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}

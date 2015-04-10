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
		resp.getWriter().println("<h1>" + "������ ���� �ش� ������ ������ �����Ǿ����ϴ�" + "</h1>");
		resp.getWriter().println("<table border=1>");
		resp.getWriter().println("<tr>"+ "<td>" +"�̸�  " +"</td>" +"<td>" + name + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"�й�  " +"</td>" +"<td>" + stdID + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"��ȭ��ȣ : " +"</td>" +"<td>" + telephone + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"�����ּ� : " +"</td>" +"<td>" + email + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"īī���� ���̵� : " +"</td>" +"<td>" + kakaoID + "</td>" + "</tr>");
		if(checkInfo != true)
			resp.getWriter().println("<tr>"+ "<td>" +"���忩��" +"</td>" +"<td>" + "Team Member" + "</td>" + "</tr>");
		else
			resp.getWriter().println("<tr>"+ "<td>" +"���忩��" +"</td>" +"<td>" + "Team Reader" + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"GitHub ID" +"</td>" +"<td>" + githubID + "</td>" + "</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<a href=" +"retriveTeamMember" + ">" + "�ڷΰ���" + "</a>"+"</br>");
		resp.getWriter().println("<a href=" +"index.html" + ">" + "ó������" + "</a>"+"</br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}

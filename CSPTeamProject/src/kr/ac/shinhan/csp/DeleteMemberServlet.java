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
		
		resp.getWriter().println("<h1> ������ �Ϸ�Ǿ����ϴ�! </h1>");
		resp.getWriter().println("������ ������ ������ �����ϴ�. </br>");
		resp.getWriter().println("�̸� : " +m.getName() + "</br>" + "�й� : " + m.getStdID() + "</br>" + "��ȭ��ȣ : " + m.getTelephone() + "</br>"
				+ "�̸��� : " + m.getEmail() + "</br>" + "īī��ID : " + m.getKakaoID() + "</br>" + "���忩�� : " + m.isCheckInfo() + "</br>"
				+ "githubID : " + m.getGithubID() + "</br>");
		
		resp.getWriter().println("<a href= /retriveTeamMember> �ڷΰ��� </a> </br>");
		resp.getWriter().println("<a href= /index.html> ó������ </a> </br>");
	
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		MemberManager.deleteMember(id);
	}

}

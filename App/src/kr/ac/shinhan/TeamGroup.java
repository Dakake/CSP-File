package kr.ac.shinhan;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TeamGroup extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("���� �̹� ������Ʈ�� �����ϴ� �ο���  �����, �ڰ浵, �̽±�  �̻� 3���� �ǰڽ��ϴ�.");
	}
}
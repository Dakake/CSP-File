package kr.ac.shinhan;

import java.io.IOException;

import javax.servlet.http.*;


@SuppressWarnings("serial")
public class TeamProject extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("���� �̹� ������Ʈ�� �Ƶ��̳븦 �̿��� LED ����Դϴ�. ");
		resp.getWriter().println("�ڵ����� �Է��� ������ ������ ���������ؼ� LED���ǿ� ����ϱ⶧���� ");
		resp.getWriter().println("�̹� Ŭ���̾�Ʈ/���� ���� ������Ʈ���� �����ϴٰ� �����մϴ�. ");
	}
}
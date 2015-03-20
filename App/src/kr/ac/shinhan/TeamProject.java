package kr.ac.shinhan;

import java.io.IOException;

import javax.servlet.http.*;


@SuppressWarnings("serial")
public class TeamProject extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("저희 이번 프로젝트는 아두이노를 이용한 LED 출력입니다. ");
		resp.getWriter().println("핸드폰에 입력한 내용을 구성한 서버를통해서 LED기판에 출력하기때문에 ");
		resp.getWriter().println("이번 클라이언트/서버 강의 프로젝트에도 적합하다고 생각합니다. ");
	}
}
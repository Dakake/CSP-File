package kr.ac.shinhan;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CurrentTime extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("현재시간 " + new Date());

		
	}
}
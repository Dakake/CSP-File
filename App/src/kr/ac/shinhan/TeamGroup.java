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
		
		resp.getWriter().println("저희 이번 프로젝트에 참여하는 인원은  고용진, 박경도, 이승규  이상 3명이 되겠습니다.");
	}
}
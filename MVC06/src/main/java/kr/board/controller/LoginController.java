package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardMyBatisDAO;
import kr.board.entity.Member;

public class LoginController implements Controller{

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		Member m = new Member();
		BoardMyBatisDAO dao = new BoardMyBatisDAO();
		
		m.setMemId(memId);
		m.setMemPwd(memPwd);
		
		Member mvo = dao.memberLogin(m);
		
		return null;
	}

}

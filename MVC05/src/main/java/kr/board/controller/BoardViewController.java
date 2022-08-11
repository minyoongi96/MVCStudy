package kr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardMyBatisDAO;
import kr.board.entity.Board;


public class BoardViewController implements Controller {

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardMyBatisDAO dao = new BoardMyBatisDAO();
		Board vo = dao.boardView(num);

		dao.countUpdate(num);
		request.setAttribute("vo", vo);
		
		return "boardView";
	}
	
}
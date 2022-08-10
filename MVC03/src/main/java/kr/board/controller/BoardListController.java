package kr.board.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.entity.Board;

// Servlet -> POJO(프론트컨트롤러가 해야할 일을 대신해주는 클래스)
// POJO도 컨트롤러의 역할을 해야하므로 일반 클래스이지만 request, response가 존재해야함
public class BoardListController implements Controller {
	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.boardAllList();
		request.setAttribute("list", list);
		return "boardList";
	}
}

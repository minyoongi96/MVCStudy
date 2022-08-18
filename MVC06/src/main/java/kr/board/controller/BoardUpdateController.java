package kr.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardMyBatisDAO;
import kr.board.entity.Board;

public class BoardUpdateController implements Controller {

	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Board vo = new Board();
		BoardMyBatisDAO dao = new BoardMyBatisDAO();

		vo.setNum(num);
		vo.setTitle(title);
		vo.setContent(content);
		dao.boardUpdate(vo);

		return null;
	}

}

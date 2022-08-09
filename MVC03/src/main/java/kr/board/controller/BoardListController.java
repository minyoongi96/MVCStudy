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


public class BoardListController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.boardAllList();
		
		// View(jsp)와 연동하기
		request.setAttribute("list", list);	// 객체(request) 바인딩
		
		// jsp(View)로 갈때는 forward로
		RequestDispatcher rd = request.getRequestDispatcher("board/boardList.jsp");
		rd.forward(request, response);
		
	}

}

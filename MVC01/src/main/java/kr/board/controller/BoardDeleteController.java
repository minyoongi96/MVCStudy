package kr.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;

@WebServlet("/boardDelete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request에서 파라미터 수집
		int num = Integer.parseInt(request.getParameter("num"));
		
		// Model과 연동
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardDelete(num);
		
		if (cnt > 0) {
			response.sendRedirect("/MVC01/boardList.do");
		} else {
			throw new ServletException("Delete Error");
		}
	}

}

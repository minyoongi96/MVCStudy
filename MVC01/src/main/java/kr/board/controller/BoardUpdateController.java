package kr.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.entity.Board;

@WebServlet("/boardUpdate.do")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		BoardDAO dao = new BoardDAO();
		Board vo = new Board();
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		vo.setNum(num);
		vo.setTitle(title);
		vo.setContent(content);
		
		int cnt = dao.boardUpdate(vo);
		if(cnt > 0) {
			response.sendRedirect("/MVC01/boardList.do");
		} else {
			throw new ServletException("not update");
		}
	}

}

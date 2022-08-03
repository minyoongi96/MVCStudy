package kr.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.entity.Board;

@WebServlet("/boardWrite.do")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청데이터의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		
		// title, content, writer 파라미터 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		// 파라미터 수집
		Board vo = new Board();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		// Model과 연동(insert)
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardWrite(vo);
		
		// 성공 후에는 다시 리스트페이지로 경로 변경
		if(cnt > 0) {
			response.sendRedirect("/MVC01/boardList.do");	// url을 다른곳으로 이동시키기
		} else {	// 예외 발생시키기
			throw new ServletException("Insert Error");
		}
	}

}

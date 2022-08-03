package kr.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.board.dao.*;
import kr.board.entity.*;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/boardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Model과 연동하기
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.selectAll();
		
		// 리스트 페이지를 만들어서 응답하기 (View 하기 전이므로 Servlet에서 View 만들기, 노가다)
		
		// 서버가 응답할 데이터의 유형(text/html -> MIME Type)을 미리 클라이언트에게 미리 알려주기
		response.setContentType("text/html;charset=euc-kr");	// 응답 시 한글깨짐 방지, PrintWriter 객체 만들기 전에 해줘야 함
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td>번호</td>");
		out.println("<td>제목</td>");
		out.println("<td>작성자</td>");
		out.println("<td>작성일</td>");
		out.println("<td>조회수</td>");
		out.println("</tr>");
		
		for (Board vo : list) {
			out.println("<tr>");
			out.println("<td>" + vo.getNum() + "</td>");
			out.println("<td><a href='boardView.do?num=" + vo.getNum() + "'>" + vo.getTitle() + "</a></td>");
			out.println("<td>" + vo.getWriter() + "</td>");
			out.println("<td>" + vo.getIndate() + "</td>");
			out.println("<td>" + vo.getCount() + "</td>");
			// 해당 게시물을 삭제하는 서블릿으로 이동(해당 게시물의 num까지)
			// 이렇게 a태그로 넘기는 방식이 GET방식
			// (?파라미터=값) : QueryString
			out.println("<td><a href='/MVC01/boardDelete.do?num=" + vo.getNum() + "'>삭제</a></td>");		
			out.println("</tr>");
		}
		
		out.println("<tr>");
		out.println("<td colspan='6'>");
		out.println("<a href='/MVC01/boardWrite.html'>글쓰기</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}

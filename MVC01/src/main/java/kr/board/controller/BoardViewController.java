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

@WebServlet("/boardView.do")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardViewController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 수집
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = new BoardDAO();
		Board vo = dao.boardView(num);
		
		if (vo != null) {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<table width='500px' border='1'>");
			out.println("<tr>");
			out.println("<td>제목</td>");
			out.println("<td>" + vo.getTitle() + "</td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("<td>작성자</td>");
			out.println("<td>" + vo.getWriter() + "</td>");
			out.println("</tr>");
			out.println("<tr>");

			out.println("<tr>");
			out.println("<td>작성일</td>");
			out.println("<td>" + vo.getIndate().split(" ")[0] + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			
			out.println("<tr>");
			out.println("<td>조회수</td>");
			out.println("<td>" + vo.getCount() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			
			out.println("<tr>");
			out.println("<td>내용</td>");
			out.println("<td><textarea cols='50' rows='10'>" + vo.getContent()+ "</textarea></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td colspan='2' align='center'>");
			out.println("<a href='/MVC01/boardUpdateForm.do?num=" + vo.getNum() +"'>수정</a>");
			out.println("<a href='/MVC01/boardDelete.do?num=" + vo.getNum() + "'>삭제</a>");
			out.println("<a href='/MVC01/boardList.do'>목록</a>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
		} else {
			throw new ServletException("not search");
		}
	}

}

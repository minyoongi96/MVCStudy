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

@WebServlet("/boardUpdateForm.do")
public class BoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardUpdateFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dao = new BoardDAO();
		Board vo = dao.boardView(num);
		
		
		// 수정 페이지 만들기
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='/MVC01/boardUpdate.do' method='post'>");
		out.println("<input type='hidden' name='num' value='"+ vo.getNum() +"'>");
		out.println("<table width='500px' border='1'>");
		out.println("<tr>");
		out.println("<td>제목</td>");
		out.println("<td><input type='text' name='title' value='" + vo.getTitle() + "'/></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>내용</td>");
		out.println("<td><textarea name='content' cols='50' rows='10'>" + vo.getTitle() + "</textarea></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<input type='submit' value='수정'/>");
		out.println("<input type='reset' value='취소'/>");
		out.println("<button><a href='/MVC01/boardList.do'>목록</a></button>");
		out.println("</tr>");
		out.println("</td>");
		out.println("</form>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}

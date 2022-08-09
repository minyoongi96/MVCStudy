package kr.board.frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import kr.board.dao.BoardDAO;
import kr.board.entity.Board;

@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// FrontController - 1개(스프링에서는 DispatcherServlet)
		
		// 1. 어떤 요청인지 파악하기(command 구하기)
		String reqPath = request.getRequestURI();
		String cpath = request.getContextPath();
		String command = reqPath.substring(cpath.length());
		String nextPage = null;
		

		request.setCharacterEncoding("utf-8");

		// 2. command에 따른 분기작업(Handler Mapping)
		BoardDAO dao = new BoardDAO();

		if (command.equals("/boardList.do")) {

			List<Board> list = dao.boardAllList();
			request.setAttribute("list", list);
			nextPage = "WEB-INF/board/boardList.jsp";

		} else if (command.equals("/boardWriteForm.do")) {
			nextPage = "WEB-INF/board/boardWrite.jsp";

		} else if (command.equals("/boardWrite.do")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");

			Board vo = new Board();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			dao.boardWrite(vo);

			nextPage = "redirect:/boardList.do";

		} else if (command.equals("/boardView.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			Board vo = dao.boardView(num);

			dao.countUpdate(num);
			request.setAttribute("vo", vo);
			nextPage = "WEB-INF/board/boardView.jsp";

		} else if (command.equals("/boardDelete.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			dao.boardDelete(num);
			nextPage = "redirect:/boardList.do";

		} else if (command.equals("/boardUpdateForm.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			Board vo = dao.boardView(num);
			request.setAttribute("vo", vo);

			nextPage = "WEB-INF/board/boardUpdate.jsp";

		} else if (command.equals("/boardUpdate.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			Board vo = new Board();
			vo.setNum(num);
			vo.setTitle(title);
			vo.setContent(content);

			dao.boardUpdate(vo);
			nextPage = "redirect:/boardList.do";
		}

		// 3. View(forward) or 다른 컨트롤러(redirect)로 경로를 변경하는 작업
		if (nextPage != null) {
			if (nextPage.indexOf("redirect:") == -1) {
				// forward
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
			} else {
				// redirect
				response.sendRedirect(cpath + nextPage.split(":")[1]);
			}
			
			
		}
	}
}

package kr.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardWriteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardWriteFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글쓰기 Form
		RequestDispatcher rd = request.getRequestDispatcher("board/boardWrite.jsp");
		rd.forward(request, response);
	}

}
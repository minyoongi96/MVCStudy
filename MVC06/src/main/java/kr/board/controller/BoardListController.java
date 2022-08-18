package kr.board.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.board.dao.BoardMyBatisDAO;
import kr.board.entity.Board;

// Servlet -> POJO(프론트컨트롤러가 해야할 일을 대신해주는 클래스)
// POJO도 컨트롤러의 역할을 해야하므로 일반 클래스이지만 request, response가 존재해야함
public class BoardListController implements Controller {
	@Override
	public String requestProcessor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardMyBatisDAO dao = new BoardMyBatisDAO(); 
		List<Board> list = dao.allList();
		
		// JSON형태로 만들어서 데이터 응답해주기
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		// Data만 콜백 함수로 전달해주기
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(json);
		
		return null;
	}
}

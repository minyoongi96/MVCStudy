/*
 * Servlet : Server + Applet의 약자, 웹에서 실행되는 프로그램을 작성하는 기술을 뜻함
 * 1. 웹에서 실행 가능한 클래스로 만들기
 * 2. 웹(JavaEE)용 API 불러오기 (servlet-api.jar)
 * 3. service(요청, 응답) -> 웹의 main method 역할
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hs.do")	// web.xml말고 다른 mapping 방법
public class HelloServlet extends HttpServlet{
	@Override
	// throw되는 예외를 Tomcat이 처리해서 보여줌
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		PrintWriter out =  res.getWriter();		// 출력을 위한 생성
		
		out.println("Hello Servlet");		// 출력
		
	}
}

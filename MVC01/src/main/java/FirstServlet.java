import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.util.*;

@WebServlet("/fs.do")
public class FirstServlet extends HttpServlet {
	//get, post방식 모두 처리하려면 service 메소드 작성
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtil my = new MyUtil();
		
		// 클라이언트 폼에서 넘어논 파라미터를 작업
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int sum = my.hapN(num1, num2);

		// 요청한 클라이언트에게 응답
		// PrintWrite 객체를 생성해서 client에 정보 전달
		PrintWriter out = response.getWriter();
		out.println(sum);
	}
}

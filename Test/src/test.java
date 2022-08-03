import kr.board.dao.BoardDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.board.entity.*;
public class test {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.selectAll();
		
		for(Board vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 게시물 번호 입력 : ");
		int num = sc.nextInt();
		int result = dao.boardDelete(num);
		
		list = dao.selectAll();
		
		for(Board vo : list) {
			System.out.println(vo);
		}
	}
}

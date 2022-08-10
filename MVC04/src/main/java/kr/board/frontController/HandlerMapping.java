package kr.board.frontController;

import java.util.HashMap;
import kr.board.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings = new HashMap<String, Controller>();
	
	public HandlerMapping() {
		mappings.put("/boardList.do", new BoardListController());
		mappings.put("/boardWriteForm.do", new BoardWriteFormController());
		mappings.put("/boardWrite.do", new BoardWriteController());
		mappings.put("/boardView.do", new BoardViewController());
		mappings.put("/boardDelete.do", new BoardDeleteController());
		mappings.put("/boardUpdateForm.do", new BoardUpdateFormController());
		mappings.put("/boardUpdate.do", new BoardUpdateController());
	}
	
	public Controller getController(String command) {
		return mappings.get(command);
	}
}

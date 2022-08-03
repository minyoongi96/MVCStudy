package kr.board.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import kr.board.entity.Board;


public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public BoardDAO() {
		
	}
	
	// _getConnect_
	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "scott";
		String password = "tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}	// _getConnect_
	
	// _dbClose_
	public void dbClose() {
		try {
			if (conn != null) conn.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	// _dbClose_
	
	// _selectAll_ 
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from BOARD order by indate desc";
		conn = getConnect();
		
		try {
			// 쿼리문 실행
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 컬럼 값들 가져와서 Board 객체로 묶어 리스트에 추가
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String indate = rs.getString("indate");
				int count = rs.getInt("count");
				
				Board vo =new Board(num, title, content, writer, indate, count);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}	// _selectAll_
	
	// _boardWrite_
	public int boardWrite(Board vo) {
		String sql = "Insert into BOARD(num, title, content, writer) values(board_num.nextval, ?, ?, ?)";
		conn = getConnect();
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setString(3, vo.getWriter());
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}	// _boardWrite_
	
	// _boardDelete_
	public int boardDelete(int num) {
		String sql = "delete from BOARD where num = ?";
		conn = getConnect();
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}	// _boardDelete_
	
	public int boardUpdate(Board vo) {
		String sql = "update BOARD set title = ?, content = ? where num = ?";
		conn = getConnect();
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getNum());
			
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}
	
	// _boardView_
	public Board boardView(int num) {
		String sql = "select * from BOARD where num = ?";
		conn = getConnect();
		Board vo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String indate = rs.getString("indate");
				int count = rs.getInt("count");
				
				vo = new Board(num, title, content, writer, indate, count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return vo;
	}	// _boardView_
}

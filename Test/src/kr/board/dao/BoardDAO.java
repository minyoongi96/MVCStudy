package kr.board.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kr.board.entity.Board;


public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BoardDAO() {
		super();
	}
	
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
	}
	
	public void dbClose() {
		try {
			if (conn != null) conn.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<Board>();
		conn = getConnect();
		String sql = "select * from BOARD order by indate desc";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String indate = rs.getString("indate");
				int count = rs.getInt("count");
				
				Board vo = new Board(num, title, content, writer, indate, count);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}
	
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
	}
	
}

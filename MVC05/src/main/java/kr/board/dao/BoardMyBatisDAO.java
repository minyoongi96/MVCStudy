package kr.board.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.board.entity.Board;

// MyBatis FrameWork : Java와 SQL을 분리, SQL Mapping 수행
// = SQK Mapping Framework for JAVA
// 쿼리를 XML파일로 추출
public class BoardMyBatisDAO {
	
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블럭 (프로그램 실행 시 딱 한번만 실행)
	static {
		String resource = "kr/board/dao/mybatis-config.xml";
		try {
			// getResourceAsStream : resource(config파일)와 연결되는 데이터 통로를 가져와 InputStream 형태로 저장
			// inputstream(config파일과 연결된 데이터통로)을 가지고
			InputStream inputStream = Resources.getResourceAsStream(resource);	
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 전체 리스트 가져오는 메서드
	public List<Board> allList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Board> list =  session.selectList("allList");
		session.close();
		
		return list;
	}
	
	public int boardWrite(Board vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("boardWrite", vo);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	public int boardDelete(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("boardDelete", num);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	public Board boardView(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		Board vo = session.selectOne("boardView", num);
		
		return vo;
	}
	
	public int boardUpdate(Board vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("boardUpdate", vo);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	public void countUpdate(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("countUpdate", num);
		session.commit();
		session.close();
	}
}

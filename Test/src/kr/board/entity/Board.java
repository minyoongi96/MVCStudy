package kr.board.entity;

public class Board {
	private int num;
	private String title;
	private String content;
	private String writer;
	private String indate;
	private int count;
	
	public Board() {
		super();
	}
	public Board(int num, String title, String content, String writer, String indate, int count) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.indate = indate;
		this.count = count;
	}
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public String getIndate() {
		return indate;
	}
	public int getCount() {
		return count;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", indate="
				+ indate + ", count=" + count + "]";
	}
	
	
}

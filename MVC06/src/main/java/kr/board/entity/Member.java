package kr.board.entity;

public class Member {
	private String memId;
	private String memName;
	private String memPwd;
	
	public Member() {
		
	}

	public String getMemId() {
		return memId;
	}

	public String getMemName() {
		return memName;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	
}

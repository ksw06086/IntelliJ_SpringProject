package spring.mvc.mybatis.ch05.dto;

import java.sql.Date;
import java.util.List;

// 작성자 정보 - 작성자 ID, 이름, 등록일 | 게시글 정보(제목, 내용)
public class User5 {

	// 멤버변수
	// memberT
	private int userId;  // user_id
	private String userName; // user_name
	private Date regDate; // reg_date

	//기본 생성자
	public User5() {}
	
	// 매개변수 생성자
	public User5(int userId, String userName, Date regDate) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}

	// setter/getter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s", userId, userName, regDate);
	}
	
	
}

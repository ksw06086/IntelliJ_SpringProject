package spring.mvc.mybatis.ch03.dto;

import java.sql.Date;
import java.util.List;

// 작성자 정보 - 작성자 ID, 이름, 등록일 | 게시글 정보(제목, 내용)
public class User3 {

	// 멤버변수
	// memberT
	private int userId;  // user_id
	private String userName; // user_name
	private Date regDate; // reg_date
	private List<Post3> posts; // 게시글 테이블 내포, user 1명이 게시글을 여러건 작성할 수 있따.(1:다)

	//기본 생성자
	public User3() {}
	
	// 매개변수 생성자
	public User3(int userId, String userName, Date regDate) {
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

	public List<Post3> getPosts() {
		return posts;
	}

	public void setPosts(List<Post3> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s", userId, userName, regDate);
	}
	
	
}

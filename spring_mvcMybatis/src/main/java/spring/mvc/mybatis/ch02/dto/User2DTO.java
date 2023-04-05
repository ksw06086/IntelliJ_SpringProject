package spring.mvc.mybatis.ch02.dto;

import java.sql.Date;
import java.util.List;

public class User2DTO {

	// 멤버변수
	// memberT
	private int userId;  // user_id
	private String userName; // user_name
	private Date regDate; // reg_date
	// PostsT
	private List<PostsDTO> posts; // 게시글 내포, user1명이 게시글 여러건 작성할 수 있다.(1:다)
	
	//기본 생성자
	public User2DTO() {}
	
	// 매개변수 생성자
	public User2DTO(int userId, String userName, Date regDate, List<PostsDTO> posts) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
		this.posts = posts;
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

	public List<PostsDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostsDTO> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s", userId, userName, regDate, posts);
	}
	
	
}

package spring.mvc.mybatis.ch03.dto;

// 검색 - 작성자 | 게시글타이틀. 내용
public class Search3 {

	private String userName; // 작성자
	private Post3 post; // 게시글 타이틀 내용
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Post3 getPost() {
		return post;
	}
	public void setPost(Post3 post) {
		this.post = post;
	}
	
	
}

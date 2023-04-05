package spring.mvc.mybatis.ch04.dto;

// 게시글
public class Post4 {

	private String title; // post_title
	private String content; // post_content
	
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", title, content);
	}
	
	
}

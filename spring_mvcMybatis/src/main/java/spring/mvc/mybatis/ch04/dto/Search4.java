package spring.mvc.mybatis.ch04.dto;

import java.util.List;

// 검색 - 작성자 | 게시글타이틀. 내용
public class Search4 {

	private int[] userIds; // 복수개 모두 서치
	private List<String> userNames; // 복수개 모두 서치
	
	
	public int[] getUserIds() {
		return userIds;
	}
	public void setUserIds(int[] userIds) {
		this.userIds = userIds;
	}
	public List<String> getUserNames() {
		return userNames;
	}
	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}
	
	
	
	
}

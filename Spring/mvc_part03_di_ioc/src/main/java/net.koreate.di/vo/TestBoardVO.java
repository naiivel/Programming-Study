package net.koreate.di.vo;

import org.springframework.stereotype.Component;

@Component
public class TestBoardVO {
	
	private int num;
	private String title;
	private String content;
	
	public TestBoardVO() {}
	
	public TestBoardVO(int num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
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
		return "TestBoardVO [num=" + num + ", title=" + title + ", content=" + content + "]";
	}
	
	
}

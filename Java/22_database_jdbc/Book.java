package guide_book;

import java.util.Date;

public class Book {
	
	// 도서관리 번호
	private int num;
	// 도서 제목
    private String title;
	// 도서 저자
	private String author;
	// 도서 등록일
	private Date regDate;
	
	public Book() {}
	//num 
	public Book(int num, String title, String author) {
		super();
		this.num = num;
		this.title = title;
		this.author = author;
	}
	//모든 정보를 넘겨받은 검색용 생성자
	public Book(int num, String title, String author, Date regDate) {
		super();
		this.num = num;
		this.title = title;
		this.author = author;
		this.regDate = regDate;
	}
	
	public int getNum() {
		return num;
	}
	
	//도서등록용 생성자 - title,author
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	//regdate getter setter 추가
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public Date getRegDate(Date regDate) {
		return regDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book b = (Book)obj;
			if(b.getTitle().equals(this.title)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Book [num=" + num + ", title=" + title + ", author=" + author + ", regDate=" + getRegDate(regDate) + "]";
	}

}

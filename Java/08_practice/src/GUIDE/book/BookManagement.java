package GUIDE.book;

import java.util.Scanner;

public class BookManagement {

	// 문자열 입력
	Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scanSelectNum = new Scanner(System.in);
	
	// 도서목록
	Book[] books = new Book[100];
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	// 도서관리 번호
	int count=1;	

	BookManagement(){
		run();
	}
	
	void run() {
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요 > ");
			
			switch(selectNo) {
				case 1 :
					registerBook();
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 프로그램 종료
	void terminate() {
		System.out.println("프로그램 종료");
	}

	// 도서 등록
	void  registerBook() {
		System.out.println("1. 도서등록");
		String title = getData("등록할 도서의 책제목을 입력해 주세요>");
		String author = getData("등록할 도서의 저자를 입력해 주세요>");
		for(int i=0; i<books.length; i++) {
			if(books[i] == null) {
				/*
				Book book = new Book();
				book.num = count;
				book.title = title;
				book.author = author;
				*/
				Book book = new Book(count,title,author);
				books[i] = book;
				System.out.println("등록 완료");
				count++;
				break;
			}
		}
	}
	
	// 도서 목록 출력
	void selectBook() {
		System.out.println("2. 도서목록");
		for(Book book : books) {
			if(book != null)printBookInfo(book);
		}
	}

	// 도서 정보 수정
	void updateBook() {
		System.out.println("3. 도서수정");
		int bookNum = getSelectNum("수정하실 책의 관리번호를 입력해주세요.");
		Book book = findBook(bookNum);
		if(book == null) {
			System.out.println("입력하신 번호의 책이 존재하지 않습니다.");
			return;
		}
		
		printBookInfo(book);
		
		boolean isUpdate = true;
		while(isUpdate) {
			System.out.println("==================================");
			System.out.println("1. 제목수정 | 2. 저자수정 | 3. 수정완료");
			System.out.println("==================================");
			selectNo = getSelectNum("번호 입력 > ");
			switch(selectNo) {
				case 1:
					System.out.println("제목 수정");
					String title = getData("제목 입력 > ");
					book.title = title;
					System.out.println("제목 수정 완료");
					break;
				case 2:
					System.out.println("저자 수정");
					String author = getData("저자 입력 > ");
					book.author = author;
					System.out.println("저자 수정 완료");
					break;
				case 3:
					System.out.println("수정완료");
					isUpdate = false;
					break;
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			}
		}
		
	}
	
	// 도서 목록에서 책 정보 삭제
	void deleteBook() {
		System.out.println("4. 도서삭제");
		int bookNum 
			= getSelectNum("삭제할 도서의 관리번호를 입력해주세요.");
		
		Book book = findBook(bookNum);
		if(book == null) {
			System.out.println("입력하신 관리번호의 책이 존재하지않습니다.");
			return;
		}
		
		// book = null;
		for(int i=0; i< books.length; i++) {
			if(books[i] != null && books[i] == book) {
				books[i] = null;
				System.out.println("삭제완료");
				break;
			}
		}
	}
	
	// 책 정보 출력
	void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	// 도서관리번호로 책 정보 찾기
	Book findBook(int num) {
		for(Book book : books) {
			if(book != null && book.num == num) {
				return book;
			}
		}
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return scanSelectNum.nextInt();
	}
		
	public static void main(String[] args) {
		new BookManagement();
	}

}

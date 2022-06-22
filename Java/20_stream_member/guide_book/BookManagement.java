package guide_book;

import java.util.ArrayList;
import java.util.Objects;

public class BookManagement extends AppBase
{
	
	public static void main(String[] args) {
		new BookManagement() {
			
		};
	}

	@Override
	public void registerBook() {
		boolean isJoin = true;
		
		while(isJoin) {
			String title = getData("등록할 도서의 제목을 입력해주세요 >");
			
			if(!titleCheck(title)) { //이미 존재하는 도서일 때
				System.out.println("동일 제목의 도서가 존재합니다.");
				continue;
			}
			String author = getData("등록할 도서의 저자를 입력해주세요 >");
			
			Book m = new Book(count++,title,author,System.currentTimeMillis());
			bookList.add(m);
			
			isJoin = false;
			System.out.println("도서등록이 완료되었습니다.");
			}
		}

	@Override
	public void selectBook() {
		for(Book m : bookList) {
			System.out.println(m);
		}
	}

	@Override
	public void updateBook() {
		System.out.println("==========================");
		System.out.println("1.제목수정|2.저자수정|3.수정완료");
		System.out.println("==========================");
		selectNo = getNum("번호를 선택하세요>");
		
		switch(selectNo) {
		case 1 :
			int count = getNum("도서번호입력");
			System.out.println("1.제목수정");
			for(int i=0; i<bookList.size(); i++) {
				Book m = bookList.get(i);
				if(m.getNum() == count) {
					String title = getData("제목입력");
					m.setTitle(title);
					System.out.println("수정완료");
					return;
				}
			}
		case 2 :
			count = getNum("도서번호입력");
			System.out.println("2.저자수정");
			for(int i=0; i<bookList.size(); i++) {
				Book m = bookList.get(i);
				if(m.getNum() == count) {
					String author = getData("저자입력");
					m.setTitle(author);
					System.out.println("수정완료");
					return;
				}
			}
		case 3 :
			System.out.println("수정완료");
			break;
		default : 
			System.out.println("등록된 메뉴가 아닙니다.");
		}
	}

	@Override
	public void deleteBook() {
		String count = getData("삭제할 도서의 관리번호를 입력해주세요. >");
		bookList.remove(count);
		count = null;
		System.out.println("삭제완료");
			
	}

	@Override
	public void saveBook() {
	}

	@Override
	public void terminate() {
		isRun = false;
	}
	// 도서 이름 중복 체크
	protected boolean titleCheck(String title) {
		for (Book m : bookList) {
			if (Objects.nonNull(m) && Objects.equals(title,m.getTitle())) {
				return false; // 중복
				}
			}
			return true;
		}
	
}
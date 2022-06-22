package guide_book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import guide.Member;

public class FileHelper {

	static File file;
	
	static {
		try {
			file = new File("member.dat");
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("member.dat 파일 생성");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Book> getList(){
		if(!file.exists() || file.length() ==0 ) {
			System.out.println("등록된 도서가 없습니다.");
			return null;
		}
		List<Book> bookList = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bookList = (ArrayList<Book>)ois.readObject();
			ois.close();
			fis.close();
		} catch(Exception e) {}
			return bookList;
	}
	
	public static void setList(List<Book> list) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush(); //OutputStream은 무조건
			oos.close();
			fos.close();
		} catch (Exception e) {}
	}	
}

package f03_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {//입력스트림은 무조건 마지막에 종료시켜줘야함
		
		InputStream is = null;

		try {
			File file = new File("C:\\Temp\\file2.txt");
			is = new FileInputStream(file);
			int readByte = 0;
			
			while(true) {
				//byte 단위로 읽어와서 읽은 값을 int로 반환
				readByte = is.read();
				System.out.println(readByte);
				//EOF = End Of File == -1 (파일을 전부 읽어들이면 마지막으로 -1 반환)
				if(readByte == -1) {break;}
				System.out.println((char)readByte);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 다른곳에서 파일이 켜져있으면 삭제가 안되니까 예외처리해줌
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("read 완료");
		
		
		
	}
}

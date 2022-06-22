package f03_input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadExample2 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("C:\\Temp\\file2.txt");
		
		int available = is.available();
		System.out.println("읽어들일 수 있는 파일크기 : " + available);
		
		byte[] bytes = new byte[3];
		
		int readByte = is.read(bytes, 0, bytes.length);
		System.out.println(Arrays.toString(bytes));
		System.out.println(readByte);
		available = is.available();
		System.out.println("읽어들일 수 있는 파일크기 : " + available);
		
		readByte = is.read(bytes, 0, bytes.length);
		System.out.println(Arrays.toString(bytes));
		System.out.println(readByte);
		available = is.available();
		System.out.println("읽어들일 수 있는 파일크기 : " + available);
	}
}
package f03_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadWriteExample {

	public static void main(String[] args) throws Exception {
		
		File file = new File("src/f03_input/ReadExample.java");
		
		InputStream is = new FileInputStream(file);
		
		int data;
		
		OutputStream os = System.out; //그냥 출력스트림, 콘솔에 출력할 수 있도록 연결된 스트림
		
		while((data = is.read()) != -1) {
			os.write(data);
		}
		os.flush();
		os.close(); //출력스트림
		is.close(); //입력스트림
		System.out.println("끝"); // close해서 출력안됌
	}
}
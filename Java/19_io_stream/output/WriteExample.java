package f02_output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file2.txt";
		
		try {
			OutputStream os = new FileOutputStream(path, true);
			String s = "EFG";
			byte[] bytes = s.getBytes();
			/* 방법 1
			for(int i=0; i<bytes.length; i++) {
				os.write(bytes[i]);
			}*/
			
			/*방법 2 : 전체 값 출력
			os.write(bytes);*/
			
			//방법 3 : 삽입,출력 범위 지정
			os.write(bytes,1,2);
			
			os.flush();
			os.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

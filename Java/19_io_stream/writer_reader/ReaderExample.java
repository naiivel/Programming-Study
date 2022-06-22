package f04_writer_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class ReaderExample {

	public static void main(String[] args) {
		
		try {
			Reader reader = new FileReader("C:\\Temp\\data.txt");
			int readData;
			/* 방법1
			while(true) {
				readData = reader.read();
				if(readData == -1) {break;}
				System.out.println((char)readData);
			}*/
			char[] cBuf = new char[100];
			while((readData = reader.read(cBuf)) != -1) {
				System.out.println(readData);
				System.out.println(Arrays.toString(cBuf));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

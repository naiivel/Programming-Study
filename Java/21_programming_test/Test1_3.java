import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test1_3 {

	public static void main(String[] args) {

		try {
			InputStream is = new FileInputStream("test.txt");
			Object o = new Object();
			Object o1 = new Object();
			o.equals(o1); // object.equals 는 주소값을 비교함.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
package f09_object.serialUid;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class OutputExample {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fis = new FileOutputStream("uid.dat");
		
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		
		ClassA a = new ClassA();
		
		a.filed1 = 1;
		oos.writeObject(a);
		oos.flush();
		oos.close();
	}

}

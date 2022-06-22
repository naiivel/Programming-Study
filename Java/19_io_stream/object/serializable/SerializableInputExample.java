package f09_object.serializable;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerializableInputExample {

	public static void main(String[] args) throws Exception {

		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("person.dat")));
		
		ArrayList<Person> list = new ArrayList<>();
		
		while(true) {
			try {
				Person p = (Person)ois.readObject();
				list.add(p);
				System.out.println(p);
			} catch(EOFException e) {
				System.out.println("다 읽어옴");
				break;
			}
		}
		System.out.println(list);
		ois.close();
	}
}
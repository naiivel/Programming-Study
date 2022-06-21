package a.object.toString;

public class ToStringExam {

	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.toString());
		
		obj = new Person("한지현", 158,50);
		System.out.println(obj);
	}
}
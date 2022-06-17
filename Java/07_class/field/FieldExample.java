package b.field;

public class FieldExample {
	
	public static void main(String[] args) {
		//main()가 포함이 되어있는 실행가능한 클래스
		Field f = new Field();
		System.out.println(f.i);
		System.out.println(f.b);
		System.out.println(f.d);
		System.out.println(f.s);
		
		Field f2 = new Field();
		f2.i = 100;
		f2.d = 3.14;
		f2.b = true;
		f2.s = "한지현";
		System.out.println(f2.i);
		System.out.println(f2.b);
		System.out.println(f2.d);
		System.out.println(f2.s);
	}

}

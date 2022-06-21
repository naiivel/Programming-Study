package singleton;

class Printer{
	private static Printer printer;
	private Printer() {}
	public static Printer getInstance() {
		if(printer == null) {
			printer = new Printer();
		}
		return printer;
	}
	
	public void println(String document) {
		System.out.println(document);
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		//Printer printer = new Printer();  printer가 private로 생성되어있기 때문
		//Printer.printer;
		Printer printer = Printer.getInstance();
		printer.println("문서 출력");
		Printer printerOther = Printer.getInstance();
		printerOther.println("두번째 문서 출력");
		System.out.println(printer == printerOther);
	}

}

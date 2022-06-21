package b.defaults;

public class Window {

	public void print(Printable printer) {
		printer.print();
	}
	private void colorPrint(Printable printer) {
		printer.colorPrint();
	}
	
	public static void main(String[] args) {
		Window window = new Window();
		Printable lgPrinter = new LGPrinter();
		Printable hpPrinter = new HPPrinter();
		window.print(lgPrinter);
		window.print(hpPrinter);
		window.colorPrint(lgPrinter);
	}
}
package final_test;

public class FinalExample {
	
	int a = 10;
	final double pi = 3.14;
	final int b;
	final static int MAX_VALUE = 30;
    
	FinalExample(){
		b = 100;
	}
	
	public static void main(String[] args) {
		
		FinalExample finalEx = new FinalExample();
		finalEx.a = 30;
		//finalEx.b = 10;
		final int v;
		v = 100;
		//static int ac = 10;  static은 로컬에서 사용 불가능
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}

}

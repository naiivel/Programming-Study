package extends4.protectedz.b;

import extends4.protectedz.a.A;

public class D extends A {
	
	A a = new A();
	D(){
		//a.a = 100;
		super.a = 100;
		methodA();
	}
	
	@Override
	protected void methodA() { //재정의 할때 protected 보다 넓은 범위는 지정가능 ex)public
		System.out.println("D class의 methodA");
	}
	
	// methodB() 는 final이라 재정의 불가
	//protected void methodB() { }

	public static void main(String[] args) {
		System.out.println("");
	}
}

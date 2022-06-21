package extends1.base.diamond;

public class D extends B {//,C{ 다중상속안되고 단일상속만 가능
	public static void main(String[] args) {
		D d = new D();
		d.methodA();
	}
}
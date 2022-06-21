package c.extend;

public interface A {
	void methodA();
}

interface B{
	void  methodB();
}

interface C extends A,B{
	void methodC();
	
	default void methodB() {}
}

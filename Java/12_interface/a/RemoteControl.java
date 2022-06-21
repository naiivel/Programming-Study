package a.base;

public interface RemoteControl {
	
	//인터페이스는 public static final abstract 생략됨 (상수만 정의)
	public static final int MAX_VALUE = 10; 
	int MIN_VALUE = 0;
	
	public abstract void turnOff();
	void turnOn();
	void setValue(int value);
	
	// void setValue(int value) {}   = 일반 메소드 정의 불가 (추상 메소드만 가능)
}
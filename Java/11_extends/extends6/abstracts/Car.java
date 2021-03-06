package extends6.abstracts;

public abstract class Car {

	public abstract void drive();
	
	public abstract void stop();
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	final public void run() {//재정의 할 수 없는 메쏘드
		startCar();
		drive();
		stop();
		turnOff();
	}
	
}
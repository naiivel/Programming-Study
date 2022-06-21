package a.base;

public class AirRemoteControl implements RemoteControl{

	int temperature = 24;
	
	@Override
	public void turnOff() {
		System.out.println("에어컨을 끕니다.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("에어컨을 켭니다.");
	}
	
	@Override
	public void setValue(int value) {
		this.temperature = value;
		System.out.println(temperature+ "로 설정합니다.");
	}
	
}

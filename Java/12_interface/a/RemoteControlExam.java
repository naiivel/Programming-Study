package a.base;

public class RemoteControlExam {

	public static void main(String[] args) {
		
		RemoteControl tvRemote; // = new RemoteControl();  추상메소드를 생성할 수 없음, interface는 타입이 가능함
		tvRemote = new TVRemoteControl();
		tvRemote = new AirRemoteControl();
		
		tvRemote.turnOn();
		tvRemote.setValue(11);
		tvRemote.turnOff();
		
		System.out.println(RemoteControl.MAX_VALUE);
		System.out.println(RemoteControl.MIN_VALUE);
		//RemoteControl.MIN_VALUE = 10;  = final값이 생략되있어서 값변경불가

		RemoteControl smartTVRemote = new SmartTVRemoteControl();
		smartTVRemote.turnOn();
		//smartTVRemote.search("안됨");
		smartTVRemote.setValue(8);
		
		Searchable searchRemote = (Searchable)smartTVRemote;
		searchRemote.search("아앙아");
		if(searchRemote instanceof SmartTVRemoteControl) {
			SmartTVRemoteControl stc = (SmartTVRemoteControl)searchRemote;
			System.out.println(Searchable.MAX_VALUE);
		}
	}
}
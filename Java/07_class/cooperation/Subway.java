package f.cooperation;

public class Subway {
	String lineNumber; 
	int passengerCount;
	int money;
	
	// alt + s + a
	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	void take(int money) {
		this.money = money + this.money;
		this.passengerCount++;
	}

	void showInfo() {
		System.out.printf(lineNumber);
		System.out.println(passengerCount);
		System.out.println(money);
	}
}

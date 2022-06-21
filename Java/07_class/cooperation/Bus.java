package f.cooperation;

public class Bus {
	int busNumber; 
	int passengerCount;
	int money;

	Bus(int busNumber){
		this.busNumber = busNumber;
		
	}
	void take(int money) {
		this.money = money + this.money;
		this.passengerCount++;
	}
	void showInfo() {
		System.out.printf("버스 %s번의 승객은 %d명이고, 수입은 %d입니다.",busNumber,passengerCount,money);
	}
}

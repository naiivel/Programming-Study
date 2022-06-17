package d.constructor;

public class CarExample {

	public static void main(String[] args) {
		Car basic = new Car();
		System.out.println(basic.company);
		
		Car myCar = new Car("Benz","E","black");
		System.out.println(myCar.model);
		
		//Car Car2 = new Car("KIA", "K5", "black", 250, 140);
		//System.out.println(Car2.model);
	}
}

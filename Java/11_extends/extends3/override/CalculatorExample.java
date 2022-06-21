package extends3.override;

public class CalculatorExample {
//오버라이딩은 부모가 가진 것을 재정의 하는 것
//오버로딩은 메소드의 이름이 같을 때 매개변수의 갯수나 타입이 다른 함수를 정의
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		double area = calc.circleArea(5);
		System.out.println(area);
		Computer com = new Computer();
		area = com.circleArea(5);
		System.out.println(area);
		
	}
}
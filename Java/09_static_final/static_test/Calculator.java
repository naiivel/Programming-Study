package static_test;

public class Calculator {
	
	int a = 10; //인스턴스 멤버는 new 연산자 생성해야 사용가능
	int b = 10;
	
	static int result;
	
	int sum(){
		return a + b;
	}
	
	static int plus(int x, int y) {
		//a = x + y; 인스턴스 멤버가 아직 생성안된 상태라서 안됨
		return x + y;
	}
	
	public static void main(String[] args) {
		//Calculator.sum(); 안됨
		int sum = Calculator.plus(10, 20);
		
		Calculator calc = new Calculator();
		
		sum = calc.sum();
		result = Calculator.plus(100, 200);
		
		System.out.println(sum);
		System.out.println(result);
	}

}

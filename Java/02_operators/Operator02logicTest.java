public class Operator02logicTest {

	public static void main(String[] args) {
		//논리 연산자 : &&, ||, ^, !
		// | == shift + \
		int num1 = 5;
		int num2 = 10;
		//&& 논리 곱
		// 좌변 우변 둘다 true 일때만 true
		//둘중에 하나라도 false이면 false
		boolean result = (num1 < 0) && (num2++ > 0);
		System.out.println(result);
		System.out.println(num1 + " : " + num2);
		
		//|| 논리합
		//둘중에 하나라도 true이면 true
		//둘다 false 일때 false
		num1 = 0;
		num2 = 0;
		result = (++num1 > 0) || (num2++ > 0);
		System.out.println("result : " + result);
		System.out.println(num1+" : " + num2);
		
		System.out.println("result : " + !result);
	}

}

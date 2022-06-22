package d.wrapper;

import java.util.Objects;

public class WrapperExample {

	public static void main(String[] args) {
		//boxing 
		//java 9version 에서 deprecated 비추천
		Integer obj1 = new Integer(100);
		
		obj1 = Integer.valueOf(100);
		obj1 = Integer.valueOf("100");
		
		//자동 boxing
		obj1 = 100;
		//obj1 = "100";  = 오류
		
		//unboxing = 포장을 해제하고 기본타입으로 돌림
		int i = obj1.intValue();
		System.out.println(i);
		
		//자동 unBoxing
		int value = obj1;
		System.out.println(value);
		
		//valueOf = 문자열 또는 기본 타입의 데이터를 해당 타입의 포장 객체로 반환
		Integer obj2 = Integer.valueOf("600");
		//Integer unBoxing 과정 추가
		Integer obj3 = Integer.valueOf("700");
		//기본타입으로 반환
		int obj4 = Integer.parseInt("600");
		
		double valueDouble = Double.parseDouble("3.14");
		
		boolean valueBoolean = Boolean.parseBoolean("true");
		
		byte b = 127;
		Byte b1 = Byte.valueOf(b);
		b1 = Byte.valueOf((byte)100);
		b1 = Byte.valueOf("100");
		
		//Character는 한 개의 문자를 표현하기 때문에 문자열 대입이 불가능		
		char c = '가';
		Character c1 = Character.valueOf(c);
		c1 = Character.valueOf((char)65);		
		//c1 = Character.valueOf("A");
		//c = Character.parseCharacter("A");          
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		//각 타입에 맞는 값을 비교하는 컴페어
		int a = Integer.compare(10, 20);
		//앞에 값이 작으면 음수 , 같으면 0 , 앞에 값이 크면 양수
		System.out.println(a);
		
		Integer i1 = 10;
		int result = i1.compareTo(5);
		System.out.println(result);
		
		int d1 = Double.compare(10.0, 15.0);
		System.out.println(d1);
		
		char cha = 'A';  //65
		char zero = '0'; //48
		System.out.println("char compare : " + Character.compare(cha, zero));
		
		test(new Integer(1));
		test(Float.valueOf(3.14f));
		test(3.141592);
		test(11111111111L);
		test(null);
	} //main 종료
	
	static void test(Number o) {
		if(Objects.nonNull(o)) {
			System.out.println(o.intValue());
			System.out.println(o.longValue());
			System.out.println(o.doubleValue());
		} else {
			System.out.println("null값을 활용할 수 없습니다.");
		}
	}
}
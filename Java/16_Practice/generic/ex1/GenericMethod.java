package generic.ex1;

import java.util.Arrays;

public class GenericMethod1 {

	public static void main(String[] args) {
		
		Integer[] iArray = {10,20,30,40,50};
		Double[] dArray = {1.1, 1.2, 1.3, 1.4, 1.5};
		Character[] cArray = {'K','O','R','E','A'};
		
		printArray(iArray);
		printArray(dArray); // GenericMethod1.<Double>printArray(dArray); 생략
		printArray(cArray); 
}
	
	private static <T> void printArray(T[] t) {  // Generic : 메소드를 호출할 때 T라는 타입으로 호출된다
		System.out.println(Arrays.toString(t));
	}
	
/* Generic을 이용하지 않은 방법
	private static void printArray(Character[] cArray) {
		System.out.println(Arrays.toString(cArray));
	}

	private static void printArray(Double[] dArray) {
		System.out.println(Arrays.toString(dArray));
	}

	private static void printArray(Integer[] iArray) {
		System.out.println(Arrays.toString(iArray));
	}
*/
}

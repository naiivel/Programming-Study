public class UseArrayTest {

	public static void main(String[] args) {
		//배열 생성 방법
		
		//1. 정해진 값이 있을 시 정해진 값으로 크기가 결정되므로 크기를 지정할 필요가 없음
		int[] array = new  int[]{10,20,30,40,50};
		
		//2. 선언과 동시에 값을 지정할 때는 new 연산자 생략가능
		int array2[] = {50,60,70,80};
		
		//3. 생성 시 값이 정해져 있지 않을 때는 공간만 생성 가능, 공간에 기본값으로 자동 초기화 
		                                                                              //정수 :0, 실수 :0.0, 논리 :false, 참조 :null 
		int array3[] = new int[5];  //int형 정수값 5개 저장 가능, 변수에 위치를 저장해 놓음, 변수를 통해 배열 접근 가능
		//array3 = [0][0][0][0][0] :  index 0 1 2 3 4
        // 배열의 크기를 저장하고 있는 값 : 배열변수.length
		System.out.println(array3);
		System.out.println(array3.length);
		
		//참조 타입은 null로 초기화 가능
		int[] array4 = null;
		System.out.println(array4);
		//System.out.println(array4.length);  = error
		array4 = new int[3];
		//array4.length = 10; = error
		
		final int value = 10; //final은 변경 불가
		System.out.println(value);
		
		int a =array4[0]; 
		System.out.println(a);
		array4[0] = 30;
		array4[1] = 50;
		array4[2] = 70;
		//array4[3] = 80; = ArrayIndexOutOfBoundsException 
		
		for(int i=0; i<array4.length; i++) {
			System.out.println(array4[i]);
		}
		
		
		
	}
}
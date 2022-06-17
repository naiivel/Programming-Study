import java.util.Scanner;

public class Practice07 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		//max 찾기
		System.out.println("첫번째 정수 : ");
		int first = sc.nextInt();
		System.out.println(" ");
		System.out.println("두번째 정수 : ");
		int second = sc.nextInt();
		if(first > second) {
			System.out.println("큰수는 : " + first);
		} else {
			System.out.println("큰수는 :  " + second);
		}
		//2번째 방법
		int max = 0;
		if(first > second) {
			max = first;
		} else {
			max = second;
		}
		System.out.println("큰 수는 : " + max);
	}

}

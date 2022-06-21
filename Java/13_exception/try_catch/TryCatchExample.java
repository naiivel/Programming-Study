package test1.try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {

	public static void main(String[] args) {
		System.out.println("MAIN START");
		
		String str = null;
		int[] scores = new int[4];
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("배열에 삽입하려는 인덱스 번호 입력>");
		int index = sc.nextInt(); //숫자말고 문자열 입력시 예외발생(InputMismatchException)
		System.out.println("입력하려는 값을 작성하시오>");
		scores[index] = sc.nextInt();
		
		// } catch(Exception e){
		}catch(InputMismatchException e) {
			System.out.println("정수가 입력되지 않음");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("e massage : " + e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("항상 실행");
		}
		System.out.println("MAIN END");
	}
}

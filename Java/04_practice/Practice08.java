import java.util.Scanner;

public class Practice08 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		int studentNum = 5;
		int sum = 0;
		int avg = 0;
		
		for(int i=0; i<studentNum; i++) {
			System.out.println("성적을 입력하시오 : ");
			sum = sum + sc.nextInt();
		}
		avg = sum / studentNum;
		System.out.println("평균 성적은 : " + avg + "입니다.");
	}

}

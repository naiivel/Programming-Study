

import java.util.Scanner;

public class PracticeAll {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* 1번
		String str;
		str = "Hello JAVA";
		System.out.println(str);
		*/
		
		/* 2번
		int i = 0;
		boolean radius = true;
		while(radius) {
			System.out.println("반지름을 입력하시오 : ");
			int ra = sc.nextInt();
			if(ra>0) {
				System.out.println(ra*ra*3.14);
				break;
			}
		}
		*/
		
		/* 3번
		int i = 0;
		int sum = 0;
		for(i=1; i<=10; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println(sum);
		*/
		
		/* 4번
		int i = 0;
		int sum = 0;
		for(i=1; i<=100; i+=2) {
			sum = sum +  i;
		}
		System.out.println("홀수의 합 : " + sum);
		*/ 
		
		/* 5번
		do {
			System.out.println("사다리꼴 넓이 구하기");
			System.out.print("윗변 입력 : ");
			double i = sc.nextInt();
			System.out.print("아랫변 입력 :");
			double j = sc.nextInt();
			System.out.print("높이 입력 :");
			double k = sc.nextInt();
			
			double result = (i + j) * k / 2; 
			System.out.println(result);
		} while(false);
		 */
		
		/* 6번
		// 사원명 입력 ,  시급과 근무시간 정수로 입력 => 급여명세서
		System.out.println("사원명을 입력하세요 >");
		String i = sc.next();
		System.out.println("시급을 입력하세요 >");
		int j = sc.nextInt();
		System.out.println("근무시간을 입력하세요 >");
		int k = sc.nextInt();
		
		int result1 = j*k;
		int result2 = result1 * 3/100;
		int result3 = result1 - result2; 
		
		System.out.println("급여명세서" + "\n" + "사원명 : " + i + "\n" + "급여금액 : " + result1 + "\n" +
										"공제금액 : " + result2 + "\n" + "실지급액 : " + result3 );
		*/
		
		/* 7번 */
		
		/* 8번
		System.out.println("첫 번째 정수 : ");
		int i = sc.nextInt();
		System.out.println("두 번째 정수 :");
		int j = sc.nextInt();
		
		if(i > j) {
			System.out.println("큰 수는" + i);
		} else {
			System.out.println("큰 수는" + j);
		}
		 */
		
		/* 9번
		System.out.println("성적을 입력하시오 : ");
		int a = sc.nextInt();
		System.out.println("성적을 입력하시오 : ");
		int b = sc.nextInt();
		System.out.println("성적을 입력하시오 : ");
		int c = sc.nextInt();
		System.out.println("성적을 입력하시오 : ");
		int d = sc.nextInt();
		System.out.println("성적을 입력하시오 : ");
		int e = sc.nextInt();
		
		int result = (a+b+c+d+e) / 5;
		System.out.println("평균성적은 " +result+ "입니다.");
		 */
		
		/* 10번
		do {
			System.out.println("점수를 입력해주세요.");
			int score = sc.nextInt();
			if(score>=90 && score<101) {
				System.out.println("A 학점입니다.");
			} else if(score>79 && score<90) {
				System.out.println("B 학점입니다.");
			} else if(score>69 && score<80) {
				System.out.println("C 학점입니다.");
			} else if(score>59 && score<70) {
				System.out.println("D 학점입니다.");
			} else {
				System.out.println("F 학점입니다.");
			} 
		 } while(true);
   			*/
		
		/* 11번
		int i;
		for(i=9; i>1; i--) {
			for(int j=9; j>1; j--) {
				System.out.print(i + "*" + j + "=" + i*j + "\t"); 
			}
			System.out.println();
		}
		*/
		
		/* 12번
		boolean isRun = true;
		int money = 0;
		
		while(isRun) {
			System.out.println("=====================");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔액확인 | 4. 종료");
			System.out.println("=====================");
			System.out.println("번호를 입력해 주세요(1~4) >");
			int num =sc.nextInt();
			
			if(num == 1) {
				System.out.println("입금");
				System.out.println("입금하실 금액을 입력하세요.");
				money = sc.nextInt();
				System.out.println(money + "원 입금이 완료되었습니다.");
			} else if(num ==2) {
				System.out.println("출금");
				System.out.println("출금하실 금액을 입력해 주세요.");
				int money2 = sc.nextInt();
				if(money2 >= money) {
					System.out.println("출금 금액이 예금된 금액보다 클 수 없습니다.");
					} else {
					System.out.println(money2 + "원 출금되었습니다.");
					money = money -money2;
					}
			} else if(num ==3) {
				System.out.println("잔액확인");
				System.out.println("잔액 : " + money);
			} else if(num == 4) {
				System.out.println("종료");
				isRun= false;
				}
			}
		System.out.println("Main 종료");
		*/
	}
}
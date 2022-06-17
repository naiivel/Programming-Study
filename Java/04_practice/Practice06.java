import java.util.Scanner;

public class Practice06 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		//급여명세서 
		System.out.println("사원명을 입력해주세요 >");
		String 사원명 = sc.next();
		System.out.println("시급을 입력해 주세요 >");
		int 시급 = sc.nextInt();
		System.out.println("근무시간을 입력하세요 >");
		int 근무시간 = sc.nextInt();
		int 급여금액 = 시급*근무시간;
		System.out.println("==== 급여명세서 ====");
		System.out.println("사원명 : " +사원명);
		System.out.println("급여금액 : " + 급여금액);
		int 공제합계 = 급여금액 * 3 / 100;
		공제합계 = (int)(급여금액 * 0.03);
		System.out.println("공제합계 : " + 공제합계);
		int 실지급액 = 급여금액 - 공제합계;
		System.out.println("실지급액 : " + 실지급액);
	}

}

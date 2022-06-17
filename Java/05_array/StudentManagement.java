import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 무언가를 입력 받을 때 적용
		//프로그램 종료 flag
		boolean isRun = true;
		//학생점수를 입력받아 저장할 배열
		int[] scores = null;
		//학생 수를 입력받아 저장할 변수
		int studentNum = 0;
		
		while(isRun) {
			System.out.println("==================================");
			System.out.println("1.학생수|2.점수입력|3.전체점수|4.분석|5.종료");
			System.out.println("==================================");
			System.out.println("선택하실 기능의 번호를 입력하세요. >");
			int selectNo = sc.nextInt();
			System.out.println("선택하신 번호는 : " + selectNo);
			
			if(selectNo != 1 && scores == null) {
				System.out.println("학생 수를 먼저 입력해주세요.");
				continue; //밑으로 내려가지않고 다시 위로 올라가서 반복문 수행
			} 
			
			switch(selectNo) {
			 	case  1 : 
			 		System.out.println("학생수를 입력하세요.");
			 		studentNum = sc.nextInt();
			 		scores = new int[studentNum];
			 		System.out.println("등록된 학생 수는 : " + scores.length);
			 		break;
			 	case  2 :
			 		System.out.println("점수를 입력하세요.");
			 		for(int i=0; i<scores.length; i++) {
			 			System.out.println((i+1) + "번째 학생의 점수를 입력하세요.");
			 			scores[i] = sc.nextInt();
			 		}
			 		System.out.println("점수 입력완료");
			 		break;
			 	case 3 :
			 		System.out.println("등록된 학생 점수 출력");
			 		for(int score : scores) {
			 			System.out.println("등록된 학생의 점수는 : " + score);
			 		}
			 		break;
			 	case 4 : 
			 		int sum = 0;
			 		double avg = 0;
			 		int max = scores[0];
			 		int min = scores[0];
			 		
			 		for(int i : scores) {
			 			sum += i;
			 			if(max < i) {max = i;} 
			 			if(min < i) {min = i;}
			 		}
			 		
			 		System.out.println("총점 : " +sum);
			 		System.out.println("최고점수 : " +max);
			 		System.out.println("최저점수 : " +min);
			 		avg = (double)sum / studentNum;
			 		System.out.printf("평균 : %.1f %n", avg); // %.1f 소수점 첫번째자리에서 반올림
			 		break;
			 	case 5 :
			 		System.out.println("종료");
			 		isRun = false;
			 		break;
			}
		}
	}
}
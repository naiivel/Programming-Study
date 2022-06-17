import java.util.Arrays;
import java.util.Scanner;

public class java {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 /*1번
		int[] scores = new int[5];
		int score = 0;
		boolean isRun = true;
		double avg = 0;
		
		while(isRun) {
			for(int i=0; i<5; i++) {
				System.out.print("성적을 입력하세요. : ");
				scores[i] = sc.nextInt();
				int sum = 0;
				sum += i;
				avg = (double) sum / 5;
				}
			System.out.println("평균성적은 : " + avg + "입니다.");
		}		
		
		/*2번
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		boolean isRun = true;
		int number = 0;
		
		while(isRun) {
			System.out.println("검색할 번호를 입력");
			number = sc.nextInt();
			System.out.println(number+ "는 " +numbers[number] + "index에 있습니다.");
		}
		*/
		
		/*3번
		int[] s = {12,3,19,6,18,8,12,4,1,19};
		int min = s[0];
		
		for(int i=0; i<s.length; i++) {
			if(min>s[i]) {min=s[i];}
		}
		System.out.println("최소값은" +min);
		*/
		
		/*4번
		System.out.println("크기를 입력하세요.");
		int num = sc.nextInt() + 1;
		int number[][] = new int[num][num];
		
			for(int i=0; i<number.length; i++) {
				for(int j=0; j<i; j++) {
					number[i][j] = j;
					System.out.print(number[i][j] + " ");
				}
				System.out.println();
			}
		*/
		
		 /* 5번
		final int size = 10;
		int[] seats = new int[size];
		
		while(true) {
			System.out.println("===============");
			for(int i=0; i<size; i++) {
				System.out.print(i+1 +" ");
			}
			System.out.println("\n===============");
			for(int i=0; i<size; i++) {
					System.out.print(seats[i] + " ");
			}
			System.out.println("\n================");
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1) : ");
			int number = sc.nextInt();
			
			if(number == -1) {
				System.out.println("종료");
				break;
			}
			if(seats[number-1] == 0) {
				seats[number-1] = 1;
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("이미 예약된 자리입니다.");
			}
		}
		*/
		 /* 6번
		int[][] seats = new int[10][10];
		boolean isRun = true;
		String strColumn; //열이름
		char inputColumn; //열이름
		int rowNum; //행번호
		
		do {
			System.out.println("\t\t SCREEN");
			for(int i=0; i<seats.length; i++) {
				System.out.print("[" + (i+1) + "]");
			}
			System.out.println(" [행] ");
			
			for(int i=0; i<seats.length; i++) {
				System.out.println();
				for(int j=0; j<seats[i].length; j++) {
					if(seats[i][j] == 0) {
						System.out.print("[□]");
					} else {
						System.out.print("[■]");
					}
				}
				System.out.println("[" + (char)(i +65) + "]열");
			}
			System.out.print("\t\t\t");
			System.out.print("예약하실 좌석의 열을 입력해주세요. (예약종료는 exit) : ");
			strColumn = sc.next();
			if(strColumn.equals("exit")) {
				System.out.println("종료되었습니다.");
				break;
			}
			inputColumn = strColumn.trim().charAt(0);
			System.out.println("입력한 열 : " + inputColumn);
			if(inputColumn < 65 || inputColumn > 74) {
				System.out.println("선택할 수 없는 좌석입니다.");
				continue;
			}
			int column = inputColumn - 65;
			System.out.println("예약하실 좌석의 행 번호를 입력해주세요. : ");
			rowNum = sc.nextInt();
			
			if(rowNum < 1 || rowNum > 10) {
				System.out.println("선택할 수 없는 행 번호입니다.");
				continue;
			}
			System.out.println("선택하신 좌석은 : " + inputColumn + "열이고" + rowNum + "행입니다.");
			System.out.println("예약 완료 하시겠습니까? (Yes/No) : ");
			
			String s = sc.next();
			if(s.equals("y") || s.equals("Y")) {
				seats[column][rowNum -1]=1;
				System.out.println("예약이 완료되었습니다.");
			} else {
				System.out.println("취소되었습니다.");
				isRun = false;
			}
		} while(isRun);
		*/
	}
}	
		
		
		
		
		 
		 
		

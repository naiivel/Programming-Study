package conditional_statement;

public class IfStatementExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		int num1 = 10;
		int num2 = 20;
		boolean op = num1 > num2;
		if(op)System.out.println("num1이 num2보다 큽니다"); 
		
		if(num1 < num2) {
			System.out.println("num1이 num2보다 작습니다");
		} else {
			System.out.println("num1이 num2보다 큽니다");
		}
		int score = 75;
		if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		} else if(score >= 70) {
			if(score >=77) {
				System.out.println("C+");
			} else if(score>= 73) {
				System.out.println("C0");
			} else {
				System.out.println("C-");
			}
		} else if(score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		//console을 통해 사용자에게 값을 입력 받는 class
		java.util.Scanner sc 
		= new java.util.Scanner(System.in);
		//sc.next() = 사용자에게 한개의 단어를 입력받음(word)
		//sc.nextInt(); = 사용자에게 한개의 정수값을 입력받음(int)
		//sc.nextLine(); = 사용자에게 한행의 문자열을 입력받음
		System.out.println("아이디를 입력해주세요 > ");
		String id = sc.next(); //입력대기
		System.out.println(id); //입력완료
		System.out.println("비밀번호를 입력해주세요 >"); 
		String pw = sc.next();//입력대기
		System.out.println(pw);//입력완료
		
		//if(id == "id001" && pw == "pw001")  = 저장되어 있는 공간이 달라서 틀림
		if(id.equals("id001") && pw.equals("pw001")) {
			System.out.println("로그인 완료");
		} else {
			System.out.println("로그인 실패");
		}
		
		System.out.println("Main 종료");
	}

}

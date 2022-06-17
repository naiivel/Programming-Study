
public class Practice01 {

	public static void main(String[] args) {
		String str = "Hello Java!!";
		System.out.println(str);
		/*
		printf() = 줄바꿈이 이루어지지않음, 출력하려는 지시자의 수만큼 필요한 값을 전달해야함
        %d = int(decimal) 10진법의 정수 형식
		%b = boolean 논리값
		%o = oct 8진법으로 표현
		%x = 16진법으로 출력
		%f = float 실수 형태로 출력
		%c = character 문자형식으로 출력
		%s = string 문자형태로 출력
		%n = new line 줄바꿈
		
		%[-][0][n][.m][,n]
		%[n] = 출력할 전체 자리수를 지정(오른쪽 정렬)
		%5d, 1000 == []1000  = 5칸에다가 1000의 값 지정
		%0 = 전체 자리수가 지정되어 있을 때 빈자리를 0으로 채움
		%05d, 1000 == 01000
		%[-] = 전체 자리수가 지정된 경우
				  왼쪽으로 정렬하고 빈칸에 공백 출력
		%[.m] = 소수점 아래 자리수를 지정.
				  	 잘리는 소수점 자리는 반올림
		%[,] = 정수의 자리수 표현
				  10,000,000
		0,- = 정수에서만 사용 가능
		 */
		System.out.printf("%s의 교재는 %,020d입니다.%n","자바",1000000);
		System.out.printf("%s의 교재는 %20d입니다.\n","자바",1000000);
		System.out.printf("%s의 교재는 %-20d입니다.\n","자바",1000000);
		System.out.printf("자리수 지정 : %4d%n",1);
		System.out.printf("자리수 지정 : %4d%n",10);
		System.out.printf("자리수 지정 : %4d%n",100);
		System.out.printf("자리수 지정 : %4d%n",1000);
		
		//소수점 자리 %.mf
		System.out.printf("%.2f %n",1234.123);
		System.out.printf("%.2f %n",1234.127);
		
		//오류
		System.err.println("니가 잘못했네.");
	}
}

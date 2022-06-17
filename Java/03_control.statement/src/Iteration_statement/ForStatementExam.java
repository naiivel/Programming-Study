package Iteration_statement;

public class ForStatementExam {

	public static void main(String[] args) {
		//연속된 연산을 반복하며 수행하는 문장
		int sum = 1+2+3+4+5+6+7+8+9+10;
		//1~100 까지 합을 구하시오
		sum = 0;
		int i;
		for(i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println(i);
		System.out.println(sum);
				
		// for(;;) {} = 탈출 방법이 없어 무한히 반복
		int j = 1;
		sum = 0;
		for(;; j++) {
			if(j>10) {
				break;
			}
			sum += j;
		}
		
		int k;
		for(k=2; k<=9; k++) {
			System.out.print(k+ "단\t|");
			for(int x=1; x<=9; x++) {
				System.out.print(k+ " * " + x + " = " + (k*x) + "\t");
			}
			System.out.println();
		}
		
	}

}

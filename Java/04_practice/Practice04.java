import java.util.Scanner;

public class Practice04 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		 int odd = 0;
		 for(int i=1; i<=100; i+=2) {
			 System.out.print(i+ " ");
			 odd += i;
		 }
		 System.out.println("\n 홀수의 합은 : " + odd);
		 
		 for(int i=1; i<=100; i++) {
			 if(i%2 == 1) {
				 odd += i;
			 }
		 }
		 System.out.println("홀수의 총합은 : " + odd);
	}

}

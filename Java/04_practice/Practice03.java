import java.util.Scanner;

public class Practice03 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
			sum = sum + i;
		}
		System.out.println();
		System.out.println("합은 : " + sum);
	}

}

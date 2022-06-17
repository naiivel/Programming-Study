import java.util.Scanner;

public class Practice10 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		for(int i=9; i>1; i--) {
			for(int j=9; j>=2; j--) {
				System.out.printf("%d * %d = %d\t", i ,j,i*j);
			}
			System.out.println();
		}
	}
}

import java.util.Scanner;

public class Practice02 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		//원의 면적
		double area, radius;
		System.out.println("반지름을 입력해 주세요 > ");
		radius = sc.nextDouble();
		double pi = 3.14;
		area = radius * radius * pi; 
		System.out.println(area);
		System.out.printf("반지름이 %.1f인 원의 면적은 : %.3f",radius,area);
	}
}

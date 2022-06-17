import java.util.Scanner;

public class Practice05 {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		
		//사다리꼴의 넓이
		//(윗변 + 아랫변)*높이 / 2, 소수점
		int top = 5;
		int bottom = 10;
		int height = 7;
		double area = (top+bottom)*height /2 ;
		System.out.println("사다리꼴의 넓이 : " + area);
	}

}

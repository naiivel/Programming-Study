package Explain;

import java.util.Scanner;
import java.util.TreeSet;

public class Explain4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Integer> set = new TreeSet<>();
		
		System.out.println("정수(-1이 입력될때 까지) >>");
		
		while(true) {
			int n = sc.nextInt();
			if(n == -1) { break; }
			set.add(n);
		}
		
		if(set.isEmpty()) {
			System.out.println("수가 하나도 없음");
			System.out.println("시스템 종료");
			return;
		}
		
		int max = set.last();
		int min = set.first();
		System.out.println(set);
		System.out.println("가장 큰 수는: " + max);
		System.out.println("가장 작은 수는: " + min);
		System.out.println("시스템 종료");
	}
}
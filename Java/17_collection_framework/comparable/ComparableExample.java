package c7_comparable;

import java.util.TreeSet;

public class ComparableExample {

	public static void main(String[] args) {
		TreeSet<Integer> intSet = new TreeSet<>();
		intSet.add(50); // 50 = 50 == 0 이동하지 않음
		intSet.add(70); // 50 < 70  ?  1 : (50==70)  ? 0 : -1; 
		intSet.add(60); // 들어가있는 값 : 50,70,60  |  index(0 + 2)/2 = 1 
		System.out.println(intSet);
		
		System.out.println("===================");
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("최기근", 26));
		set.add(new Person("박주신", 300));
		set.add(new Person("김박사",30));
		set.add(new Person("제승후",65));
		System.out.println(set);
	}
}

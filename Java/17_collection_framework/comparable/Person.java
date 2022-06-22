package c7_comparable;

public class Person implements Comparable<Person>{
	// comparable = <person>이란 객체를 정렬하기위한
	private String name;
	private int age;
	
	//생성자 and toString
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) { //배열을 어떤식으로 정렬할지 정해주는 메소드
		int result = 0;
		//내가 가진 값이 크면 음수 , 매개변수로 넘겨받은 객체의 age가 크면 양수
		result = o.age - this.age;
		System.out.println(o.age+ "-" +this.age);
		System.out.println(result);
		return result;
	}
	
}
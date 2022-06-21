package a.object.toString;

public class Person { //extends Object 생략
	String name;
	int height;
	int weight;
	
	//alt + s + a = 생성자 만들기
	public Person(String name, int height, int weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}

package generic05_wildcard;

public class Person {
	
	private String name;

	//alt + s + a
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}
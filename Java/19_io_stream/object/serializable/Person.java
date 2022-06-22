package f09_object.serializable;

import java.io.Serializable;

public class Person implements Serializable{
	
	private String name;
	//직렬화 데이터에서 제외
	private int age;
	
	//getter setter toSting 추가
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	

}

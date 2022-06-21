package encapsulation;
	
public class Student {
	public String name;
	private int age;
	private int grade;
	
	//age 캡슐화(private)
	public void setAge(int age) {
		if(age < 1) {
			this.age = 1;
			return;
		}
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	//grade 캡슐화
	public void setGrade(int grade) {
		if(grade < 1 || grade > 3) {
			this.grade = 1;
			return;
		}
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	//alt + s + s + s
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}

}

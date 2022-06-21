package extends5.polymorphism;

public class Teacher extends Person{
	
	String tNumber;
	String subject;
	String grade;
	
	public Teacher(String name, int age, int weight, int height, String tNumber, String subject, String grade) {
		super(name, age, weight, height);
		this.tNumber = tNumber;
		this.subject = subject;
		this.grade = grade;
	}
	
	public void teach() {
		System.out.println(super.name + "은 " + this.subject + "를 가르칩니다.");
	}

	@Override
	public String toString() {
		return super.toString()+"Teacher [tNumber=" + tNumber + ", subject=" + subject + ", grade=" + grade + "]";
	}
}
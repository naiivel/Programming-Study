package extends5.polymorphism;

public class PersonExample {

	public static void main(String[] args) {
		Person person = new Person("안민경",23,50,155);
		System.out.println(person.toString());
		System.out.println("============================================");
		System.out.println(person);
		
		Person student = new Student(
					"한다영",500,60,162,"302호","2번","4");
		System.out.println(student);
		//student.study();  타입이 Person이라 study() 메소드 사용 불가
		Person teacher = new Teacher(
				    "최기근",25,74,174,"ESD-82","체육","3");
		System.out.println(teacher);
		//teacher.teach(); 타입이 Person이라 teach() 메소드 사용 불가
		//타입 강제변환
		Teacher t = (Teacher)teacher;
		t.teach(); // 타입변환하여 teach() 메소드 사용 가능
		
		if(teacher instanceof Student) {
			Student s = (Student)teacher;
			s.study();
		}else {
			System.out.println("Student 타입이 아닙니다.");
		}
	}
}
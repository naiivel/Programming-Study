package static_test;

class Student{
	static String school; //정적 멤버 : 클래스 자체에 지정되어 있음
	String name;       		//인스턴스 멤버
	int age; 					//인스턴스 멤버
	String grade;			//인스턴스 멤버
}

public class StaticTest {

	public static void main(String[] args) {
		Student stu1 = new Student();
		
		//인스턴스 멤버 값 기입
		stu1.age = 30;
		stu1.grade = "A";
		stu1.name = "한지현";
		//정적멤버 값 기입
		Student.school = "한국기술교육직업전문학교"; 
		
		//Student.age = 10;   = 안됨, 먼저 생성자로 공간을 확보해야 됨.
		System.out.println(stu1.age);
		System.out.println(stu1.grade);
		System.out.println(stu1.name);
		System.out.println(stu1.school);
		
		Student stu2 = new Student();
		stu2.age = 20;
		stu2.grade = "B";
		stu2.name = "안민경";
		System.out.println(stu2.age);
		System.out.println(stu2.grade);
		System.out.println(stu2.name);
		System.out.println(stu2.school); //똑같이 school값이 나온다(한국~~학교)
		
		Student.school = "부산교도소"; // 정적 멤버 값을 바꾸면 전체가 바뀜
		System.out.println(stu1.school);
		System.out.println(stu2.school);
		System.out.println(stu1.school == stu2.school);
		
		Math.random(); 
	}

}
package encapsulation;

public class StudentTest {

	public static void main(String[] args) {
		Student park = new Student();
		park.name = "정대";
		//park.age = 40;
		park.setAge(-29);
		park.setGrade(4);
		System.out.println(park.getAge());
		System.out.println(park.getGrade());
		String parkInfo = park.toString();
		System.out.println(parkInfo);
	}
}
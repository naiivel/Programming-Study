package generic05_wildcard;

public class Course<S> {
	
	private String name; //강좌이름
	private S[] students; //수강생 정보
	
	public Course(String name, int capacity) {
		this.name = name;
		this.students = (S[])new Object[capacity];
	}
	
	public String getName() {
		return name;
	}

	public S[] getStudents() {
		return students;
	}
	
	public void add(S s) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = s;
				break;
			}
		}
	}
}

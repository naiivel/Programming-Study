package c2_set;

public class Member {
	private String name;
	private int age;
	
	// alt + s + a
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode 호출");
		return this.age;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals 호출");
		if(obj instanceof Member) {
			Member m = (Member)obj;
			if(m.name.equals(this.name)) {
				return true;
			}
		}
		return false;
	}







	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
}





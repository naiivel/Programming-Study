package a.object.equals;

public class MemberExample {

	public static void main(String[] args) {
		Member member = new Member("한지현");
		Member member1 = new Member("한지현");
		Member member2 = new Member("고소연");
		System.out.println(member == member1);
		System.out.println(member.equals(member1));
	}
}
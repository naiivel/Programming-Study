package a.object.finalize;

public class Counter {
	private int no;

	public Counter(int no) {
		super();
		this.no = no;
	}
	// alt + s + v
	@Override
	protected void finalize() throws Throwable {
		System.out.println(no + "번째 객체가 finalize() 호출");
	}
}

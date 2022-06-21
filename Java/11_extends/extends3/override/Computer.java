package extends3.override;

public class Computer extends Calculator{
	//alt + s + v = override
	
	@Override
	public double circleArea(double radius) {
		System.out.println("Computer에 존재하는 circleArea");
		return radius*radius*3.141592653589793;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
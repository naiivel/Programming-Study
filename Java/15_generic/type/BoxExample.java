package generic01_type;

public class BoxExample {

	public static void main(String[] args) {
		
		Box box1 = new Box();
		Apple apple = new Apple();
		//box1.obj = apple;  = 접근불가
		box1.setObj(apple);
		
		Box box2 = new Box();
		Orange orange = new Orange();
		box2.setObj(orange);
		
		if(box1.getObj() instanceof Apple) {
			Apple app = (Apple)box1.getObj();
			System.out.println("사과");
		}
		//Apple app = (Apple)box2.getObj();
		
		//showbox
		ShowBox<Apple> box = new ShowBox<Apple>();
		//box.setT(orange);
		box.setT(apple);
		
		Apple apple1 = box.getT();
		
		ShowBox<Orange> orangeBox = new ShowBox<Orange>();
		orangeBox.setT(orange);
		Orange orange1 = orangeBox.getT();
	}
}
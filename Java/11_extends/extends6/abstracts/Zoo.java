package extends6.abstracts;

public class Zoo {
	
	static void animalSound(Animal animal) {
		animal.sound();
		animal.breath();
	}
	
	public static void main(String[] args) {
		//Animal animal = new Animal();  =  Animal은 추상클래스라 객체 생성 안됌
		Dog dog = new Dog();
		dog.breath();
		dog.sound();
		dog.kind = "Jindo";
		
		Cat cat = new Cat();
		cat.breath();
		cat.sound();
		cat.kind = "load";
		
		animalSound(cat);
		animalSound(dog);
		
		Animal navi = new Cat();
		animalSound(navi);
		
		Animal tiger = new Animal() { //익명구현객체 : 클래스가 없기때문에 한번 쓰이고 끝 , 다시 쓰려면 다시 또 만들어야함
			@Override
			public void sound() {
				System.out.println("어흥");
			}
		};
		animalSound(tiger);
	}
}
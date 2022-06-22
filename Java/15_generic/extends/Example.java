package generic04_extends;

public class Example {

	public static void main(String[] args) {
		Parent<String, String> p1 = new Parent<>();
		p1.setKind("TV");
		p1.setModel("skir");
		
		Child<String, String, String> child = new Child<>();
		child.setKind("Car");
		child.setModel("sss");
		child.setCompany("Nen");
		
		System.out.println("====================");
		
		Storage<Integer> storage = new StorageImple<>(10);
		storage.add(200, 0);
		System.out.println(storage.get(0));
		storage.add(300,1);
		System.out.println(storage.get(1));
	}
}
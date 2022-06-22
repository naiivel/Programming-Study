package generic04_extends;

public class StorageImple<E> implements Storage<E>{
	
	private E[] array;
	
	public StorageImple(int capacity) {
		Object[] o = new Object[capacity];
		//this.array = new E[this.capacity];
		this.array = (E[])o;
	}
	
	@Override
	public void add(E item, int index) {
		array[index] = item;
	}
	
	@Override
	public E get(int index) {
		return array[index];
	}
	
}
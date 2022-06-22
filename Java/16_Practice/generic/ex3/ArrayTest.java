package generic.ex3;

import java.util.Arrays;

public class ArrayTest<E> {

	private int capacity; // 저장가능한 배열의 크기
	private int length;    // 배열에 저장된 실제 값의 크기
	private E[] array;      // generic으로 지정된 type의 배열
	
	public ArrayTest() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayTest(int capacity) {
		this.capacity = capacity;
		array = (E[])new Object[capacity];   //(E[]) 으로 타입변환
	}
	
	public void add(E e) {
		if(this.length >= capacity) {
			E[] newArray = (E[])new Object[capacity+1];
			this.capacity = newArray.length;
			for(int i=0; i<this.array.length; i++) {
				newArray[i] = this.array[i];
			}
			newArray[capacity-1] = e;  //새로 생성된 배열 마지막인덱스에 값 추가
			this.array = newArray;
		} else {
			for(int i=0; i<capacity; i++) {
				if(this.array[i] == null) {
					this.array[i] = e;
					break;
				}
			}
		}
		length++;
	}
	
	public void remove(E e) {
		for(int i=0; i<capacity; i++) {
			if(array[i] != null && array[i].equals(e)) {
				E[] newArray = (E[])new Object[capacity-1];
				this.capacity = newArray.length;
				for(int j=0; j<capacity; j++) {
					if(j < i) {
						newArray[j] = this.array[j];
					} else {
						newArray[j] = this.array[j+1];
					}
				} //for문 end
				this.array = newArray;
				length--;
				break;
			}
		}
	}
	
	@Override
	public String toString() {  // ==32번째 줄 값이 주소값으로 안나오고 배열값이 나오도록 함
		return Arrays.toString(this.array);
	}
	
	public int size() {
		return this.length;
	}
	
	public static void main(String[] args) {
		ArrayTest<String> array = new ArrayTest<>(3);
		System.out.println(array);
		System.out.println(array.size());
		
		array.add("김세경");
		System.out.println(array);
		System.out.println(array.size());
		
		array.add("박한나");
		System.out.println(array);
		System.out.println(array.size());
		
		array.add("강혜정");
		System.out.println(array);
		System.out.println(array.size());
		
		array.add("김소명");
		System.out.println(array);
		System.out.println(array.size());
		
		array.add("김세경");
		System.out.println(array);
		System.out.println(array.size());
		
		array.remove("김세경");
		System.out.println(array);
		System.out.println(array.size());
		
		array.remove("김소명");
		System.out.println(array);
		System.out.println(array.size());
	}
}

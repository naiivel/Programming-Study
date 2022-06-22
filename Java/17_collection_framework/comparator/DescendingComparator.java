package c8_comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit> {

	@Override
	public int compare(Fruit o1, Fruit o2) {
		//o1 == 새로 추가되는 값
		//o2 == 기존 값
		//o2 - o1 = 값이 음수일  때 교체, 양수이거나 0 일 때 기존 유지
		//3000 - 3000 = 0;
		//3000 - 1500 = 1500 유지
		//순서 3000, 1500
		//(0 + 1) / 2 = 0
		//3000 - 10000 = -7000
		//순서 10000, 3000, 1500
		System.out.println("compare : " + o2 + "-" + o1);
		return o2.getPrice() - o1.getPrice();
	}
}
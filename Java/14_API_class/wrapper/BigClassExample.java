package d.wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigClassExample {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger("10000000000000000000000000000000000000");
		System.out.println(bi.toString());
		System.out.println(bi.intValue()); // 4byte 크기의 값만 출력
		
		BigInteger bi2 = new BigInteger("1234567890000");
		System.out.println(bi2);
		BigInteger result = new BigInteger("0");
		//더하기
		result = bi.add(bi2);
		System.out.println(result);
		//빼기
		result = bi.subtract(bi2);
		System.out.println(result);
		//곱하기
		result = bi.multiply(bi2);
		System.out.println(result);
		//나누기
		result = bi.divide(bi2);
		System.out.println(result);
		
		double d = 3.141592658940765968977854654212373849673849;
		System.out.println(d);
		
		BigDecimal bd = new BigDecimal("1.0787809706668768096676708768076867808976");
		System.out.println(bd);
		
		BigDecimal bd2 = new BigDecimal("2.303809869679070707");
		System.out.println(bd.multiply(bd2));
		
		Number n = bd2;
		System.out.println(bd2.doubleValue());
	}
}

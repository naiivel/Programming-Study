package g.formatter;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		double num = 1234567.892;
		DecimalFormat df = new DecimalFormat("0");
		String str = df.format(num);
		System.out.println(str);
		
		//1234567.8
		df = new DecimalFormat("0.0");
		str = df.format(num);
		System.out.println(str);
		
		//1234567.849 => 0001234567.892
		df = new DecimalFormat("00000000000.00");
		str = df.format(num);
		System.out.println(num);
		
		df = new DecimalFormat("#.##");
		str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("#,###,###.##");
		str = df.format(num);
		System.out.println(str);
		
		// \u00A4 == 유니코드 원화 표시
		df = new DecimalFormat("\u00A4 #,###원");
		str = df.format(num);
		System.out.println(str);
	}
}
package g.formatter;

import java.text.MessageFormat;

public class MessageFormatExample {

	public static void main(String[] args) {
		String text = "회원 ID : {0}\n회원이름 : {1}\n전화번호 : {2}";
		String result = MessageFormat.format(text, "id001","최기근","01094867166");
		System.out.println(result);
		
		String text2 = "INSERT INTO num,id,phone VALUES({0},{1},{2});";
		Object[] arguments = {1,"최기근","01094867166"};
		String result2 = MessageFormat.format(text2,arguments);
		System.out.println(result2);
	}

}











package c.string.split_tokenizer;

public class StringSplitExample {

	public static void main(String[] args) {
		String text = "원민영&한영경,김미지,한다영-이채진";
		String[] names = text.split("&|,|-");
		for(String s : names) {
			System.out.println(s + " ");
		}
	}
}

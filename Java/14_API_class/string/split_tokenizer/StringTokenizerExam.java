package c.string.split_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExam {

	public static void main(String[] args) {
		String text = "고소연/최다정/카리나/서현진/노혜진";
		StringTokenizer st = new StringTokenizer(text, "/");
		int countTokens = st.countTokens();
		System.out.println(countTokens);
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println("================");
		text = "양승윤|양승연,김가연&하다원\\이진영\"이현아";
		st = new StringTokenizer(text, "|,&\\\"");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
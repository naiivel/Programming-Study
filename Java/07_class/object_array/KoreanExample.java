package g.object_array;

public class KoreanExample {

	public static void main(String[] args) {
		Korean[] koreans = new Korean[3];
		System.out.println(koreans[0]);
		System.out.println(koreans[1]);
		System.out.println(koreans[2]);
		
		Korean k1 = new Korean();
		koreans[0] = k1;
		koreans[0].name = "최기근";
		koreans[0].birth = "820607";
		
		koreans[1] = new Korean();
		koreans[1].name = "한지현";
		koreans[1].birth = "930311";
		
		Korean k2 = new Korean();
		k2.name = "박정대";
		k2.birth = "950627";
		koreans[2] = k2;
		
		for(int i=0; i<koreans.length; i++) {
			System.out.println(koreans[i].name);
			System.out.println(koreans[i].birth);
		}
	}
}
import java.io.File;
import java.io.IOException;

public class Test2_1 {

	public static void main(String[] args) {

		String path = "C:\\Test\\text.txt";
		String dir = "C:\\Test";
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
			System.out.println("디렉토리 생성완료");
		}
		boolean isDirectory = file.isDirectory();
		System.out.println("디렉토리 인가 : " + isDirectory);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			} catch (IOException e) {}
		}
	}
}
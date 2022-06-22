package f01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {
		String dir = "C:/Temp/dir/aaa";
		dir = "C:\\Temp\\dir\\aaa"; //정식 경로
		String fileName = "text.java";
		
		String separator = File.separator;
		System.out.println(separator);
		dir = "C:" + separator + "Temp" + separator + "dir" + separator + "aaa";
		System.out.println(dir);
		
		File file = new File(dir);
		//해당 위치에 폴더나 파일이 존재하면 true
		if(!file.exists()) {
			//디렉토리가 존재하지 않을 때
			System.out.println("디렉토리 존재하지 않음");
			//boolean isMake = file.mkdir(); // 경로에 있는 디렉토리중 마지막에 정의된 디렉토리만 생성
			boolean isMake = file.mkdirs(); //경로 상에 정의된 모든 디렉토리를 생성
			System.out.println("디렉토리 생성 여부 : " + isMake);
		}
		
		file = new File(dir,fileName);
		if(file.exists() == false) {
			System.out.println("파일이 존재하지 않음");
			try {
				//파일생성
				file.createNewFile();
				System.out.println("파일 생성완료");
			} catch (IOException e) {
				System.out.println("파일 생성 실패 : " + e.getMessage());
			}
		}
		
		File file1 = new File("C:\\Temp\\file1.txt");
			if(!file1.exists()) {
				//alt + s + w : 예외처리블럭
				try {
					boolean isMake = file1.createNewFile();
					System.out.println("파일생성여부 : " + isMake);
				} catch (Exception e) {
					System.out.println("파일생성실패 : " + e.getMessage());
				}
			}
		
		String path = file1.getAbsolutePath();
		System.out.println("file1의 절대 경로 : " + path);
		File temp = new File("C:\\Temp");
		File[] temps = temp.listFiles();
		System.out.println(temps.length);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		for(File f : temps) {
			//폴더나 파일의 마지막 수정시간
			long modified = f.lastModified();
			//java.util.Date
			Date date = new Date(modified);
			String lastModified = sdf.format(date);
			System.out.println(lastModified);
			
			//디렉토리면 true아니면 false : 디렉토리가아니면 파일임
			if(f.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t" + f.getName());
			} else {
				System.out.println("\t<File>\t\t\t" + f.getName());
			}
			System.out.println();
		}// for문 종료
		
		//디렉토리 파일 삭제
		File file2 = new File("C:\\Temp\\dir\\aaa\\text.java"); //\\text.java
		boolean isDeleted = false;
		isDeleted = file2.delete();
		System.out.println("파일삭제여부: " + isDeleted);
		
		file2 = new File("C:\\Temp\\dir\\aaa");
		file2.delete();
		System.out.println("디렉토리삭제여부: " + isDeleted);
		
	}// main 종료
}

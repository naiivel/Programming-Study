package c3_map;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.put("key", "value");
		prop.put("score", 10);
		System.out.println(prop.get("score"));
		prop.clear();
		System.out.println(prop.size());
		prop.setProperty("key", "key value"); // setProperty는 매개변수 두 개 전부 String
		String value = prop.getProperty("key");
		System.out.println("value : " + value);
		System.out.println(prop.getProperty("박주신", "박주신 없음"));   // 1번째 매개변수값이 배열에 없으면 2번째 매개변수 값 반환
        
		System.out.println("=========================");
		//경고
		String path = PropertiesExample.class.getResource("db.properties").getPath();
		System.out.println(path);
		
		Properties prop2 = new Properties();
		try {
			prop2.load(new FileReader(path));
			System.out.println(prop2.getProperty("driver"));
			System.out.println(prop2.getProperty("url"));
			System.out.println(prop2.getProperty("username"));
			System.out.println(prop2.getProperty("password"));
			System.out.println(prop2.getProperty("hangul"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
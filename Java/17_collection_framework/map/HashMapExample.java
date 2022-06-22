package c3_map;

import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		         // K           V               K값은 중복 불가, V는 가능 
		Map<String, Integer> map = new HashMap<>();
		map.put("최기근", 100);
		map.put("박주신", 59);
		map.put("김신우", 98);
		map.put("김박사", 88);
		System.out.println(map);
		map.put("박주신", 80);
		System.out.println(map); // 덮어써진다
		
		int score = map.get("최기근");
		System.out.println("최기근 점수 : " + score);
		map.remove("박주신");
		System.out.println(map);
		System.out.println(map.size());
		
		boolean isChecked = map.containsKey("김박사");
		System.out.println("key 존재 : " + isChecked);
		               isChecked = map.containsValue(100);
		System.out.println("value 존재 : " + isChecked);
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			if(entry.getKey().equals("김박사")) {
				iterator.remove();
				//map.remove(entry.getKey());   = 이렇게 직접 접근하면 안대
			}
		}
		System.out.println(map);
		System.out.println("=====================");
		
		Set<String>keySet = map.keySet();
		Iterator<String> keyItr = keySet.iterator();
		while(keyItr.hasNext()) {
			String key = keyItr.next();
			int value = map.get(key);
			System.out.printf("key : %s =  value : %d ", key, value);
		}
		for(String key : keySet) {
			System.out.println("key : " + key);
		}
		
		Collection<Integer> values = map.values();
		for(int value : values) {
			System.out.println(value + ", ");
		}
		System.out.println();
		
		
		
	}
}

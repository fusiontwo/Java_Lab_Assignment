package week11.practice2.source01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import week10.practice2.source01.Word;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Word> map = new HashMap<>();
		map.put("red1", new Word("red1", "빨강색1"));
		map.put("red2", new Word("red2", "빨강색2"));
		map.put("red3", new Word("red3", "빨강색3"));
		map.put("red4", new Word("red4", "빨강색4"));
		map.put("red2", new Word("red4", "빨강색4"));
		
		/* 4 */
		Collection<Word> values = map.values();
		Iterator<Word> iterator = values.iterator();
		while(iterator.hasNext()) {
			Word value = iterator.next();
			System.out.println(value);
		}
	
		
		/* 3 */
//		Set<Entry<String, Word>> entryset = map.entrySet();
//		Iterator<Entry<String, Word>> iterator = entryset.iterator();
//		
//		while(iterator.hasNext()) {
//			Entry<String, Word> entry = iterator.next();
//			String key = entry.getKey();
//			Word value = entry.getValue();
//			System.out.println(key + "=>" + value);
//		}
		
		
		/* 2 */
//		Set<String> keyset = map.keySet();
//		for(String key : keyset) {
//			System.out.println(key + " => " + map.get(key));
//		}
		
		/* 1 */
//		// get
//		Word w = map.get("red3");  // get은 value를 반환
////		Word w = map.get("red8");
//		if (w != null)
//			System.out.println(w);
//		else
//			System.out.println("존재하지 않음");
//		
//		// remove
//		w = map.remove("red3");  // get은 value를 반환
//		if (w != null)
//			System.out.println(w);
//		else
//			System.out.println("존재하지 않음");
//		
//		System.out.println(map);
	}

}

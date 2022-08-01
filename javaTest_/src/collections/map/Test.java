package collections.map;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<> ();
		map.put("love", "사랑하다");
		map.put("hate", "미워하다");
		map.put("same", "똑같다");
		map.put("ssafy", "무조건 취업");
		
		String meaning = map.get("same");
//		System.out.println(meaning);
		
		
		map.put("love", "사랑하다2"); //key는 중복 불가능, 하지만 오류는 발생X(덮어쓴다)
		map.put("equals", "똑같다"); //value는 중복 가능
		
		
		for (String key : map.keySet()) {
			System.out.print(key);
			System.out.println(" " + map.get(key));
		}
		//결과가 같다.즉, 중복을 허용하지 않지만. 오류는 발생하지 않는다 (덮어쓴다)
		
	}

}

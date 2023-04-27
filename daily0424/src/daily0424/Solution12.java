package daily0424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution12 {//문서도난
	public String[] solution(String[] reports, String times){
		String[] answer = {};
		HashMap<String, Integer> sh = new HashMap<>();
		HashMap<String, Integer> ch = new HashMap<>();
		ArrayList<String> name = new ArrayList<>();
		for (String str : reports) {
			String a = str.split(" ")[0]; //john
			int b = Integer.parseInt(str.split(" ")[1].split(":")[0])*60 + Integer.parseInt(str.split(" ")[1].split(":")[1]);
			sh.put(a, b);
		}
		
		//08:33 09:45
		int c = Integer.parseInt(times.split(" ")[0].split(":")[0])*60 + Integer.parseInt(times.split(" ")[0].split(":")[1]);
		int d = Integer.parseInt(times.split(" ")[1].split(":")[0])*60 + Integer.parseInt(times.split(" ")[1].split(":")[1]);
	
		
		for (String key : sh.keySet()) {
			int val = sh.get(key);
			if (val >= c && val <= d) {
				ch.put(key, val);
			}
		}
		ch.entrySet().stream().sorted(HashMap.Entry.comparingByValue()).forEach(entry-> {
			name.add(entry.getKey());
		});
		
		int arrsize = name.size();
		answer = name.toArray(new String[arrsize]);
		 
	    // 변환된 배열 출력
		return answer;
	}

	public static void main(String[] args){
		Solution12 T = new Solution12();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}

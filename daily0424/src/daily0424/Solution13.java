package daily0424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution13 {//경고메일
		public String[] solution(String[] reports, int time){
			String[] answer = {};
			Map<String, Integer> sh = new HashMap<>();
			Map<String, Integer> ch = new HashMap<>();
			ArrayList<String> name = new ArrayList<>();
			for (String str : reports) {
				String a = str.split(" ")[0]; //john
				int b = Integer.parseInt(str.split(" ")[1].split(":")[0])*60 + Integer.parseInt(str.split(" ")[1].split(":")[1]);//시간
				System.out.println(a + "  : " + b);
				if (sh.getOrDefault(a, 0) == 0) {//없으면
					sh.put(a, b);
				}else {//있으면
					System.out.println(a+ " " +(b - sh.get(a)));
					if (ch.getOrDefault(a, 0) != 0) {//있으면
						System.out.println(a+ " " +( - sh.get(a)));
						ch.put(a, b - sh.get(a)); 
					}
				}
			}
			
			for (Map.Entry<String, Integer> entry : ch.entrySet()) {
				String key = entry.getKey();
				Integer val1 = entry.getValue();
				if (val1 > time) {
					name.add(key);
				}
			}
			
			int arrsize = name.size();
			answer = name.toArray(new String[arrsize]);
			
			return answer;
		}

		public static void main(String[] args){
			Solution13 T = new Solution13();
//			System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));	
//			System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
			System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
//			System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
		}
}

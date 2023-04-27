package daily0421;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution9 {//서로 다른 빈도수 만들기
	public int solution(String s){
		int answer = 0;
		
		HashMap<Character, Integer> sh = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();//중복되는 값 없이 숫자가 빠진 값들이 들어가는 Set
		for (char x : s.toCharArray()) {//입력받은 s값을 배열로 만들어서 하나씩 x에 대입
			sh.put(x, sh.getOrDefault(x, 0) + 1); //찾는 key값이 map안에 없으면 리턴값이 0이 되고 
												  //찾는 key값이 map안에 있다면 해당하는 value 값이 리턴 
												  //map에 읽어온 문자를 key로 하고 value를 값으로 해서 넣기
												  //sh => (key : s.charAt() , value : 갯수)
		}
		
		for (char key : sh.keySet()) {//sh에 들어있는 key 값을 전부 가져와서 key에 넣고 하나씩 반복하기
			while (ch.contains(sh.get(key))) {//ch => sh안에 key로 찾은 값이 있는지 검사 => 있다면 true => 반복문 진입
				answer++;//값을 빼는 횟수를 카운팅
				sh.put(key, sh.get(key) -1);//해당하는 key에 대한 value 값을 -1해주고 map에 다시 넣어 업데이트
			}
			if (sh.get(key) == 0) {//키값에 대한 value값이 0이 되면 더이상 갯수를 셀수 없으니 ch에 넣지 않기
				continue;
			}
			ch.add(sh.get(key));//value 값을 넣어주기
		}
		return answer;//뺄셈한 횟수 리턴
	}

	public static void main(String[] args){
		Solution9 T = new Solution9();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}

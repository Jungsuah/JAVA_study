package daily0421;

import java.util.HashMap;

public class Solution7 {
	public int solution(String s){
		HashMap<Character, Integer> sh = new HashMap<>();
		for (char x : s.toCharArray()) {
			sh.put(x, sh.getOrDefault(x, 0) + 1); //찾는 값이 map안에 없으면 무조건 0 + 1
		}
		for (int i = 0; i < s.length(); i++) {
			if (sh.get(s.charAt(i)) == 1){//안에 들어가있는 값이 이미 있어서 1이면 => +1 해줘서 올려주기
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Solution7 T = new Solution7();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}

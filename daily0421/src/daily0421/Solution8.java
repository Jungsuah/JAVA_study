package daily0421;

import java.util.*;
class Solution8 {
	public int[] solution(String s){
		int[] answer = new int[5];
		char[] eng = {'a','b','c','d','e'};
		
		HashMap<Character, Integer> sh = new HashMap<>();
		List<Integer> minus = new ArrayList<>();
		for (char x : s.toCharArray()) {
			sh.put(x, sh.getOrDefault(x, 0) + 1); //찾는 값이 map안에 없으면 무조건 0 + 1
		}
		for (int i = 0; i < eng.length; i++) {
			if (sh.getOrDefault(eng[i], 0) == 0) {
				sh.put(eng[i], 0);
			}
		}
		
		sh.forEach((key, value) -> {
			minus.add(value);
		});	
		int a = Collections.max(minus);
		
		for (int i = 0; i < answer.length; i++) {
			if (a == minus.get(i)) {
				answer[i] = 0;
			}else {
				answer[i] = a - minus.get(i);
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Solution8 T = new Solution8();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}


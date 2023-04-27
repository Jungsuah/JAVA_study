package daily0421;

import java.util.HashMap;

public class Solution7 {
	public int solution(String s){
		HashMap<Character, Integer> sh = new HashMap<>();
		for (char x : s.toCharArray()) {
			sh.put(x, sh.getOrDefault(x, 0) + 1); //ã�� ���� map�ȿ� ������ ������ 0 + 1
		}
		for (int i = 0; i < s.length(); i++) {
			if (sh.get(s.charAt(i)) == 1){//�ȿ� ���ִ� ���� �̹� �־ 1�̸� => +1 ���༭ �÷��ֱ�
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

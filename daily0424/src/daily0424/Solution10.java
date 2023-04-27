package daily0424;

import java.util.HashMap;

public class Solution10 {//음수가 있는 부분수열
	public int solution(int[] nums, int m){
		int answer = 0;
		HashMap<Integer, Integer> hs = new HashMap<>();
		int sum = 0;
		hs.put(0, 1);
		for (int i : nums) {
			sum += i;//읽어온 숫자에 합을 누적
			if (hs.containsKey(sum - m)) {
				answer += hs.get(sum-m);
			}else {
				hs.put(sum, hs.getOrDefault(sum, 0) + 1);
			}
		}
		
		System.out.println(hs.toString());
		return answer;
	}

	public static void main(String[] args){
		Solution10 T = new Solution10();
		System.out.println(T.solution(new int[]{1,2,3,-3,1,2,2,-3}, 5));	
//		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
//		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
//		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
//		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
//		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}





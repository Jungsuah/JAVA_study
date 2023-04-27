package daily0420;

import java.util.ArrayList;

public class Solution4 {
	// 바이토닉 수열 = 수열이 증가했다가 감소하는 수열
	public int solution(int[] nums) {
		int answer = 0;
		ArrayList<Integer> Peaks = new ArrayList<>();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {// 앞숫자보다 크고 뒷숫자보다 작다.
				Peaks.add(i);
			}
		}
		System.out.println(Peaks);

		for (int x : Peaks) {
			int right = x;
			int left = x;
			int cnt = 1;
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
				left--;
				cnt++;
			}
			while (right - 1 >= 0 && nums[right - 1] < nums[right]) {
				right--;
				cnt++;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}

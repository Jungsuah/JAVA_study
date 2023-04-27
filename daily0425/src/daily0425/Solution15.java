package daily0425;

import java.util.Arrays;

public class Solution15 {
	public int solution(int[] nums){//이동 횟수
		//2 5 3 4 2 3 -> 2 2 3 3 4 5 
		//2+5 => 5보다 크다 => else => 5를 한번의 횟수로 생각해서 횟수 증가시키고 오른쪽 인덱스 감소시킨후 왼쪽 인덱스와 다시 더하기

		int answer = 0;
		Arrays.sort(nums); //오름차순 배열로 정렬
		int left = 0;//왼쪽의 시작 인덱스
		int right = nums.length - 1;//오른쪽 시작 인덱스는 길이-1
		while (left <= right) {//두개 비교해서 오른쪽이 무조건 크거나 같으면 반복
			if (nums[left] + nums[right] <= 5) {//두개 인덱스 값 더해서 5이거나 5 이하이면
				answer++;//횟수 증가
				left++;//사용한 왼쪽 인덱스 증가
				right--;//사용한 오른쪽 인덱스 감소
			}else {//두개의 원소의 합이 5보다 크면
				answer++;//횟수 증가
				right--;//오른쪽 인덱스 증가 -> 날려버리기
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Solution15 T = new Solution15();
		System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
		System.out.println(T.solution(new int[]{2, 3, 4, 5}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
	}
}

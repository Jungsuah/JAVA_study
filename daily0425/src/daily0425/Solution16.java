package daily0425;

import java.util.HashSet;

public class Solution16 {//�ִ� ���� ���Ӽ���
	public int solution(int[] nums){
		int answer = 0;
		HashSet<Integer> list = new HashSet<>();
		for (int i : nums) {
			list.add(i);
		}
		System.out.println("list : " + list);
	
		for (int x : list) {
			if (list.contains(x - 1)) {//x���� �ּҰ����� üũ
				continue;// �ּҰ��� �ƴ϶�� continue
			}
			int cnt = 0;
			while (list.contains(x)) {
			cnt++;
			x++;
			}
			answer = Math.max(answer, cnt);//0123 �� 56789���� 5���ΰ� ����ؾ��Ѵ�.
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution16 T = new Solution16();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
//		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
//		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
}

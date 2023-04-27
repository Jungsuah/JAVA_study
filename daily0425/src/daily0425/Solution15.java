package daily0425;

import java.util.Arrays;

public class Solution15 {
	public int solution(int[] nums){//�̵� Ƚ��
		//2 5 3 4 2 3 -> 2 2 3 3 4 5 
		//2+5 => 5���� ũ�� => else => 5�� �ѹ��� Ƚ���� �����ؼ� Ƚ�� ������Ű�� ������ �ε��� ���ҽ�Ų�� ���� �ε����� �ٽ� ���ϱ�

		int answer = 0;
		Arrays.sort(nums); //�������� �迭�� ����
		int left = 0;//������ ���� �ε���
		int right = nums.length - 1;//������ ���� �ε����� ����-1
		while (left <= right) {//�ΰ� ���ؼ� �������� ������ ũ�ų� ������ �ݺ�
			if (nums[left] + nums[right] <= 5) {//�ΰ� �ε��� �� ���ؼ� 5�̰ų� 5 �����̸�
				answer++;//Ƚ�� ����
				left++;//����� ���� �ε��� ����
				right--;//����� ������ �ε��� ����
			}else {//�ΰ��� ������ ���� 5���� ũ��
				answer++;//Ƚ�� ����
				right--;//������ �ε��� ���� -> ����������
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

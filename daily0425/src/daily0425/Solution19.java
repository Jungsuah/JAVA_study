package daily0425;

import java.util.Scanner;

public class Solution19 {//���_�������ϱ�
	static int[] pm, ch, arr;
	static int n, m;
	public void DFS(int L) {
//		if (condition) {
//			
//		}else {
//			for (int i = 0; i < n; i++) {
//				pm[L] = ch
//			}
//		}
	}
		
	public static void main(String[] args){
		Solution19 T = new Solution19();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();//�迭�� ĭ�� ����
		m = kb.nextInt();//���� ���� ����
		arr = new int[n];//���ڰ� ��� �迭 ����
		for(int i = 0; i < n; i ++) {
			arr[i] = kb.nextInt();//�Է¹޴� ���� �迭�� �ϳ��� �ֱ�
		}
		ch = new int[n];//�ߺ��� üũ�� �迭 ����
		pm = new int[m];//�̰� �� ���ڰ� ��� �迭 => 3 6
		T.DFS(0);
	}
}

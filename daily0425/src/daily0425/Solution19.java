package daily0425;

import java.util.Scanner;

public class Solution19 {//재귀_순열구하기
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
		n = kb.nextInt();//배열의 칸수 지정
		m = kb.nextInt();//뽑을 갯수 지정
		arr = new int[n];//숫자가 담길 배열 생성
		for(int i = 0; i < n; i ++) {
			arr[i] = kb.nextInt();//입력받는 값을 배열에 하나씩 넣기
		}
		ch = new int[n];//중복을 체크할 배열 생성
		pm = new int[m];//뽑고 난 숫자가 담길 배열 => 3 6
		T.DFS(0);
	}
}

package daily0421;

import java.util.Arrays;

public class Solution6 {
	public int solution(int[] keypad, String password) {
		int answer = 0;
		
		int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int k = 0;
		int[][] board = new int[10][10];
		for(int i = 0; i < 10; i++) {
			Arrays.fill(board[i], 2);
			if (i == i) {
				board[i][i] = 0;
			}
		}

		
		// 이중for문을 사용하여 board 결과 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++)
		{
			sb = new StringBuilder("");
			sb.append("Array[" + i + "] : ");
			
			for(int j = 0; j < 10; j++)
			{
				sb.append(board[i][j] + " ");
			}
			System.out.println(sb);
		}
		
	
		int[][] pad = new int[3][3];
		for (int i = 0; i < pad.length; i++) {
			for (int j = 0; j < pad.length; j++) {
				pad[i][j] = keypad[i*3 + j];
			}
		}
		// 이중for문을 사용하여 pad 출력
		for(int i = 0; i < 3; i++)
		{
			sb = new StringBuilder("");
			sb.append("pad[" + i + "] : ");
			
			for(int j = 0; j < 3; j++)
			{
				sb.append(pad[i][j] + " ");
			}
			System.out.println(sb);
		}
		
		for (int i = 0; i < pad.length; i++) {
			for (int j = 0; j < pad.length; j++) {
				int from = pad[i][j]; //비밀번호 값
				for (k = 0; k < 8; k++) {//k = 방향
					if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) {
						int to = pad[i + dx[k]][j+dy[k]];
						board[from][to] = 1;
					}
				}
			}
		}
		
		for(int i = 1; i < 10; i++)
		{
			sb = new StringBuilder("");
			sb.append("Array[" + i + "] : ");
			
			for(int j = 1; j < 10; j++)
			{
				sb.append(board[i][j] + " ");
			}
			System.out.println(sb);
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		Solution6 T = new Solution6();
		System.out.println(T.solution(new int[] { 2, 5, 3, 7, 1, 6, 4, 9, 8 }, "7596218"));
//		System.out.println(T.solution(new int[] { 1, 5, 7, 3, 2, 8, 9, 4, 6 }, "63855526592"));
//		System.out.println(T.solution(new int[] { 2, 9, 3, 7, 8, 6, 4, 5, 1 }, "323254677"));
//		System.out.println(T.solution(new int[] { 1, 6, 7, 3, 8, 9, 4, 5, 2 }, "3337772122"));
	}
}
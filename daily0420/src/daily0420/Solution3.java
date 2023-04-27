package daily0420;

import java.util.*;
public class Solution3 {
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		if (k > c*r) {
			return new int[] {0,0};
		}
		int[][] board = new int[c][r]; //6행 5열 배열
		
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int d = 1;
		
		int x = 0; //보드x좌표
		int y = 0; //보드y좌표
		int count = 1;
		
		while (count < k) {
			int nx = x + dx[d]; //1 
			int ny = y + dy[d];	//2
			
			if (nx < 0 || nx >= c || ny < 0 || ny >= r || board[nx][ny] == 1) {//벽이거나 가려는 방향에 사람이 있으면
				d = (d+1) % 4;
				continue;
			}
			
			board[x][y] = count;
			count++; //count => 방향전환시에는 count를 세주면 안된다!
			x = nx;
			y = ny;
			
		}
		answer[0] = x + 1;
		answer[1] = y + 1;
		return answer;
	}

	public static void main(String[] args){
		Solution3 T = new Solution3();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
//		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
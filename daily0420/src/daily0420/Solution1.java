package daily0420;
import java.util.Arrays;

public class Solution1 {
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2]; //i와 j
		int n = board.length; //벽에 닿을때 값
		int x = 0; 
		int y = 0; 
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int d = 1;
		int count = 0;
		
		while (count < k) {
			count++;
			int nx = x + dx[d];  
			int ny = y + dy[d];	
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
				d = (d+1) % 4;
				continue;
			}
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
	}
}

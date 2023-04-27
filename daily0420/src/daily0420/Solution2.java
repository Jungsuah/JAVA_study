package daily0420;

public class Solution2 {

	public int solution(int[][] board) {
		int[] hyun = new int[2]; // [4, 7]
		int[] dog = new int[2];// [7, 5]

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int d = 0;
		int d2 = 0;
		int time = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 2) {
					hyun[0] = i;
					hyun[1] = j;
				}
				if (board[i][j] == 3) {
					dog[0] = i;
					dog[1] = j;
				}
			}
		}

		int hflag = 1;
		int dflag = 1;

		while (time < 10000) {
			time++;
			int hyunx = hyun[0] + dx[d];
			int hyuny = hyun[1] + dy[d];

			int dogx = dog[0] + dx[d2];
			int dogy = dog[1] + dy[d2];

			if (hyunx < 0 || hyunx >= 10 || hyuny < 0 || hyuny >= 10 || board[hyunx][hyuny] == 1) {
				hflag = 0;
				d = (d + 1) % 4;
			} else if (dogx < 0 || dogx >= 10 || dogy < 0 || dogy >= 10 || board[dogx][dogy] == 1) {
				dflag = 0;
				d2 = (d2 + 1) % 4;
			}
			if (hflag == 1) {
				hyun[0] = hyunx;
				hyun[1] = hyuny;
			}
			if (dflag == 1) {
				dog[0] = dogx;
				dog[1] = dogy;
			}

			if (hyunx == dogx && hyuny == dogy) {
				break;
			}
			if (time >= 10000) {
				return 0;
			}
		}
		return time;
	}
	

		public static void main(String[] args){
			Solution2 T = new Solution2();
			int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
				{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
				{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
				{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
				{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
				{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
			System.out.println(T.solution(arr1));
//			int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
//				{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
//				{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
//				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
//				{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
//				{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
//				{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
//				{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
//				{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
//				{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
//			System.out.println(T.solution(arr2));
		}
}

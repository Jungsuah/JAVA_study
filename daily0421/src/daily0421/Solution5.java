package daily0421;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution5 {
		public int solution(int[][] fruit){
			int answer = 0;
			ArrayList<Integer> minlist = new ArrayList<>(); //최솟값 리스트
			ArrayList<Integer> indexlist = new ArrayList<>();//최솟값의 인덱스 리스트
			ArrayList<Boolean> checklist = new ArrayList<>();//최솟값의 인덱스 리스트
				for (int[] is : fruit) {
					int min = Min(is);
					int index = FindIndex(is);
					minlist.add(min);
					indexlist.add(index);
					Boolean cnt = Same(is);
					checklist.add(cnt);
				}
//			System.out.println(minlist);
//			System.out.println(indexlist);
				System.out.println(checklist);
			return answer;
		}
		
		public int Min(int[] is) {
			//{10, 20, 30}
			List<Integer> min = new ArrayList<>();
			for (int i = 0; i < is.length; i++) {
				min.add(is[i]);
			}
			int finalmin = Collections.min(min);
			return finalmin;
		}
		
		public Boolean Same(int[] is) {
			//{10, 20, 10} //1 2 3
			//{10, 10, 10}
			int cnt = 0;
			int min = Min(is);//10
			for (int i = 0; i < is.length; i++) {
				if (is[i] == min) {
					cnt++;
				}
			}
			return cnt == 1;// cnt가 1인지 물어보는 코드 => 만약에 1이면 나 자신만 존재하는 것이라 => 중복 없음 => true
		}
		
		public int FindIndex(int[] is) {
			//{10, 20, 30}
			int index = 0;
			int min = Min(is);//10
			for (int i = 0; i < is.length; i++) {
				if (min == is[i]) {
					index = i;
				}
			}
			return index;
		}

		public static void main(String[] args){
			Solution5 T = new Solution5();
			System.out.println(T.solution(new int[][]{{10, 10, 10}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
//			System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
//			System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
//			System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
		}
}

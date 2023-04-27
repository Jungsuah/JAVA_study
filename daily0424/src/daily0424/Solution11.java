package daily0424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class Solution11 {//회장선거
	public String solution(String[] votes, int k){
		String answer = " ";
		HashMap<String, String> name = new HashMap<>();
		List<String> candidate = new ArrayList<>();
		for (String string : votes) {
			String[] arr = string.split(" ");
			System.out.println(Arrays.toString(arr));
			name.put(arr[0], arr[1]);
			candidate.add(arr[1]);
		}
		
		System.out.println(candidate);
	
		
		
		return answer;
	}

	public static void main(String[] args){
		Solution11 T = new Solution11();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
//		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
//		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
//		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}

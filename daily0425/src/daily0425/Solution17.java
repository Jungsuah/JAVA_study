package daily0425;

import java.util.Stack;

public class Solution17 {//겹쳐진 압축 해제
	public String solution(String s){
		String answer = "";
		Stack<String> stack = new Stack<>();
		for (char x : s.toCharArray()) {
			String tmp = "";
			if (x == ')') {
				while (!stack.empty()) {
		            String element = stack.pop();
		            System.out.println(element);
		        }
				break;
			}else {
				stack.push(String.valueOf(x));
			}
		}
		
		 
		
		return answer;
	}

	public static void main(String[] args){
		Solution17 T = new Solution17();
		System.out.println(T.solution("3(a2(b))ef"));
//		System.out.println(T.solution("2(ab)k3(bc)"));
//		System.out.println(T.solution("2(ab3((cd)))"));
//		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
//		System.out.println(T.solution("3(ab2(sg))"));
	}
}

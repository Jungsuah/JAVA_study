package daily0421;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution9 {//���� �ٸ� �󵵼� �����
	public int solution(String s){
		int answer = 0;
		
		HashMap<Character, Integer> sh = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();//�ߺ��Ǵ� �� ���� ���ڰ� ���� ������ ���� Set
		for (char x : s.toCharArray()) {//�Է¹��� s���� �迭�� ���� �ϳ��� x�� ����
			sh.put(x, sh.getOrDefault(x, 0) + 1); //ã�� key���� map�ȿ� ������ ���ϰ��� 0�� �ǰ� 
												  //ã�� key���� map�ȿ� �ִٸ� �ش��ϴ� value ���� ���� 
												  //map�� �о�� ���ڸ� key�� �ϰ� value�� ������ �ؼ� �ֱ�
												  //sh => (key : s.charAt() , value : ����)
		}
		
		for (char key : sh.keySet()) {//sh�� ����ִ� key ���� ���� �����ͼ� key�� �ְ� �ϳ��� �ݺ��ϱ�
			while (ch.contains(sh.get(key))) {//ch => sh�ȿ� key�� ã�� ���� �ִ��� �˻� => �ִٸ� true => �ݺ��� ����
				answer++;//���� ���� Ƚ���� ī����
				sh.put(key, sh.get(key) -1);//�ش��ϴ� key�� ���� value ���� -1���ְ� map�� �ٽ� �־� ������Ʈ
			}
			if (sh.get(key) == 0) {//Ű���� ���� value���� 0�� �Ǹ� ���̻� ������ ���� ������ ch�� ���� �ʱ�
				continue;
			}
			ch.add(sh.get(key));//value ���� �־��ֱ�
		}
		return answer;//������ Ƚ�� ����
	}

	public static void main(String[] args){
		Solution9 T = new Solution9();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}

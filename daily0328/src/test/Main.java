package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main implements Operation {
	public static void main(String[] args) {
		Main main = new Main();
		String quest= " ";
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("臾몄옄瑜� �엯�젰:");
			quest = sc.nextLine();
			
			if (quest.contains("bye")) {
				System.out.println("�룷�븿�릪");
				break;
			}
			
			String answer = main.chat(quest);
			main.writeFile(answer);
			
		}
		
	}


//	�떎�쓬 而댄벂�꽣���쓽 梨꾪똿 �봽濡쒓렇�옩�쓣 �옉�꽦�븯�꽭�슂
//	1. Operation�씠�씪�뒗 �씠由꾩쑝濡� �씤�꽣�럹�씠�뒪 �깮�꽦[1�젏]o
//2. �쐞 �씤�꽣�럹�씠�뒪�뿉�꽌 �씤�옄�� 由ы꽩 �뜲�씠�꽣 ���엯�쓣 String�쑝濡� �븯�뒗 chat() �븿�닔�� �씤�옄�뒗 String�씠硫� 由ы꽩媛믪씠 �뾾�뒗 writeFile() �븿�닔 �꽑�뼵[1�젏]o
//3. �쐞 �씤�꽣�럹�씠�뒪瑜� 援ы쁽�븷 Main �겢�옒�뒪 �깮�꽦 �썑 unimplemented methods瑜� 紐⑤몢 override �븿[1�젏]o
//	4. main() �븿�닔�뿉�꽌�뒗 �궗�슜�옄�쓽 �엯�젰媛믪씠 "bye"媛� �룷�븿�맂 臾몄옄�뿴�씠 �엯�젰�릺湲� �쟾源뚯��뒗 臾댄븳�엳 �떎�뻾�릺�뒗 諛섎났臾몄쓣 �닔�뻾�븿[2�젏]o
//	5. �쐞 諛섎났臾몄뿉�꽌�뒗 
//	�궗�슜�옄濡쒕��꽣 諛쏆� �엯�젰媛믪쓣 chat()�쓽 �씤�옄濡� �꽆湲곌퀬 chat()濡쒕��꽣 諛쏆� 諛섑솚媛믪� writeFile()�쓽 �씤�옄濡� �꽆源�[2�젏]o
//	6. chat() �븿�닔 �궡遺��뿉�뒗 String�삎 ArrayList媛� question怨� answer濡� �꽑�뼵�릺�뼱 �븘�옒�쓽 �뜲�씠�꽣媛� 珥덇린�솕 �릺�뼱�엳�쓬[2�젏]o
//	question�뿉�뒗 "happy", "hello", "old", "name", "bye"
//	answer�뿉�뒗 "it's dope, man", "hey ya", "take a guess", "it's confidential", "see ya"
	
//	7. question怨� answer�뒗 媛숈� �씤�뜳�뒪�겮由� 留ㅼ묶�릺硫� question�쓽 臾멸뎄媛� �룷�븿�릺�뿀�떎硫� 媛숈� �씤�뜳�뒪�쓽 answer瑜� return �븿[2�젏].o
//	�삁) 
//	hello bro!
//	hey ya
//	8. �븘臾� 議곌굔�룄 留뚯”�떆�궎吏� �븡�뒗 臾멸뎄硫� "lol"�쓣 由ы꽩�븿[1�젏]o
//	9. writeFile() �븿�닔�쓽 �씤�옄濡� "吏덈Ц","�쓳�떟"�쓽 �삎�깭濡� �꽆湲곌퀬 諛뷀깢�솕硫댁뿉 chat_history.csv �뙆�씪�쓣 �깮�꽦�븿(吏덈Ц怨� �쓳�떟�� �뼱�뼚�븳 媛믪씠 ���룄 ���쓣 �븳 媛쒖뵫 李⑥��빐�빞 �븯硫� �뙆�씪�뿉 怨꾩냽 �씠�뼱�뜥�졇�빞�븿)[3�젏]

	@Override
	public String chat(String quest) {
		ArrayList<String> question = new ArrayList<>(Arrays.asList("happy", "hello", "old", "name", "bye"));
		ArrayList<String> answer = new ArrayList<>(Arrays.asList("it's dope, man", "hey ya", "take a guess", "it's confidential", "see ya"));
		
		String ans = " ";
		for (int i = 0; i < question.size(); i++) {
			if (question.get(i).contains(quest)) {
				ans += answer.get(i);
			}
		}
		return ans;
	}


	@Override
	public void writeFile(String str) {
		
	}

}

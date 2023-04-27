package daily0329;

import java.util.Scanner;
import java.util.Stack;

//�궗�슜�옄媛� �씪�젴�쓽 �닽�옄瑜� �엯�젰�븯怨� �뒪�깮�뿉 �븷�떦
//�궗�슜�옄媛� �씪�젴�쓽 �닽�옄�뿉�꽌 �닽�옄瑜� �엯�젰�뻽�뒿�땲�떎.
//異쒕젰 �닚�꽌��濡� �닽�옄 異쒕젰
//�삁�쇅臾� 異붽�

public class A2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("�닽�옄 �엯�젰 : ");
			String number = sc.nextLine();
			String[] splitArray = number.split(" "); // 臾몄옄濡� 諛쏆븘�꽌 怨듬갚 湲곗��쑝濡� �굹�닠�꽌 ���옣
			Stack<Integer> stack = new Stack<>(); // �닽�옄瑜� ���옣�븷 �뒪�깮
			for (int i = 0; i < splitArray.length; i++) {
				stack.push(Integer.parseInt(splitArray[i]));
			}
			System.out.print("�깘�깋 �닽�옄 �엯�젰 : ");
			int number1 = Integer.parseInt(sc.nextLine());
			try {
				int cnt = 0;
				for (int i = 0; i <= stack.size(); i++) {
					cnt = stack.search(number1);
				}
				if (cnt == -1) {// stack�� search濡� 李얜뒗 媛믪씠 �뾾�쓣寃쎌슦 => -1 諛섑솚
					throw new Exception();
				} else {
					System.out.println(cnt);
				}
			} catch (Exception e) {
				System.out.println("stack�뿉 李얜뒗 �닽�옄媛� �뾾�뒿�땲�떎.");
				break;
			}
		}
	}
}

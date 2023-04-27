package daily0329;
//�궗�슜�옄媛� 臾몄옄�뿴怨� 臾몄옄瑜� �엯�젰�빀�땲�떎.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//臾몄옄�뿴�뿉�꽌 臾몄옄瑜� 李얠븘 媛��옣 癒쇱� 李얠� �닚�꽌 �몴�떆(���냼臾몄옄 援щ텇)
//�삁�쇅臾� 異붽�

//[Example]
//South Korea has a earned a reputation as a leading global ICT center
//s
//15
//
//South Korea has a earned a reputation as a leading global ICT center
//S
//1

public class A4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("臾몄옣 �엯�젰 : ");
				String line = sc.nextLine();

				System.out.print("李얠쓣 臾몄옄 �엯�젰 : ");
				String word = sc.nextLine();
				List<Integer> index = new ArrayList<Integer>();
				int cnt = 0;
				for (int i = 0; i < word.length(); i++) {
					for (int h = 0; h < line.length(); h++) {
						if (word.charAt(i) == line.charAt(h)) {
							index.add(h + 1);
							cnt++;
						}
					}
				}

				if (cnt == 0) {
					throw new Exception();
				}

				System.out.println("媛��옣 癒쇱� " + index.get(0) + "踰덉㎏ �쐞移�");

			} catch (Exception e) {
				System.out.println("臾몄옣�냽�뿉 李얘퀬�옄 �븯�뒗 �떒�뼱媛� �뾾�뒿�땲�떎.");
				System.out.println();
			}
		}
	}
}

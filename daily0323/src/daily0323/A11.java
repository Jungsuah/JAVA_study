package daily0323;
import java.util.Scanner;
public class A11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		dice(N, M, "");
	}

	public static void dice(int N, int M, String result) {
		// 二쇱궗�쐞瑜� N踰� �뜕議뚯쓣 �븣, �빀�씠 M�씠 �릺�뒗 寃쎌슦瑜� 異쒕젰�븯�뒗 �븿�닔
		if (N == 0 && M == 0) {
			System.out.println(result.trim());
		} else if (N > 0 && M >= N && M <= 6 * N) {
			// 二쇱궗�쐞瑜� �뜑 �뜕吏� �닔 �엳怨�, �빀�씠 媛��뒫�븳 踰붿쐞 �궡�뿉 �엳�뒗 寃쎌슦
			for (int i = 1; i <= 6; i++) {
				dice(N - 1, M - i, result + " " + i);
			}
		}
	}
}

package daily0322_ppt4;

import java.util.Scanner;

public class A1 {

//		사용자가 숫자 N과 M을 입력합니다.
//		N개의 주사위를 던졌을 때 합이 M인 경우를 모두 출력
//		2 -> 2개의 주사위 n
//		6 -> 합이 6인 경우 m
//		(1, 5) - i / j = 6-i (for문)
//		(2, 4)
//		(3, 3)
//		(4, 2)
//		(5, 1)

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//
//		dice(N, M, "");
//	}
//
//	public static void dice(int N, int M, String result) {
//		// 주사위를 N번 던졌을 때, 합이 M이 되는 경우를 출력하는 함수
//		if (N == 0 && M == 0) {
//			System.out.print("(");
//			System.out.print(result.trim());
//			System.out.println(")");
//		} else if (N > 0 && M >= N && M <= 6 * N) {
//			// 주사위를 더 던질 수 있고, 합이 가능한 범위 내에 있는 경우
//			for (int i = 1; i <= 6; i++) {
//				dice(N - 1, M - i, result + " " + i);
//			}
//		}
//	}
	
	
	
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 주사위 개수
		int m = sc.nextInt(); // 주사위 합

		rollDice(n, m, ""); // rollDice(남은 주사위의 개수, 남은 주사위의 합, 여태 나온 주사위의 값) => 제로섬 게임
	}

	// 주사위를 n번 던져서 합이 sum이 되는 경우의 수를 출력하는 함수
	public static void rollDice(int n, int sum, String result) {
//         if (n == 0) { // 주사위를 n번 던졌을 때
//             if (sum == 0) { // 합이 sum이 되는 경우
//                 System.out.println(result);
//             }
//         } else { // 주사위를 더 던질 필요가 있을 때
//             for (int i = 1; i <= 6; i++) {
//                 rollDice(n-1, sum-i, result + i + " ");
//             }
//         }

		// 해석하기 쉽게 직관적으로
		if (n > 0) { // 주사위를 더 던질 필요가 있을 때
			for (int i = 1; i <= 6; i++) { // 주사위 사용
				rollDice(n - 1, sum - i, result + i + " "); // 문자열과 숫자를 더하면, 숫자가 문자열로 변환되어 문자열과 결합됩
			}
		} else { // 주사위 다 사용했을 때
			if (sum == 0) { // 합이 sum이 되는 경우
				System.out.println(result);
			}
		}
	}
}

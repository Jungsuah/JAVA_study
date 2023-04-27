package daily0403;

public class ppt3_3 {
	public static void main(String[] args) {
		int kopo_27_ii = 12345; // 12345를 정수형 변수에 대입
		int kopo_27_j = (kopo_27_ii / 10) * 10; // 12340을 kopo_27_j에 대입
		System.out.printf(" #4-1 : %d\n", kopo_27_j);// printf로 변수 출력

		kopo_27_ii = 12345; // 12345를 정수형 변수에 대입
		kopo_27_j = ((kopo_27_ii + 5) / 10) * 10;// 12350을 kopo_27_j에 대입
		System.out.printf(" #4-2 : %d\n", kopo_27_j);// printf로 변수 출력

		kopo_27_ii = 12344; // 12344를 정수형 변수에 대입
		kopo_27_j = ((kopo_27_ii + 5) / 10) * 10;// 12340을 kopo_27_j에 대입
		System.out.printf(" #4-3 : %d\n", kopo_27_j);// printf로 변수 출력

		// # 4-4. 100원 이하 버림
		kopo_27_ii = 12345; // 12344를 정수형 변수에 대입
		kopo_27_j = (kopo_27_ii / 100) * 100;// 123 * 100한 값을 대입 -> 100이하 자리 버림
		System.out.printf(" #4-4 : %d\n", kopo_27_j);// printf로 변수 출력

		// # 4-5. 100원 이하 올림
		kopo_27_ii = 12345; // 12344를 정수형 변수에 대입
		kopo_27_j = ((kopo_27_ii + 5) / 100) * 100;// 123 * 100한 값을 대입 -> 100이하 자리 버림
		System.out.printf(" #4-5 : %d\n", kopo_27_j);// printf로 변수 출력

		// # 4-6. 1000이하 버림 구현하라.
		kopo_27_ii = 12344; // 12344를 정수형 변수에 대입
		kopo_27_j = (kopo_27_ii / 1000) * 1000;// 12 * 1000한 값을 대입 -> 1000이하 자리 버림
		System.out.printf(" #4-6 : %d\n", kopo_27_j);// printf로 변수 출력

		// # 4-7. 1000이하 반올림을 구현하라.
		kopo_27_ii = 12344; // 12344를 정수형 변수에 대입
		kopo_27_j = ((kopo_27_ii + 5) / 1000) * 1000;// 12 * 1000한 값을 대입 -> 1000이하 자리 버림
		System.out.printf(" #4-7 : %d\n", kopo_27_j);// printf로 변수 출력
	}
}

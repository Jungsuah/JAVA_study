package daily0405;

public class ppt5_1 {
	public static void main(String[] args) {
		for (int k27_dan = 1; k27_dan <= 9; k27_dan += 3) {// k27_dan은 1-9까지 증가 -> 한번 큰 포문을 돌때마다 3단씩 증가
			System.out.printf("************\t************\t************\n");// 줄넘김
			System.out.printf(" 구구단 %d 단  \t 구구단 %d 단 \t 구구단 %d 단\t\n", k27_dan, k27_dan + 1, k27_dan + 2);// 1 2 3 단 출력
			System.out.printf("************\t************\t************\n");// 줄넘김
			for (int k27_i = 1; k27_i <= 9; k27_i++) {// j는 1-9까지 출력 -> 3단씩 출력 -> 1 * 1 = 1 2 * 1 = 2 3 * 1 = 3
				System.out.printf(k27_dan + " * " + k27_i + " = " + (k27_dan * k27_i));
				System.out.printf("\t ");// 4칸 띄우기
				System.out.printf(k27_dan + 1 + " * " + k27_i + " = " + (k27_dan + 1) * k27_i);
				System.out.printf("\t ");// 4칸 띄우기
				System.out.printf(k27_dan + 2 + " * " + k27_i + " = " + (k27_dan + 2) * k27_i);
				System.out.printf("\t ");// 4칸 띄우기
				System.out.println();
				;// 3단 다 출력하면 줄넘김
			}
		}
	}
}

package daily0405;

public class ppt5_2 {
	public static void main(String[] args) {
		for (int k27_dan = 1; k27_dan <= 3; k27_dan++) {//k27_dan은 3까지 증가 -> 총 3번 반복 돌기 -> +1되면 i는 2가 되어 2 5 8 단 출력
			System.out.printf("************\t************\t************\n");// 줄넘김
			System.out.printf(" 구구단 %d 단  \t 구구단 %d 단 \t 구구단 %d 단\t\n",k27_dan,k27_dan+3,k27_dan+6);
			System.out.printf("************\t************\t************\n");// 줄넘김
			for (int k27_i = 1; k27_i <= 9; k27_i++) {//j는 1-9까지 출력 ->i는 3씩 증가하니까 -> 1 * 1 = 1	 4 * 1 = 4	 7 * 1 = 7
				System.out.printf(k27_dan + " * " + k27_i + " = " + (k27_dan * k27_i));//1단
				System.out.printf("\t ");//4칸 띄우기
				System.out.printf(k27_dan+3 + " * " + k27_i + " = " + (k27_dan+3) * k27_i) ;//4단
				System.out.printf("\t ");//4칸 띄우기
				System.out.printf(k27_dan+6 + " * " + k27_i + " = " + (k27_dan+6) * k27_i);//7단
				System.out.printf("\t ");//4칸 띄우기
				System.out.println();//줄넘김
			}
		}
	}
}

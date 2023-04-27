package daily0404;

public class calendar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1부터 12까지 반복해라
			System.out.printf(" %d 월 => ", k27_i);
			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1부터31까지 반복해라

				System.out.printf("%d,", k27_j - 1);
				
				//둘다 만족해야 하기 때문에 &&을 쓴다.
				if (k27_i == 1 && k27_j == 31) {// 1월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 2 && k27_j == 28) {// 2월달이고 28일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 3 && k27_j == 31) {// 3월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 4 && k27_j == 30) {// 4월달이고 30일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 5 && k27_j == 31) {// 5월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 6 && k27_j == 30) {// 6월달이고 30일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 7 && k27_j == 31) {// 7월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 8 && k27_j == 31) {// 8월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 9 && k27_j == 30) {// 9월달이고 30일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 10 && k27_j == 31) {// 10월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 11 && k27_j == 30) {// 11월달이고 30일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
				if (k27_i == 12 && k27_j == 31) {// 12월달이고 31일일 때
					System.out.printf("%d.", k27_j);//출력
					break;
				}
			}
			System.out.printf("\n");
		}

	}

}

package daily0404;

public class for1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(1);//출력
		System.out.println(2);//출력
		System.out.println(3);//출력
		System.out.println(4);//출력
		System.out.println(5);//출력

		for (int k27_i = 1; k27_i <= 5; k27_i++) {//1부터 5까지 반복해라
			System.out.println(k27_i);
		}

		int k27_i = 1;//변수 선언
		while (k27_i < 5) {//i가 5보다 작을 때까지 반복해라
			System.out.println(k27_i);
			k27_i++;

		}

		k27_i = 1;//변수 선언
		do {
			k27_i++;
			System.out.println(k27_i);//일단 실행하고
		} while (k27_i < 5);//i가 5보다 작을 때까지 실행

	}

}

package daily0404;

public class star1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_iA, k27_iB;// 변수 선언

		k27_iA = 0;// 줄을 나타내는 변수로 여기서 초기화를 해야 밑에서 ++된 A가 while문을 탈 때
					// 초기화되지 않는다.

		while (true) {// 반복
			k27_iB = 0;// 별의 개수를 찍어내기 위해서 초기화해준다.
			while (true) {// 반복
				System.out.printf("★");

				if (k27_iA == k27_iB)// 만약 k27_iA와 k27_iB가 같으면 나가라
					break;
				k27_iB++;// +1

			}
			System.out.printf("\n");// 한 줄 띄기
			k27_iA++;// +1
			if (k27_iA == 30)// 만약k27_iA와 30이같으면 (30줄째)나가라
				break;
		}

	}

}

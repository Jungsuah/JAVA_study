package daily0403;

public class ppt3_5_Taxcalc {
	public static void main(String[] args) {
		int kopo_27_val = 271; // 세전 물건값
		int kopo_27_rate = 3; // 세금 3퍼센트

		// 우리나라 = 세금을 포함한 소비자가격 기입
		// 일본 = 세전가격을 소비자가로 기입
		// ex) 편의점 100엔 -> 112엔을 내야한다.

		int kopo_27_tax = taxcal(kopo_27_val, kopo_27_rate);//세전금액과 세금퍼센트를 인자로 갖고 세금이 포함된 가격을 계산하는 메소드 생성

		System.out.printf("**********************************\n");
		System.out.printf("*         단순 세금 계산         *\n");
		System.out.printf("실제 세금 계산 : %f\n", kopo_27_val * kopo_27_rate / 100.0);//세금 계산은 double로 계산해서 소수점까지 버리지 말기
		System.out.printf("세전가격 : %d 세금 : %d 세포함가격 : %d\n ", kopo_27_val, kopo_27_tax, kopo_27_val + kopo_27_tax);

	}

	private static int taxcal(int kopo_27_val, int kopo_27_rate) {//세전금액과 세금퍼센트를 인자로 갖고 세금이 포함된 가격을 계산하는 메소드
		int kopo_27_ret;// 반환하는 변수 선언

		//만약 소수점을 버리지 않고 계산했을때 값이 소수점을 버리는 계산을 했을때 값과 같다면 -> 그대로 소수점 버리는 계산 진행
		if ((double) kopo_27_val * (double) kopo_27_rate / 100.0 == kopo_27_val * kopo_27_rate / 100) {
			kopo_27_ret = kopo_27_val * kopo_27_rate / 100;
		} else { // 그렇지 않다면 + 1을 더해줌으로서 버려지는 소수점에 대한 값을 챙겨준다
			kopo_27_ret = kopo_27_val * kopo_27_rate / 100 + 1;
		}
		return kopo_27_ret;//연산된 값을 함수를 호출한 곳을 보내준다
	}
}

package daily0403;

public class ppt3_6_MyTest {

	// 상품가격과 세율을 인자로 가지고 세전가격을 계산하는 메소드
	private static int kopo_27_netprice(int kopo_27_price, double kopo_27_tax_rate) {
		return (int) (kopo_27_price / (1 + kopo_27_tax_rate));
	}

	public static void main(String[] args) {
		int kopo_27_price = 1234; // 상품가격
		double kopo_27_tax_rate = 0.1;// 세율

		// 세전가격을 계산하는 메소드 호출하여 연산된 값을 kopo_27_netprice에 대입
		int kopo_27_netprice = kopo_27_netprice(kopo_27_price, kopo_27_tax_rate);
		// 세금 = 상품가격 - 세전가격
		int kopo_27_tax = kopo_27_price - kopo_27_netprice;

		System.out.printf("************************************************\n");
		System.out.printf("*         소비자가, 세전가격, 세금 계산        *\n");
		System.out.printf("소비자가 : %d 세전가격 : %d 세금 : %d\n ", kopo_27_price, kopo_27_netprice, kopo_27_tax);
	}
}

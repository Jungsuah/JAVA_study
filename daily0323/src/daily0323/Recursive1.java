package daily0323;

public class Recursive1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i<=10;i++) {
			System.out.println(sumToOne(i));
		}
	}
	public static int sumToOne(int number) {
		if(number == 1) {
			return 1;
		}else {
			return number + sumToOne(--number);		}
			
	}

}

package daily0328;

public class trycatch1 {

	public static void main(String[] args) {
		int[] numbers = {5,10,12};
		System.out.println(1);
		try {
			System.out.println(numbers[2]);
		}catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
			
		}finally {
			System.out.println("finally");
		}
		System.out.println(9);

	}

}

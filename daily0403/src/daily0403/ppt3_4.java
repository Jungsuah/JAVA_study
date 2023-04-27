package daily0403;

public class ppt3_4 {
	public static void main(String[] args) {
		int kopo_27_MyVal = 14 / 5; 
		System.out.printf(" #5-1 : %d\n", kopo_27_MyVal);

		double kopo_27_MyValF; 
		kopo_27_MyValF = 14 / 5; 
		System.out.printf(" #5-2 : %f\n", kopo_27_MyValF);

		
		kopo_27_MyValF = 14.0 / 5; 
		System.out.printf(" #5-3 : %f\n", kopo_27_MyValF);

		kopo_27_MyValF = 14.0 / 5 + 0.5; 
		System.out.printf(" #5-4 : %f\n", kopo_27_MyValF);

		kopo_27_MyVal = (int) ((14.0) / 5 + 0.5); 
		System.out.printf(" #5-5 : %d\n", kopo_27_MyVal);
	}
}

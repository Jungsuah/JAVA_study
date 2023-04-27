package daily0403;

public class ppt3_1 {
	public static void main(String[] args) {

		
		int kopo_27_sum; 

		kopo_27_sum = 0;

		
		for (int i = 1; i < 101; i++) {
			kopo_27_sum = kopo_27_sum + 1; 
		}

		System.out.printf(" #2 : %d\n", kopo_27_sum);

		System.out.printf(" #2-2 : %d\n", kopo_27_sum / 100);

		int[] kopo_27_v = { 1, 2, 3, 4, 5 };
		int kopo_27_vSum;
		kopo_27_vSum = 0;

		
		for (int i = 0; i < 5; i++) {
			kopo_27_vSum = kopo_27_vSum + kopo_27_v[i];
		}
		System.out.printf(" #2-3 : %d\n", kopo_27_vSum);
	}
}

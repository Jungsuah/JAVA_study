package daily0621_IQR;

import java.util.Arrays;

public class P1 {
	public static void main(String[] args) {
		//int[] numbers = { 170, 160, 180, 172, 178, 183, 186, 210, 135, 172 };
		int[] numbers = { 1, 2, 5, 6, 7, 9, 12, 15, 18, 19, 27 };
		Arrays.sort(numbers);

		double q1 = percentile(numbers, 25);
		double q2 = percentile(numbers, 50);
		double q3 = percentile(numbers, 75);
		double iqr = q3 - q1;
		double min = q1 - 1.5 * iqr;
		double max = q3 + 1.5 * iqr;

		System.out.println("Q1: " + q1);
		System.out.println("Q2: " + q2);
		System.out.println("Q3: " + q3);
		System.out.println("IQR: " + iqr);
		System.out.println("Minimum: " + min);
		System.out.println("Maximum: " + max);
	}

	private static double percentile(int[] array, double percentile) {
		int n = array.length;
		double index = (percentile / 100.0) * (n - 1); // 백분위수에 해당하는 인덱스 계산
		int floor = (int) Math.floor(index); // 내림하여 하한값 인덱스 계산
		int ceil = (int) Math.ceil(index); // 올림하여 상한값 인덱스 계산

		if (floor == ceil) {
			return array[floor]; // 하한값과 상한값이 같으면 해당 인덱스의 요소 반환
		}

		double lowerValue = array[floor]; // 하한값의 요소
		double upperValue = array[ceil]; // 상한값의 요소
		
		// 하한값과 상한값 사이에 비례하여 값 보기
		return lowerValue + (index - floor) * (upperValue - lowerValue);
	}
}

package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_3 {
// 파일 정제....
	public static void main(String[] args) throws IOException {
// W은 특수문자이므로 WW두개를 써야한다.
		File k27_f = new File("C:\\test\\day_data\\2015MaxMin.csv");
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		File k27_f1 = new File("C:\\test\\day_data\\final.csv");
		BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
		String k27_readtxt;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int maxLine = 0;
		int minLine = 0;
		while ((k27_readtxt = k27_br.readLine()) != null) {

			String[] k27_field = k27_readtxt.split(",");

			if (Integer.parseInt(k27_field[3]) < min) {
				minLine = Integer.parseInt(k27_field[3]);
			} else if (Integer.parseInt(k27_field[3]) > max) {
				maxLine = Integer.parseInt(k27_field[3]);
			}

			max = Math.max(max, Integer.parseInt(k27_field[3]));
			min = Math.min(min, Integer.parseInt(k27_field[3]));

		}
		k27_bw1.write(maxLine);
		k27_bw1.newLine();
		k27_bw1.write(minLine);
		k27_br.close();
		k27_bw1.close();

		System.out.println("최대값 : " + max + " 최소값 : " + min);
	}
}

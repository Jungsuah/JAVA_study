package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_1 {
// 파일 정제....
	public static void main(String[] args) throws IOException {
// W은 특수문자이므로 WW두개를 써야한다.
		File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		File k27_f1 = new File("C:\\test\\day_data\\A005930.csv");
		BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
		String k27_readtxt;
		int k27_cnt = 0;
		int k27_wcnt = 0;

		while ((k27_readtxt = k27_br.readLine()) != null) {
			StringBuffer k27_s = new StringBuffer();
			String[] k27_field = k27_readtxt.split("%_%");

			if (k27_field.length > 2 && k27_field[2].replace("^", "").trim().substring(0, 7).contains("A005930")) {
				k27_s.append(k27_field[0].replace("^", "").trim());

				for (int j = 1; j < k27_field.length; j++) {
					k27_s.append("," + k27_field[j].replace("^", "").trim());
				}
				k27_bw1.write(k27_s.toString());
				k27_bw1.newLine();
				k27_wcnt++;
				System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
			}
			k27_cnt++;
		}
		k27_br.close();
		k27_bw1.close();

		System.out.printf("Program End [%d] [%d] records\n", k27_cnt, k27_wcnt);
	}
}

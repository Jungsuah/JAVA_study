package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class L07 {
	public static void main(String[] args) throws IOException {
		File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		String k27_readtxt;
		int k27_LineCnt = 0;
		int k27_n = -1;
		StringBuffer k27_s = new StringBuffer();
		while (true) {
			char[] k27_ch = new char[1000];
			k27_n = k27_br.read(k27_ch);
			if (k27_n == -1) {
				break;
			}
			for (char k27_c : k27_ch) {
				if (k27_c == '\n') {
					System.out.printf("[%s]***\n", k27_s.toString());
					k27_s.delete(0, k27_s.length());
				} else {
					k27_s.append(k27_c);
				}
			}
			k27_LineCnt++;
		}
		System.out.printf("[%s]***\n", k27_s.toString());
		k27_br.close();
	}
}

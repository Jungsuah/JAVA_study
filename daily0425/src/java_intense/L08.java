package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08 {
// 파일 정제....
	public static void main(String[] args) throws IOException {
		// 입력 파일 경로 지정
		File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// 입력 파일을 읽기 위한 BufferedReader 객체 생성
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		// 출력 파일 경로 지정
		File k27_f1 = new File("C:\\test\\day_data\\A005930.csv");
		// 출력 파일을 쓰기 위한 BufferedWriter 객체 생성
		BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
		// 한 줄씩 읽을 변수 선언
		String k27_readtxt;
		// 입력 파일에서 읽은 레코드 수를 저장할 변수 초기화
		int k27_cnt = 0;
		// 출력 파일에 쓴 레코드 수를 저장할 변수 초기화
		int k27_wcnt = 0;

		// 입력 파일에서 한 줄씩 읽어들이기ㅇ
		while ((k27_readtxt = k27_br.readLine()) != null) {
			// StringBuffer 객체 생성
			StringBuffer k27_s = new StringBuffer();
			// 읽어들인 레코드를 구분자를 이용하여 필드로 분리
			String[] k27_field = k27_readtxt.split("%_%");

			// 필드 수가 2보다 크고 3번째 필드에서 A이 포함되어 있는 레코드만 선택하여 처리
			if (k27_field.length > 2 && k27_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				// 첫 번째 필드 값을 StringBuffer에 저장
				k27_s.append(k27_field[0].replace("^", "").trim());

				// 두 번째 필드부터는 ","와 함께 StringBuffer에 추가
				for (int j = 1; j < k27_field.length; j++) {
					k27_s.append("," + k27_field[j].replace("^", "").trim());
				}
				// BufferedWriter를 이용하여 StringBuffer에 저장된 레코드를 출력 파일에 쓰기
				k27_bw1.write(k27_s.toString());
				// 출력한 레코드 수 증가
				k27_wcnt++;
				// 로그 출력
				System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
			}
			// 읽은 레코드 수 증가
			k27_cnt++;
		}
		// BufferedReader와 BufferedWriter 객체 닫기
		k27_br.close();
		k27_bw1.close();

		// 로그 출력
		System.out.printf("Program End [%d] [%d] records\n", k27_cnt, k27_wcnt);
	}
}

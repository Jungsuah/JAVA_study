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
		File k27_f = new File("C:\\test\\day_data\\2015MaxMin.csv"); // 데이터 파일 경로 설정
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f)); // 데이터 파일 읽어오기
		File k27_f1 = new File("C:\\test\\day_data\\final.csv"); // 최대값, 최소값을 저장할 파일 경로 설정
		BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1)); // 최대값, 최소값을 저장할 파일에 쓰기
		String k27_readtxt;
		int max = Integer.MIN_VALUE; // 최대값 변수 초기화
		int min = Integer.MAX_VALUE; // 최소값 변수 초기화

		int maxLine = 0; // 최대값이 있는 라인 변수 초기화
		int minLine = 0; // 최소값이 있는 라인 변수 초기화
		while ((k27_readtxt = k27_br.readLine()) != null) {

			String[] k27_field = k27_readtxt.split(","); // 쉼표로 분리된 필드를 배열로 저장

			if (Integer.parseInt(k27_field[3]) < min) {
				minLine = Integer.parseInt(k27_field[3]); // 최소값 라인 업데이트
			} else if (Integer.parseInt(k27_field[3]) > max) {
				maxLine = Integer.parseInt(k27_field[3]); // 최대값 라인 업데이트
			}

			max = Math.max(max, Integer.parseInt(k27_field[3])); // 최대값 업데이트
			min = Math.min(min, Integer.parseInt(k27_field[3])); // 최소값 업데이트

		}
		k27_bw1.write(maxLine); // 최대값이 있는 라인을 파일에 쓰기
		k27_bw1.newLine(); // 새 줄 생성
		k27_bw1.write(minLine); // 최소값이 있는 라인을 파일에 쓰기
		k27_br.close(); // 데이터 파일 닫기
		k27_bw1.close(); // 최대값, 최소값 파일 닫기

		System.out.println("최대값 : " + max + " 최소값 : " + min); // 최대값과 최소값 출력
	}
}

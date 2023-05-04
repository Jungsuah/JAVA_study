package java_intense;

import java.io.BufferedReader;  // BufferedReader 클래스 임포트
import java.io.File;  // File 클래스 임포트
import java.io.FileReader;  // FileReader 클래스 임포트
import java.io.IOException;  // IOException 클래스 임포트

public class L07 {
	public static void main(String[] args) throws IOException {
		// 파일 객체 생성
		File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// 파일 읽기 위한 BufferedReader 객체 생성
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		// 문자열을 저장할 변수
		String k27_readtxt;
		// 라인 수 카운트 변수
		int k27_LineCnt = 0;
		// 읽은 문자열을 저장할 버퍼
		StringBuffer k27_s = new StringBuffer();
		
		// 파일의 끝까지 읽기
		while (true) {
			// 문자열을 저장할 배열
			char[] k27_ch = new char[1000];
			// 문자열 읽기
			int k27_n = k27_br.read(k27_ch);
			// 파일 끝에 도달한 경우 while문을 빠져나옴
			if (k27_n == -1) {
				break;
			}
			// 읽은 문자열을 하나씩 처리
			for (char k27_c : k27_ch) {
				// 개행 문자인 경우 문자열을 출력하고 버퍼를 초기화
				if (k27_c == '\n') {
					System.out.printf("[%s]***\n", k27_s.toString());
					k27_s.delete(0, k27_s.length());
				} else {
					// 개행 문자가 아닌 경우 버퍼에 문자 추가
					k27_s.append(k27_c);
				}
			}
			// 라인 수 증가
			k27_LineCnt++;
		}
		// 마지막으로 남은 문자열 출력
		System.out.printf("[%s]***\n", k27_s.toString());
		// BufferedReader 닫기
		k27_br.close();
	}
}

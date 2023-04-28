package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02 {
	public static void main(String[] args) throws IOException {// main 메소드에서 IOException을 throws하면, 해당 예외는 JVM으로 전달되어
		// 출력되고 프로그램이 종료
		File k27_f = new File("C:\\Users\\정수아\\무료와이파이정보.txt");// 해당 경로에 새로운 파일 만들기
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader에 FileReader로 읽은 파일 객체 전달

		String k27_readtxt;// 출력할 문자열을 담을 변수 선언

		if ((k27_readtxt = k27_br.readLine()) == null) {// 읽어온 한줄이 내용이 없지 않으면
			System.out.printf("빈 파일 입니다\n");// 출력하기
			return;
		}
		String[] k27_field_name = k27_readtxt.split("\t");// 공백 기준으로 나누기

		double k27_lat = 37.3860521;// 위도 표시 실수형 변수 선언
		double k27_lng = 127.1214038;// 경도 표시 실수형 변수 선언
		int k27_LineCnt = 0;// 라인 횟수를 셀수있는 숫자형 변수 선언
		while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 한줄이 내용이 없지 않으면
			String[] k27_field = k27_readtxt.split("\t");// 공백 기준으로 나눠서 하나씩 배열에 담기
			System.out.printf("**[%d번째 항목]***********\n", k27_LineCnt);// 출력하기
			System.out.printf(" %s : %s\n", k27_field_name[10], k27_field[10]);// 배열의 10번째 항목 출력
			System.out.printf(" %s : %s\n", k27_field_name[13], k27_field[13]);// 배열의 13번째 항목 출력
			System.out.printf(" %s : %s\n", k27_field_name[14], k27_field[14]);// 배열의 14번째 항목 출력
			double dist = Math.sqrt(Math.pow(Double.parseDouble(k27_field[13]) - k27_lat, 2)
					+ Math.pow(Double.parseDouble(k27_field[14]) - k27_lng, 2));// 거리 계산을 하기위해 a - b의 제곱 + c - d의 제곱의
																				// 제곱근을 구해서 거리를 구한다
			System.out.printf(" 현재지점과 거리 : %f\n", dist);// 구해혼 거리 값을 출력
			System.out.println("*************************");//줄나누기
			k27_LineCnt++;// 읽어온 라인이 없을때 까지 라인 횟수 늘려주기
		}
		k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
	}
}

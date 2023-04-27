package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec01 {
	public static void main(String[] args) throws IOException {// main 메소드에서 IOException을 throws하면, 해당 예외는 JVM으로 전달되어
																// 출력되고 프로그램이 종료
		File k27_f = new File("C:\\Users\\정수아\\무료와이파이정보.csv");// 해당 경로에 파일 찾아오기
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader에 FileReader로 읽은 파일 객체 전달

		String k27_readtxt;// 출력할 문자열을 담을 변수 선언

		if ((k27_readtxt = k27_br.readLine()) == null) {// 읽어온 한줄이 내용이 없지 않으면
			System.out.printf("빈 파일 입니다\n");// 출력하기
			return;//호출한곳으로 돌아가기
		}
		String[] k27_field_name = k27_readtxt.split(",");//csv 파일은 ,를 기준으로 데이터를 자를수있기때문에 잘라서 배열에 넣기
		int k27_LineCnt = 0;// 줄갯수를 셀수있는 숫자형 변수 선언
		while ((k27_readtxt = k27_br.readLine()) != null) {//읽어온 한줄의 내용이 있으면
			String[] k27_field = k27_readtxt.split(",");//,를 기준으로 자른다음에 배열에 담는다
			System.out.printf("**[%d번째 항목]************\n", k27_LineCnt);//몇번째 출력인지 출력
			for (int i = 0; i < k27_field_name.length; i++) {//잘라온 문자를 담은 배열을 for문으로 반복하면서
				System.out.printf(" %s : %s\n" , k27_field_name[i],k27_field[i]);//내용 출력하기
			}
			System.out.println("*********************");
			if (k27_LineCnt == 100) {
				break;
			}
			k27_LineCnt++;
		}
		k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
	}

}

package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec04 {
	public static void main(String[] args) throws IOException {// main 메소드에서 IOException을 throws하면, 해당 예외는 JVM으로 전달되어
		// 출력되고 프로그램이 종료
		File k27_f = new File("C:\\Users\\정수아\\한국교통안전공단_전국공영주차장정보_20191224.txt");// 해당 경로에 새로운 파일 만들기
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader에 FileReader로 읽은 파일 객체 전달

		String k27_readtxt;// 출력할 문자열을 담을 변수 선언

		if ((k27_readtxt = k27_br.readLine()) == null) {// 읽어온 한줄이 내용이 없지 않으면
			System.out.printf("빈 파일 입니다\n");// 출력하기
			return;
		}
		String[] k27_field_name = k27_readtxt.split("\t");

		double k27_lat = 37.3860521;
		double k27_lng = 127.1214038;
		int k27_LineCnt = 0;
		double maxdist = 0;
		double mindist = 0;
		String[] maxDist = null;
		String[] minDist = null;
		while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 한줄이 내용이 없지 않으면
			String[] k27_field = k27_readtxt.split("\t");
			double dist = Math.sqrt(Math.pow(Double.parseDouble(k27_field[2]) - k27_lat, 2)
					+ Math.pow(Double.parseDouble(k27_field[3]) - k27_lng, 2));

			if (k27_LineCnt == 0) {
				maxdist = dist;
				mindist = dist;
			} else {
				if (maxdist < dist) {
					maxdist = dist;
					maxDist = k27_field;
				}
				if (mindist > dist) {
					mindist = dist;
					minDist = k27_field;
				}
			}
			k27_LineCnt++;
		}

		// 가장 가까운 장소 정보 출력
		if (minDist != null) {
			System.out.printf("**[최단 거리]***************\n");
			System.out.printf(" %s : %s\n", k27_field_name[1], minDist[1]);
			System.out.printf(" %s : %s\n", k27_field_name[10], minDist[10]);
			System.out.printf(" %s : %s\n", k27_field_name[13], minDist[13]);
			System.out.printf(" %s : %s\n", k27_field_name[14], minDist[14]);
			System.out.printf(" 현재지점과 거리 : %f\n", mindist);
		} else {
			System.out.printf("\n장소 정보가 없습니다.\n");
		}

		// 가장 먼 장소 정보 출력
		if (maxDist != null) {
			System.out.printf("\n**[최대 거리]***************\n");
			System.out.printf(" %s : %s\n", k27_field_name[1], maxDist[1]);
			System.out.printf(" %s : %s\n", k27_field_name[10], maxDist[10]);
			System.out.printf(" %s : %s\n", k27_field_name[13], maxDist[13]);
			System.out.printf(" %s : %s\n", k27_field_name[14], maxDist[14]);
			System.out.printf(" 현재지점과 거리 : %f\n", maxdist);
		} else {
			System.out.printf("\n장소 정보가 없습니다.\n");
		}

		k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
	}
}

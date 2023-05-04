package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec03 {
	public static void main(String[] args) throws IOException {// main 메소드에서 IOException을 throws하면, 해당 예외는 JVM으로 전달되어
		// 출력되고 프로그램이 종료
		File k27_f = new File("C:\\Users\\정수아\\무료와이파이정보.txt");// 해당 경로에 새로운 파일 만들기
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
		double k27_maxdist = 0;
		double k27_mindist = 0;
		String[] k27_maxDist = null;
		String[] k27_minDist = null;
		while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 한줄이 내용이 없지 않으면
			String[] k27_field = k27_readtxt.split("\t");// 공백 기준으로 나눠서 하나씩 배열에 담기
			System.out.printf("**[%d번째 항목]***********\n", k27_LineCnt);// 출력하기
			System.out.printf(" %s : %s\n", k27_field_name[10], k27_field[10]);// 배열의 10번째 항목 출력
			System.out.printf(" %s : %s\n", k27_field_name[13], k27_field[13]);// 배열의 13번째 항목 출력
			System.out.printf(" %s : %s\n", k27_field_name[14], k27_field[14]);// 배열의 14번째 항목 출력
			double k27_dist = Math.sqrt(Math.pow(Double.parseDouble(k27_field[13]) - k27_lat, 2)
					+ Math.pow(Double.parseDouble(k27_field[14]) - k27_lng, 2));// 거리 계산을 하기위해 a - b의 제곱 + c - d의 제곱의
																				// 제곱근을 구해서 거리를 구한다
			System.out.printf(" 현재지점과 거리 : %f\n", k27_dist);// 구해혼 거리 값을 출력
			System.out.println("*************************");//줄나누기
			
				if (k27_LineCnt == 0) {//첫번째 들어오는 값은
					k27_maxdist = k27_dist;//무조건 비교하기 위한 최대값에 넣어주기
					k27_mindist = k27_dist;//최솟값에도 넣어주기
				}else {//두번째 돌때 부터는 else 문을 타게 된다A
					if (k27_maxdist < k27_dist) {//현재 들어있는 값보다 새로 계산한 거리가 더 클경우
						k27_maxdist = k27_dist;//최대값 변수에 넣어준다.
						k27_maxDist = k27_field;//마지막에 출력을 위해 최대값 배열을 저장해준다.
					}
					if (k27_mindist > k27_dist) {//현재 들어있는 값보다 새로 계산한 거리가 더 작은 경우
						k27_mindist = k27_dist;//최솟값 변수에 넣어준다.
						k27_minDist = k27_field;//마지막에 출력을 위해 최솟값 배열을 저장해준다.
					}
				}
			k27_LineCnt++;//횟수 증가
		}
		
		// 가장 가까운 장소 정보 출력
		if (k27_minDist != null) {//공백이 아닌 경우일때
		    System.out.printf("\n**[최단 거리]***************\n");
		    System.out.printf(" %s : %s\n", k27_field_name[1], k27_minDist[1]);//최소값에 해당하는 설치장소명
		    System.out.printf(" %s : %s\n", k27_field_name[10], k27_minDist[10]);//최소값에 해당하는 소재지지번주소
		    System.out.printf(" %s : %s\n", k27_field_name[13], k27_minDist[13]);//최소값에 해당하는 위도
		    System.out.printf(" %s : %s\n", k27_field_name[14], k27_minDist[14]);//최소값에 해당하는 경도
		    System.out.printf(" 현재지점과 거리 : %f\n", k27_mindist);//최소값에 해당하는 현재지점과 거리
		} else {
		    System.out.printf("\n장소 정보가 없습니다.\n");
		}

		// 가장 먼 장소 정보 출력
		if (k27_maxDist != null) {
		    System.out.printf("\n**[최대 거리]***************\n");
		    System.out.printf(" %s : %s\n", k27_field_name[1], k27_maxDist[1]);//최소값에 해당하는 설치장소명
		    System.out.printf(" %s : %s\n", k27_field_name[10], k27_maxDist[10]);//최소값에 해당하는 소재지지번주소
		    System.out.printf(" %s : %s\n", k27_field_name[13], k27_maxDist[13]);//최소값에 해당하는 위도
		    System.out.printf(" %s : %s\n", k27_field_name[14], k27_maxDist[14]);//최소값에 해당하는 경도
		    System.out.printf(" 현재지점과 거리 : %f\n", k27_maxdist);//최소값에 해당하는 현재지점과 거리
		} else {
		    System.out.printf("\n장소 정보가 없습니다.\n");//없을 경우 출력해줄 내용
		}
		
		k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
	}
}

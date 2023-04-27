package ClassTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportSheet2 {
	public static void main(String[] args) {

		int iPerson_k27 = 200;// 이값을 주는 만큼 저장소 생성
		int personNumber_k27 = 30; // 한페이지에 출력되는 인원수
		InputData inData_k27 = new InputData(iPerson_k27); // 생성자의 숫자를 준만큼 배열을 만든다

		// 입력데이터 만들기
		for (int i_k27 = 0; i_k27 < iPerson_k27; i_k27++) {//iPerson_k27만큼 setData를 활용하여 데이터를 입력한다
			String name_k27 = String.format("홍길%02d", i_k27 + 1);//홍길하고 01을 만들기위해 포멧팅
			int kor_k27 = (int) (Math.random() * 100);//랜덤으로 0-99까지 수를 입력
			int eng_k27 = (int) (Math.random() * 100);//랜덤으로 0-99까지 수를 입력
			int mat_k27 = (int) (Math.random() * 100);//랜덤으로 0-99까지 수를 입력
			inData_k27.SetData(i_k27, name_k27, kor_k27, eng_k27, mat_k27);//위에서 만든 값을 setData를 통해 넣기
		}

		int count_k27 = 0;//숫자형 변수 선언
		int page_k27 = 1;//페이지 변수 선언
		int i_k27 = 0;//숫자형 변수선언
		int pageKor_k27 = 0;//페이지 국어변수 선언
		int pageEng_k27 = 0;//페이지 영어변수 선언
		int pageMat_k27 = 0;//페이지 수학변수 선언
		int pageSum_k27 = 0;//페이지 합계변수 선언
		int pageAvg_k27 = 0;//페이지 평균변수 선언

		while (count_k27 < 200) {
			int korSum_k27 = 0;//국어변수
			int EngSum_k27 = 0;//영어변수
			int matSum_k27 = 0;//수학변수
			int totalSum_k27 = 0;//합계변수
			int avgSum_k27 = 0;//평균변수
			System.out.println("                              성적집계표");
			LocalDateTime time_k27 = LocalDateTime.now();//현재시간불러오기
			String k27_time = time_k27.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// 날짜 출력 형식 포맷팅
			System.out.println("PAGE: " + page_k27 + "                                             출력일자 : " + k27_time);//출력
			System.out.println("================================================================================");
			System.out.println("번호        이름          국어        영어        수학        총점         평균");
			System.out.println("================================================================================");

			for (i_k27 = count_k27; i_k27 < iPerson_k27; i_k27++) {//iPerson_k27만큼 데이터 가져오기
				System.out.printf("번호:%03d    이름:%-7s국어:%-7d영어:%-7d수학:%-7d총점:%-8d평균:%-7d\n", i_k27 + 1, inData_k27.name_k27[i_k27],
						inData_k27.kor_k27[i_k27], inData_k27.eng_k27[i_k27], inData_k27.mat_k27[i_k27], inData_k27.sum_k27[i_k27], inData_k27.avg_k27[i_k27]);//가져온 데이터 출력
				count_k27++;//출력할때마다 카운드 올리기

				korSum_k27 += inData_k27.kor_k27[i_k27];//데이터가져오기
				EngSum_k27 += inData_k27.eng_k27[i_k27];//데이터가져오기
				matSum_k27 += inData_k27.mat_k27[i_k27];//데이터가져오기
				totalSum_k27 += inData_k27.sum_k27[i_k27];//데이터가져오기
				avgSum_k27 += inData_k27.avg_k27[i_k27];//데이터가져오기

				if (count_k27 % personNumber_k27 == 0) {//만약 카운트가 한페이지에 나오는 사람수랑 나눠서 0이되는 시점이 오면
					page_k27++;//페이지갯수 증가
					pageKor_k27 += korSum_k27;//위에서 만든 값을 페이지변수에 넣기
					pageEng_k27 += EngSum_k27;//위에서 만든 값을 페이지변수에 넣기
					pageMat_k27 += matSum_k27;//위에서 만든 값을 페이지변수에 넣기
					pageSum_k27 += totalSum_k27;//위에서 만든 값을 페이지변수에 넣기
					pageAvg_k27 += avgSum_k27;//위에서 만든 값을 페이지변수에 넣기
					break;//빠져나가서 밑에 출력을 하기
				}
			}

			System.out.println("================================================================================");
			System.out.println("현재페이지");//출력
			System.out.printf("합계 %23d%11d%11d%11d%11d\n", korSum_k27, EngSum_k27, matSum_k27, totalSum_k27, avgSum_k27);//출력
			System.out.printf("평균 %23d%11d%11d%11d%11d\n", korSum_k27 / personNumber_k27, EngSum_k27 / personNumber_k27,//출력
					matSum_k27 / personNumber_k27, totalSum_k27 / personNumber_k27, avgSum_k27 / personNumber_k27);//출력
			System.out.println("================================================================================");
			System.out.println("누적페이지");//출력
			System.out.printf("합계 %23d%11d%11d%11d%11d\n", pageKor_k27, pageEng_k27, pageMat_k27, pageSum_k27, pageAvg_k27);//출력
			System.out.printf("평균 %23d%11d%11d%11d%11d\n", pageKor_k27 / count_k27, pageEng_k27 / count_k27, pageMat_k27 / count_k27,
					pageSum_k27 / count_k27, pageAvg_k27 / count_k27);//출력
			System.out.println();//줄넘김
			System.out.println();//줄넘김
		}
	}
}

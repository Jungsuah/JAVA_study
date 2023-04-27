package ClassTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportSheet {
	public static void main(String[] args) {
		int iPerson_k27 = 30;// 이값을 주는 만큼 저장소 생성
		
		System.out.println("                              성적집계표");
		LocalDateTime time_k27 = LocalDateTime.now();//현재시간불러오기
		String k27_time = time_k27.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// 날짜 출력 형식 포맷팅
		System.out.println("                                             출력일자 : " + k27_time);//현재시간 출력
		System.out.println("================================================================================");
		System.out.println("번호        이름          국어        영어        수학        총점         평균");
		System.out.println("================================================================================");
		
		InputData inData_k27 = new InputData(iPerson_k27); //생성자의 숫자를 준만큼 배열을 만든다
		//입력데이터 만들기
		for (int i_k27 = 0; i_k27 < iPerson_k27; i_k27++) {//30만큼 setData를 활용하여 데이터를 입력한다
			String name = String.format("홍길%02d",i_k27);//홍길하고 01을 만들기위해 포멧팅
			int kor = (int)(Math.random()*100);//랜덤으로 0-99까지 수를 입력
			int eng = (int)(Math.random()*100);//랜덤으로 0-99까지 수를 입력
			int mat = (int)(Math.random()*100);//랜덤으로 0-99까지 수를 입력
			inData_k27.SetData(i_k27 , name, kor, eng,mat);//위에서 만든 값을 setData를 통해 넣기
		}
		
		for (int i_k27 = 1; i_k27 < iPerson_k27; i_k27++) {//setData를 통해 만든 값을 for문을 돌면서 꺼내기
			System.out.printf("번호:%2d    이름:%-7s국어:%-7d영어:%-7d수학:%-7d총점:%-7d평균:%-8d\n",
					i_k27,inData_k27.name_k27[i_k27],inData_k27.kor_k27[i_k27],inData_k27.eng_k27[i_k27],inData_k27.mat_k27[i_k27],inData_k27.sum_k27[i_k27],inData_k27.avg_k27[i_k27]);//출력형식 포맷팅
		}
	}
}



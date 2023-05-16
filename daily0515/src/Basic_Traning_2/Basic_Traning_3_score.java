package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Basic_Traning_3_score {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
		// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt = k27_conn.createStatement();//전체 학생의 개인별 점수/총점/평균을 가져올 Statement 객체
		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt1 = k27_conn.createStatement();//페이지별 총점/평균을 가져올 Statement 객체
		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt2 = k27_conn.createStatement();//누적 총점/평균을 가져올 Statement 객체

		System.out.println("                              성적집계표");//출력
		LocalDateTime time_k27 = LocalDateTime.now();// 현재시간불러오기
		String k27_time = time_k27.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// 날짜 출력 형식 포맷팅

		int k27_page = 1;//페이지 변수 선언 및 초기화
		for (int i = 0; i < 1000; i += 30) {//성적표 출력을 위한 반복문 -> 한번 반복시 i값은 30씩 증가
			// 페이지 헤더 출력
 			System.out.println("PAGE: " + k27_page + "                                          출력일자 : " + k27_time);
			System.out.println("==============================================================================");
			System.out.println("번호        이름          국어        영어        수학        총점         평균");
			System.out.println("==============================================================================");


			// 만들어진 쿼리를 Statement의 executeQuery메소드의 인자로 보내기
			String k27_QueryTxt = String.format(//전체 학생의 번호, 이름, 국어, 영어, 수확, 총점, 평균을 30개씩 가져오는 쿼리 작성
					"select *, kor+eng+mat as totalsum ,floor((kor+eng+mat)/3) as totalavg from score limit %d,30;", i);
			//쿼리의 결과값을 가져오고 ResultSet에 할당하여 출력
			ResultSet k27_rset = k27_stmt.executeQuery(k27_QueryTxt);
			while (k27_rset.next()) {//쿼리의 결과값이 있다면
				//칸수를 맞춰주고 출력 -> 학생의 번호, 이름, 국어, 영어, 수확, 총점, 평균을 ResultSet에서 가져와서 출력
				System.out.printf("%04d   %8s%11s%11s%11s%11s%11s\n", k27_rset.getInt(1),
						k27_rset.getString(2), k27_rset.getString(3), k27_rset.getString(4), k27_rset.getString(5), k27_rset.getString(6),
						k27_rset.getString(7));// 가져온 데이터 출력
			}
			k27_page++;// 30명 출력할때마다 카운드 올리기

			System.out.println("==============================================================================");//줄나누기

			// 만들어진 쿼리를 Statement의 executeQuery메소드의 인자로 보내기
			String k27_QueryTxt1 = String.format(//30명의 국어, 영어, 수확, 총점, 평균의 합계와 평균을 가져오는 쿼리
					"select sum(a.kor) , sum(a.eng), sum(a.mat), sum(a.totalsum), sum(a.totalavg), "
					+ "floor(avg(a.kor)), floor(avg(a.eng)), floor(avg(a.mat)), floor(avg(a.totalsum)), floor(avg(a.totalavg))"
					+ "from (select *, (kor+eng+mat) as totalsum ,floor((kor+eng+mat)/3) as totalavg from score limit %d,30) as a;",
					i);
			//쿼리의 결과값을 가져오고 ResultSet에 할당하여 출력
			ResultSet k27_rset1 = k27_stmt1.executeQuery(k27_QueryTxt1);

			while (k27_rset1.next()) {//쿼리의 결과값이 있다면
				//칸수를 맞춰주고 출력 -> 30명의 국어, 영어, 수확, 총점, 평균의 합계와 평균을 출력
				System.out.printf("합계   %21s%11s%11s%11s%11s\n", k27_rset1.getString(1), k27_rset1.getString(2),
						k27_rset1.getString(3), k27_rset1.getString(4), k27_rset1.getString(5));// 출력
				System.out.printf("평균   %21s%11s%11s%11s%11s\n", k27_rset1.getString(6), k27_rset1.getString(7),
						k27_rset1.getString(8), k27_rset1.getString(9), k27_rset1.getString(10));// 출력
			}

			System.out.println("==============================================================================");//줄나누기
			
			// 만들어진 쿼리를 Statement의 executeQuery메소드의 인자로 보내기
			String k27_QueryTxt2 = String.format(//0부터 i+30까지 누적된 누적된 학생의 국어, 영어, 수확, 총점, 평균의 합계와 평균을 출력
					"select sum(a.kor), sum(a.eng), sum(a.mat), sum(a.totalsum), sum(a.totalavg),"
					+ "floor(avg(a.kor)), floor(avg(a.eng)), floor(avg(a.mat)), floor(avg(a.totalsum)), floor(avg(a.totalavg))"
					+ "from (select *, kor+eng+mat as totalsum ,floor((kor+eng+mat)/3) as totalavg from score limit 0, %d) as a;",
					i + 30);
			//쿼리의 결과값을 가져오고 ResultSet에 할당하여 출력
			ResultSet k27_rset2 = k27_stmt2.executeQuery(k27_QueryTxt2);

			while (k27_rset2.next()) {
				//칸수를 맞춰주고 출력 -> 누적된 학생의 국어, 영어, 수확, 총점, 평균의 누적 합계와 누적 평균을 출력
				System.out.printf("누적 합계 %19s%11s%11s%11s%11s\n", k27_rset2.getString(1), k27_rset2.getString(2),
						k27_rset2.getString(3), k27_rset2.getString(4), k27_rset2.getString(5));// 출력
				System.out.printf("누적 평균 %19s%11s%11s%11s%11s\n", k27_rset2.getString(6), k27_rset2.getString(7),
						k27_rset2.getString(8), k27_rset2.getString(9), k27_rset2.getString(10));// 출력
				System.out.println();//줄넘김
				System.out.println();//줄넘김
			}
			k27_rset.close();// k27_rset 객체를 닫습니다.
			k27_rset1.close();// k27_rset1 객체를 닫습니다.
			k27_rset2.close();// k27_rset2 객체를 닫습니다.
		}
		k27_stmt.close();// Statement 객체를 닫습니다.
		k27_conn.close();// Connection 객체를 닫습니다.
	}
}

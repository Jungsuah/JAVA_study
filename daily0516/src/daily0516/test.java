package daily0516;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이버를 적재한다
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		// getConnection() 메소드를 통해서 데이터베이스와 자바를 연결한다

		// stocktest테이블에 주가데이터를 입력하는 쿼리를 작성한다
		String k27_QueryTxt = String.format("insert into stocktest ("
				+ " stnd_iscd, bsop_date, stck_prpr, stck_oprc, stck_hgpr, stck_lwpr, acml_vol, acml_tr_pbmn)"
				+ "values (?,?,?,?,?,?,?,?)");
		
		PreparedStatement pstmt_k27 = k27_conn.prepareStatement(k27_QueryTxt);
		// 대용량 데이터를 빠르게 Insert하기 위해 PreparedStatement를 이용한다
		// PreparedStatement는 캐시에 sql 문장을 담아 한번에 처리하기 때문에 Statement보다 처리 속도가 빠르다

		File k27_f = new File("C:\\test\\day_data\\A005930.csv");// 해당 경로에 csv 파일 찾아오기
		// 입력한다
		BufferedReader br_k27 = new BufferedReader(new FileReader(k27_f));
		// 파일입력속도 향상을 위해 BufferedReader객체를 선언한다

		String readtxt_k27; // 읽어온 파일을 한줄씩 저장하기 위한 문자열 변수를 선언한다
		int LineCnt_k27 = 0; // 읽어들인 라인 수를 저장하기 위한 변수를 선언한다
		k27_conn.setAutoCommit(false); // insert속도 향상을 위해서 AutoCommit를 false로 설정한다
		long startTime_k27 = System.currentTimeMillis(); // 시작 시간을 ms단위로 저장한다
		LocalDateTime currentTime = LocalDateTime.now(); // LocalDateTime클래스를 이용하여 현재시간을 받아온다
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // 시간을 원하는 형식으로 포맷팅해준다
		String startTime = currentTime.format(formatter); // 포맷팅된 현재시간을 startTime 문자열로 받아둔다
		String error_k27 = ""; // 에러메시지를 출력하기 위해 메시지를 누적해둘 문자열 선언

		while ((readtxt_k27 = br_k27.readLine()) != null) { // 읽어온 라인이 null이 아니면 계속 읽어들인다
			LineCnt_k27++; // 데이터를 한줄 처리했으므로 LineCnt를 1 증가시킨다

			if (LineCnt_k27 < 3970000 || LineCnt_k27 > 3980000 && LineCnt_k27 < 8724000 || LineCnt_k27 > 8726000) {
				continue;
			}

			String[] field_k27 = readtxt_k27.split(","); // split()메소드로 쉼표를 구분자로 필드값을 나눠서 저장한다

			pstmt_k27.setString(1, field_k27[0]); // 데이터의 첫번째 필드에 1번 필드인 유가증권 단축 종목코드를 입력한다
			pstmt_k27.setString(2, field_k27[1]); // 데이터의 두번째 필드에 0번 필드인 주식 영업 일자를 입력한다
			pstmt_k27.setString(3, field_k27[2]); // 데이터의 세번째 필드에 3번 필드인 주식 시가를 입력한다
			pstmt_k27.setString(4, field_k27[3]); // 데이터의 네번째 필드에 4번 필드인 주식 최고가를 입력한다
			pstmt_k27.setString(5, field_k27[4]); // 데이터의 다섯번째 필드에 5번 필드인 주식 최저가를 입력한다
			pstmt_k27.setString(6, field_k27[5]); // 데이터의 여섯번째 필드에 2번 필드인 주식 종가를 입력한다
			pstmt_k27.setString(7, field_k27[6]); // 데이터의 일곱번째 필드에 6번 필드인 누적 거래량을 입력한다
			pstmt_k27.setString(8, field_k27[7]); // 데이터의 여덟번째 필드에 7번 필드인 누적 거래 대금을 입력한다
			pstmt_k27.addBatch(); // addBatch()메소드를 호출해 캐시에 sql 문장을 담는다
			System.out.printf("%d번째 항목 addBatch OK\n", LineCnt_k27); // addBatch가 성공했음을 출력한다
			pstmt_k27.clearParameters(); // PreparedStatement의 파라미터를 비운다

			try {
				if ((LineCnt_k27 % 5000) == 0) { // 메모리 관리를 위해 10000줄씩 읽을 때마다
					pstmt_k27.executeBatch(); // executeBatch()를 호출해서 캐시에 담긴 SQL 문장을 실행한다
					k27_conn.commit(); // commit()을 호출해서 데이터를 영구히 저장한다
				}
			}catch (Exception e_k27) {
			    // 에러 정보 출력
//			    e.printStackTrace();
				error_k27 = error_k27 + "오류 행 : " + String.valueOf(LineCnt_k27) + e_k27.toString() + "\n";
			}
		}
		try {
			pstmt_k27.executeBatch();
		} catch (Exception e_k27) { // executeBatch()시에 Exception이 발생하면
//			e_k27.printStackTrace(); // 오류메시지를 출력한다
			error_k27 = error_k27 + "오류 행 : " + String.valueOf(LineCnt_k27) + e_k27.toString() + "\n";
			// 에러메시지를 error문자열에 누적하여 이어써준다
		}
		k27_conn.commit(); // 모든 insert가 완료되었으므로 commit을 한다
		k27_conn.setAutoCommit(true);// 모든 insert가 완료되었으므로 AutoCommit를 false로 설정한다
		long endTime_k27 = System.currentTimeMillis(); // 끝나는 시간을 ms단위로 저장한다
		currentTime = LocalDateTime.now(); // LocalDateTime클래스를 이용하여 현재시간을 다시 받아온다
		String endTime = currentTime.format(formatter); // 포맷팅된 현재시간을 endTime 문자열로 받아둔다

		System.out.printf("Insert End\n"); // Insert가 끝났음을 알리는 메시지를 출력한다
		System.out.printf("total               : %d\n", LineCnt_k27); // 읽어온 라인을 출력한다
		System.out.printf("time                : %dms\n", endTime_k27 - startTime_k27); // endTime에서 startTime을 뺀 수행시간을
																						// 출력한다
		System.out.printf("데이터입력 시작시간 : %s\n", startTime); // startTime을 출력해준다
		System.out.printf("데이터입력 완료시간 : %s\n", endTime); // endTime을 출력해준다
		System.out.println(error_k27); // 에러 내역을 출력한다

		br_k27.close(); // BufferedReader를 닫는다
		pstmt_k27.close(); // PreparedStatement를 닫는다
		k27_conn.close(); // Connection을 닫는다
	}
}
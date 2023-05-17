package daily0516;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Advantage_2 {// csv 파일 읽어서 stock 테이블에 데이터 집어넣기
	public static void main(String[] args) throws Exception {
		// JDBC 드라이버를 적재한다.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection() 메소드를 통해서 데이터베이스와 자바를 연결한다.
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// stock 테이블에 주가 데이터를 입력하는 쿼리를 작성한다.
		// PreparedStatement를 사용하므로 values에는 ?를 표시한다.
		String k27_QueryTxt = String.format("insert into stock ("
				+ " stnd_iscd, bsop_date, stck_prpr, stck_oprc, stck_hgpr, stck_lwpr, acml_vol, acml_tr_pbmn)"
				+ "values (?,?,?,?,?,?,?,?)");

		// 대용량 데이터를 빠르게 Insert 하기 위해 PreparedStatement를 이용한다.
		// PreparedStatement는 캐시에 SQL 문장을 담아 한번에 처리하기 때문에 Statement보다 처리속도가 빠르다.
		PreparedStatement pstmt = k27_conn.prepareStatement(k27_QueryTxt);

		// 파일 입력을 위해 File 객체를 생성하면서 파일 경로를 입력한다.
		File k27_f = new File("C:\\test\\day_data\\A005930.csv");// 해당 경로에 csv 파일 찾아오기
		//파일입력속도 향샹을 위해 BufferedReader 객체를 생성한다.
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));

		//읽어온 파일을 한줄씩 저장하기 위한 문자열 변수를 선언한다.
		String k27_readtxt;

		if ((k27_readtxt = k27_br.readLine()) == null) {// 첫줄이 null이면 빈 파일이기 때문에
			System.out.printf("빈 파일 입니다\n");// 빈파일임을 출력한다.
			return;// 호출한곳으로 돌아가기
		}

		int k27_LineCnt = 0;// 읽어들인 라인수를 저장하기 위한 변수를 선언한다.
		k27_conn.setAutoCommit(false);//insert 속도 향상을 위해 AutoCommit을 false로 설정한다.
		long startTime = System.currentTimeMillis();//시작 시간을 ms 단위로 저장한다. 

		String error = "";//에러메시지를 출력하기 위한 문자열 변수 선언
		while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 라인이 null이 아니면 계속 읽어들인다.
			String[] k27_field = k27_readtxt.split(",");//split()메소드로 쉼표를 구분자로 필드값을 나눠서 저장한다.

			pstmt.setString(1, k27_field[0]);//첫번째 ?에 0번째 필드인 유가 증권 단축 종목코드를 입력한다.
			pstmt.setString(2, k27_field[1]);//두번째 ?에 1번째 필드인 주식 영업 일자를 입력한다.
			pstmt.setString(3, k27_field[2]);//세번째 ?에 2번째 필드인 주식 종가를 입력한다.
			pstmt.setString(4, k27_field[3]);//네번째 ?에 3번째 필드인 주식 시가를 입력한다.
			pstmt.setString(5, k27_field[4]);//다섯번째 ?에 4번째 필드인 주식 최고가를 입력한다.
			pstmt.setString(6, k27_field[5]);//여섯번째 ?에 5번째 필드인 주식 최저가를 입력한다.
			pstmt.setString(7, k27_field[6]);//일곱번째 ?에 6번째 필드인 누적 거래량을 입력한다.
			pstmt.setString(8, k27_field[7]);//여덟번째 ?에 7번째 필드인 누적 거래 대금을 입력한다.
			pstmt.addBatch();//addBatch() 메소드를 호출해 캐시에 SQL 문장을 담는다.
			
			// addBatch가 성공했음을 출력한다.
			System.out.printf("%d번째 항목 addBatch OK\n", k27_LineCnt);
			pstmt.clearParameters();//PreparedStatement의 파라미터를 비운다.

			k27_LineCnt++;//데이터를 한줄 처리했으므로 k27_LineCnt를 증가시킨다.

			try {
				if (k27_LineCnt % 10000 == 0) {//메모리 관리를 위해 10000줄씩 읽을때 마다
					pstmt.executeBatch();//executeBatch()를 호출하여 캐시에 담긴 SQL 문장을 실행한다.
					k27_conn.commit();//commit()을 호출해서 데이터를 영구히 저장한다.
				}
			} catch (Exception e) {//executeBatch()시에 Exception이 발생하면
				e.printStackTrace();//예외메시지를 출력한다.
				//오류 메시지를 출력하기 위해 문자열에 에러메세지를 담는다.
				error = error + e.toString() + "오류 행 : " + String.valueOf(k27_LineCnt);
			}
		}
		try {//while 루프가 끝난 뒤 캐시에 남은 SQL 문장을 실행해야한다.
			pstmt.executeBatch();//executeBatch()를 호출하여 나머지 SQL 문장을 실행한다.
		} catch (Exception e) {//executeBatch()시에 Exception이 발생하면
			e.printStackTrace();//예외메시지를 출력한다.
			//오류 메시지를 출력하기 위해 문자열에 에러메세지를 담는다.
			error = error + e.toString() + "오류 행 : " + String.valueOf(k27_LineCnt);
		}

		k27_conn.commit();//모든 insert가 완료되었으므로 commit을 한다.
		k27_conn.setAutoCommit(true);//AutoCommit을 다시 true로 설정한다.
		long endTime = System.currentTimeMillis();//끝나는 시간을 ms 단위로 저장한다.
		
		System.out.println("Insert End");//Insert가 끝났음을 알리는 메시지를 출력한다.
		System.out.printf("total : %d\n", k27_LineCnt);//읽어온 라인을 출력한다.
		System.out.printf("time : %dms\n", endTime - startTime);//endTime에서 startTime을 뺀 수행시간을 출력한다.
		System.out.println(error);//에러메시지에 담긴 에러를 출력한다.

		k27_br.close();// BufferedReader를 닫는다.
		pstmt.close();// PreParedStatment를 닫는다.
		k27_conn.close();// Connection을 닫는다.
	}
}

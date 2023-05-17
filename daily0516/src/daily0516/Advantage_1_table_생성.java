package daily0516;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Advantage_1_table_생성 {
	public static void main(String[] args) throws ClassNotFoundException{
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		Connection k27_conn = null;
		try {
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류 출력
		}

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt= null;
		try {
			//conn객체에 createStatement의 메소드를 사용해 Statement 객체에 할당한다.
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류 출력
		}
		
		try {//stock 테이블을 생성하는 쿼리 작성
			k27_stmt.execute("create table stock("+
	                   "stnd_iscd varchar(200) not null,"+//유가증권 단축 종목코드
	                   "bsop_date int not null,"+//주식 영업 일자 
	                   "stck_prpr   int ,"+//주식 종가 
	                   "stck_oprc int,"+//주식 시가 
	                   "stck_hgpr int,"+//주식 최고가
	                   "stck_lwpr int,"+//주식 최저가
	                   "acml_vol long,"+//누적 거래량 
	                   "acml_tr_pbmn long,"+//누적 거래 대금
					   "primary key(bsop_date,stnd_iscd));" );//주식 영업 일자,종목을 복합 pk로 사용
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		
		try {
			// Statement 객체를 닫습니다.
			k27_stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		try {
			// Connection 객체를 닫습니다.
			k27_conn.close();
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
	}
}

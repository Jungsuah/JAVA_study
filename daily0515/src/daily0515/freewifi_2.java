package daily0515;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class freewifi_2 {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
		// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement stmt = conn.createStatement();

		// main 메소드에서 IOException을 throws하면, 해당 예외는 JVM으로 전달되어 출력되고 프로그램이 종료
		File k27_f = new File("C:\\Users\\정수아\\Desktop\\beforedata\\전국무료와이파이표준데이터b.txt");// 해당 경로에 파일 찾아오기
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader에 FileReader로 읽은 파일 객체 전달

		String k27_readtxt;// 출력할 문자열을 담을 변수 선언

		if ((k27_readtxt = k27_br.readLine()) == null) {// 읽어온 한줄이 내용이 없지 않으면
			System.out.printf("빈 파일 입니다\n");// 출력하기
			return;// 호출한곳으로 돌아가기
		}
		String[] k27_field_name = k27_readtxt.split("\t");// csv 파일은 tab을 기준으로 데이터를 자를수있기때문에 잘라서 배열에 넣기
		
		int k27_LineCnt = 0;// 줄갯수를 셀수있는 숫자형 변수 선언
		while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 한줄의 내용이 있으면
			String[] k27_field = k27_readtxt.split("\t");// ,를 기준으로 자른다음에 배열에 담는다
			
			String k27_QueryTxt;//쿼리를 담아줄 문자형 변수 선언
			
			//삽입하는 insert문을 작성해서 칼럼에 맞춰서 데이터 삽입한다. ->완성본
			k27_QueryTxt = String.format("insert into freewifi ("
					+ "ROWNUM, inst_place ,inst_place_detail ,inst_city,inst_country ,inst_place_flag ,"
					+ "service_provider ,wifi_ssid ,inst_date ,place_addr_road ,place_addr_land,"
					+ "manage_office ,manage_office_phone ,latitude ,longtitude ,write_date )"
					+ "values ("
					+ " '%s', '%s','%s','%s','%s','%s',"
					+ " '%s','%s','%s','%s','%s',"
					+ " '%s','%s','%s','%s','%s');", 
					k27_field[0],k27_field[1],k27_field[2],k27_field[3],k27_field[4],
					k27_field[5],k27_field[6],k27_field[7],k27_field[8],k27_field[9],
					k27_field[10],k27_field[11],k27_field[12],k27_field[13],k27_field[14], k27_field[15]);
			
			//삽입하는 insert문을 작성해서 칼럼에 맞춰서 데이터 삽입한다.
//			k27_QueryTxt = String.format("insert into freewifi ("
//					+ "inst_place ,inst_place_detail ,inst_city,inst_country ,inst_place_flag ,"
//					+ "service_provider ,wifi_ssid ,inst_date ,place_addr_road ,place_addr_land,"
//					+ "manage_office ,manage_office_phone ,latitude ,longtitude ,write_date )"
//					+ "values ("
//					+ " '%s','%s','%s','%s','%s',"
//					+ " '%s','%s','%s','%s','%s',"
//					+ " '%s','%s','%s','%s','%s');", 
//					k27_field[0],k27_field[1],k27_field[2],k27_field[3],k27_field[4],
//					k27_field[5],k27_field[6],k27_field[7],k27_field[8],k27_field[9],
//					k27_field[10],k27_field[11],k27_field[12],k27_field[13],k27_field[14]);
			
			stmt.execute(k27_QueryTxt);//Statement객체에 execute 메소드를 통해 만들어진 쿼리문을 전달한다.
			//들어가고 있는 항목이 몇번째 항목인지 출력해준다.
			System.out.printf("%d번째 항목 Insert OK [%s]\n" , k27_LineCnt, k27_QueryTxt);
			
			
			k27_LineCnt++;//한줄을 읽어오면 줄횟수를 추가한다.
			
		}
		k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제

		stmt.close();// Statement 객체를 닫습니다.
		conn.close();// Connection 객체를 닫습니다.
	}
}

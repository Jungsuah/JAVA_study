package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.parking;

public class parkingDaoImpl implements parkingDao{
	
	private Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체
	private Statement stmt = null; // SQL문 실행을 위한 Statement 객체
	private ResultSet rset = null; // SQL 쿼리 결과를 저장하기 위한 ResultSet 객체

	@Override
	public List<parking> selectAll() {
		System.out.println("===> parking 연결 시작!");// 확인용 출력구문

		// gongji 객체들의 리스트를 담기위한 리스트 선언 및 초기화
		List<parking> parkingList = new ArrayList<parking>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// gongji에서 페이지의 첫번째 시작 인덱스부터 한페이지에 출력할 갯수 만큼 쿼리로 범위를 설정해서 가져오기
			rset = stmt.executeQuery(
					"SELECT * FROM parking;");

			while (rset.next()) {
			    // 새로운 parking 객체를 생성합니다.
			    parking parking = new parking();

			    // ResultSet에서 각 컬럼의 값을 가져와서 parking 객체에 설정합니다.
			    parking.setId(rset.getInt("id")); // id 컬럼 값 설정
			    parking.setName(rset.getString("name")); // name 컬럼 값 설정
			    parking.setAddr(rset.getString("addr")); // addr 컬럼 값 설정
			    parking.setStitValue(rset.getString("stitValue")); // stitValue 컬럼 값 설정
			    parking.setStxtValue(rset.getString("stxtValue")); // stxtValue 컬럼 값 설정
			    parking.setFrStitValue(rset.getString("frStitValue")); // frStitValue 컬럼 값 설정
			    parking.setFrStxtValue(rset.getString("frStxtValue")); // frStxtValue 컬럼 값 설정
			    parking.setAiTitValue(rset.getString("aiTitValue")); // aiTitValue 컬럼 값 설정
			    parking.setAiTxtValue(rset.getString("aiTxtValue")); // aiTxtValue 컬럼 값 설정
			    parking.setBasicfee(rset.getString("basicfee")); // basicfee 컬럼 값 설정
			    parking.setExtrafee(rset.getString("extrafee")); // extrafee 컬럼 값 설정
			    parking.setInfo(rset.getString("info")); // info 컬럼 값 설정
			    parking.setLatitude(rset.getString("latitude")); // latitude 컬럼 값 설정
			    parking.setLongitude(rset.getString("longitude")); // longitude 컬럼 값 설정

			    // parking 객체를 parkingList에 추가합니다.
			    parkingList.add(parking);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return parkingList;// GongjiList 객체들의 리스트를 반환
	}
}

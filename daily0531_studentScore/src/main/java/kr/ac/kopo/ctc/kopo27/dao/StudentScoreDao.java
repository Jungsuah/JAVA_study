package kr.ac.kopo.ctc.kopo27.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.StudentScore;

public interface StudentScoreDao {
	
	// 학생 점수 데이터의 총 개수를 반환합니다.
	int count();
	
	// 방문자 수를 반환합니다.
	int peopleCount();
	
	// 방문자 수를 업데이트합니다.
	int updatePeopleCount(int peopleCount);
	
	// 새로운 학생 점수 데이터를 생성합니다.
	StudentScore create(StudentScore studentScore);

	// 주어진 id에 해당하는 학생 점수 데이터를 조회합니다.
	StudentScore selectOne(int id);

	// 페이지와 페이지 당 개수를 기준으로 모든 학생 점수 데이터를 조회합니다.
	List<StudentScore> selectAll(int page, int countPerPage);

	// 주어진 id에 해당하는 학생 점수 데이터를 업데이트합니다.
	StudentScore update(int id, StudentScore studentScore);

	// 주어진 id에 해당하는 학생 점수 데이터를 삭제합니다.
	void deleteById(int id);
	
	// 주어진 학생 studentId에 해당하는 학생 점수 데이터를 삭제합니다.
	void deleteByStudentId(int studentId);
	
	// 데이터베이스에 학생 점수 테이블을 생성하는 SQL문을 반환합니다.
	String createTable();
	
	// 데이터베이스에 학생 점수 테이블을 삭제하는 SQL문을 반환합니다.
	String dropTable();
	
	// 학생 점수 데이터를 1000개를 모두 삽입하는 SQL문을 반환합니다.
	String insertAll();

	// 주어진 학생 studentId에 해당하는 학생 점수 데이터를 조회합니다.
	StudentScore selectByStudentId(int studentId);
	
	// 주어진 이름에 해당하는 학생 점수 데이터를 조회합니다.
	StudentScore selectByName(String name);

	// 주어진 학생 id에 해당하는 학생 점수 데이터의 데이터 개수를 조회하여 다음으로 들어가야되는 studentId를 반환합니다.
	int updateDataCount(int studentId);

	// 주어진 테이블 이름이 데이터베이스에 존재하는지 여부를 반환합니다.
	boolean isTableExists(String tableName);
}

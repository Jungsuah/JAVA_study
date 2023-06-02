package kr.ac.kopo.ctc.kopo27.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.StudentScore;

public interface StudentScoreDao {
	int count();
	
	int peopleCount();
	
	int updatePeopleCount(int peopleCount);
	
	StudentScore create(StudentScore studentScore);

	StudentScore selectOne(int id);

	List<StudentScore> selectAll(int page, int countPerPage);

	StudentScore update(int id,StudentScore studentScore);

	void deleteById(int id);
	
	void deleteByStudentId(int studentId);
	
	String createTable();
	
	String dropTable();
	
	String insertAll();

	StudentScore selectBystudentid(int studentid);
	
	StudentScore selectByName(String name);

	int updateDataCount(int studentId);


	boolean isTableExists(String tableName);

}

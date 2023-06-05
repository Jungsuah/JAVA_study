package kr.ac.kopo.ctc.kopo27.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.StudentScore;

public interface StudentScoreDao {
	
	// �л� ���� �������� �� ������ ��ȯ�մϴ�.
	int count();
	
	// �湮�� ���� ��ȯ�մϴ�.
	int peopleCount();
	
	// �湮�� ���� ������Ʈ�մϴ�.
	int updatePeopleCount(int peopleCount);
	
	// ���ο� �л� ���� �����͸� �����մϴ�.
	StudentScore create(StudentScore studentScore);

	// �־��� id�� �ش��ϴ� �л� ���� �����͸� ��ȸ�մϴ�.
	StudentScore selectOne(int id);

	// �������� ������ �� ������ �������� ��� �л� ���� �����͸� ��ȸ�մϴ�.
	List<StudentScore> selectAll(int page, int countPerPage);

	// �־��� id�� �ش��ϴ� �л� ���� �����͸� ������Ʈ�մϴ�.
	StudentScore update(int id, StudentScore studentScore);

	// �־��� id�� �ش��ϴ� �л� ���� �����͸� �����մϴ�.
	void deleteById(int id);
	
	// �־��� �л� studentId�� �ش��ϴ� �л� ���� �����͸� �����մϴ�.
	void deleteByStudentId(int studentId);
	
	// �����ͺ��̽��� �л� ���� ���̺��� �����ϴ� SQL���� ��ȯ�մϴ�.
	String createTable();
	
	// �����ͺ��̽��� �л� ���� ���̺��� �����ϴ� SQL���� ��ȯ�մϴ�.
	String dropTable();
	
	// �л� ���� �����͸� 1000���� ��� �����ϴ� SQL���� ��ȯ�մϴ�.
	String insertAll();

	// �־��� �л� studentId�� �ش��ϴ� �л� ���� �����͸� ��ȸ�մϴ�.
	StudentScore selectByStudentId(int studentId);
	
	// �־��� �̸��� �ش��ϴ� �л� ���� �����͸� ��ȸ�մϴ�.
	StudentScore selectByName(String name);

	// �־��� �л� id�� �ش��ϴ� �л� ���� �������� ������ ������ ��ȸ�Ͽ� �������� ���ߵǴ� studentId�� ��ȯ�մϴ�.
	int updateDataCount(int studentId);

	// �־��� ���̺� �̸��� �����ͺ��̽��� �����ϴ��� ���θ� ��ȯ�մϴ�.
	boolean isTableExists(String tableName);
}

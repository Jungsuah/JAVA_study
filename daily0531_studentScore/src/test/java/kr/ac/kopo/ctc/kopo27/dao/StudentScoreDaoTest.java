package kr.ac.kopo.ctc.kopo27.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo27.domain.StudentScore;
import kr.ac.kopo.ctc.kopo27.dto.Pagination;
import kr.ac.kopo.ctc.kopo27.service.StudentScoreService;
import kr.ac.kopo.ctc.kopo27.service.StudentScoreServiceImpl;

class StudentScoreDaoTest {

	@Test
	void test_selectAll1() {
		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
		StudentScoreService studentScoreService = new StudentScoreServiceImpl();
		Pagination pagination = studentScoreService.getPagination(1, 50);
		List<StudentScore> studentScoreList = studentScoreDao.selectAll(pagination.getC(), 50);
		System.out.println("1 : " + studentScoreList.toString());
	}

	@Test
	void test_selectOne1() {
		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
		StudentScore ss = studentScoreDao.selectOne(4);

		System.out.println("id : " + ss.getId() + " name : " + ss.getName());
	}
//
//	@Test
//	void test_deleteById() {
//		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
//
//		studentScoreDao.deleteById(6);
//		StudentScore ss = studentScoreDao.selectOne(6);
//		if (ss == null) {
//			System.out.println("ã����� id�� ���� ��ü�� �����ϴ�!");
//			System.out.println(studentScoreDao.count());
//		} else {
//			System.out.println("id : " + ss.getId() + " name : " + ss.getName());
//		}
//	}
//
//	@Test
//	void test_deleteByStudentId() {
//		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
//
//		studentScoreDao.deleteByStudentId(209908);
//		StudentScore ss = studentScoreDao.selectOne(8);
//		if (ss == null) {
//			System.out.println("ã����� studentId�� ���� ��ü�� �����ϴ�!");
//			System.out.println(studentScoreDao.count());
//		} else {
//			System.out.println("id : " + ss.getId() + " name : " + ss.getName());
//		}
//	}
//
//	@Test
//	void test_create1() {
//		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
//		System.out.println("insert �� : " + studentScoreDao.count());
//		StudentScore studentScore = new StudentScore();
//		studentScore.setName("ȫ�浿");
//		studentScore.setStudentid(1);
//		studentScore.setKor(1);
//		studentScore.setEng(1);
//		studentScore.setMat(1);
//		studentScoreDao.create(studentScore);
//
//		System.out.println("insert �� : " + studentScoreDao.count());
//	}
//
//	@Test
//	void test_update() {
//		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
//		StudentScore ss = studentScoreDao.selectOne(1);
//		System.out.println("������Ʈ �� id : " + ss.getId() + " ������Ʈ �� name : " + ss.getName());
//		ss.setName("ȫ�浿");
//		ss.setStudentid(3);
//		ss.setKor(0);
//		ss.setEng(0);
//		ss.setMat(0);
//
//		studentScoreDao.update(ss.getId(), ss);
//
//		StudentScore kk = studentScoreDao.selectOne(1);
//		System.out.println("������Ʈ �� id : " + kk.getId() + " ������Ʈ �� name : " + kk.getName());
//	}
}

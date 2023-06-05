package kr.ac.kopo.ctc.kopo27.service;

import kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao;
import kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl;
import kr.ac.kopo.ctc.kopo27.dto.Pagination;

public class StudentScoreServiceImpl implements StudentScoreService {

	@Override
	public Pagination getPagination(int page, int countPerPage) {// ����� �Է��ϴ� ������ , �������� ����� ���� �Ķ����
		Pagination pagination = new Pagination();//��ȯ�� ������ ��ü ���� �� �ʱ�ȭ

		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();//�ٿ��� import

		int totalData = studentScoreDao.count();// ��ü ������ ������ ���ؿ��� �޼ҵ带 ����Ͽ� ������ ����

		// ������ ������ �� ���ϱ� => nn
		// ������ ������ ��ȣ�� ����Ͽ� ������ �����ϴµ�,
		// ��ü ������ ��(totalData)�� �� �������� ����� ������ ��(countPerPage)�� ���� �������� 0�� ���,
		// ��ü ������ ���� �� �������� ����� ������ ���� ���� ���� ������ ������ ��ȣ�� �����մϴ�.
		// �׷��� ���� ���, ��ü ������ ���� �� �������� ����� ������ ���� ���� �� 1�� ���� ���� ������ ������ ��ȣ�� �����մϴ�.
		int lastnumber = totalData % countPerPage == 0 ? totalData / countPerPage : ((totalData / countPerPage) + 1);

		int currentPage = 0; // ���� �������� ��Ÿ���� ���� => 'c'
		if (page <= 0) { // �Է¹��� ������ ���� 0���� ���� ���
			currentPage = 1; // ���� �������� 1�� ����
		} else if (page > lastnumber) { // �Է¹��� ������ ��ȣ�� ������ ������ ��ȣ���� Ŭ ���
			currentPage = lastnumber; // ���� �������� ������ ������ ��ȣ�� ����
		} else {
			currentPage = page; // ���� �������� �Է¹��� ������ ������ ����
		}

		int startblock = ((currentPage - 1) / 10) * 10 + 1; // ��ư ���� ���ڸ� ����Ͽ� ������ ���� => 's'

		int lastpageStart = ((lastnumber - 1) / 10) * 10 + 1; // ������ ������ ���� ��ư ���ڸ� ����Ͽ� ������ ���� => 's1'

		int endblock = (startblock + 10) - 1; // ��ư ������ ���ڸ� ����Ͽ� ������ ���� => 'e'
		if (endblock > lastnumber) {
			endblock = lastnumber; // ��ư ������ ���ڰ� ������ ������ ��ȣ���� ũ�� ��ư ������ ���ڸ� ������ ������ ��ȣ�� ����
		}

		int p = currentPage - 10; // ���� ��ư�� �� ����Ͽ� ������ ���� => '<'
		if (p > 0) {
			p = currentPage - 10; // ���� ��ư�� ���� 0���� ũ�� ������ ����
		} else {
			p = -1; // ���� ��ư�� ���� 0���� �۰ų� ������ -1�� ����
		}

		int pp = currentPage - 10; // �� ó������ ���� ��ư�� �� ����Ͽ� ������ ���� => '<<'
		if (pp <= 0) {
			pp = -1; // �� ó������ ���� ��ư�� ���� 0���� �۰ų� ������ -1�� ����
		} else {
			pp = 1; // �� ó������ ���� ��ư�� ���� 0���� ũ�� 1�� ����
		}

		int n = 0; // ���� ������ + 10 ���� ��Ÿ���� ���� => '>'
		if (currentPage + 10 > lastnumber) {
			n = lastnumber; // ���� ������ + 10 ���� ������ ������ ��ȣ���� ũ�� ������ ������ ������ ��ȣ�� ����
		} else {
			n = currentPage + 10; // ���� ������ + 10 ���� ������ ������ ��ȣ���� �۰ų� ������ ������ ���� ������ + 10 ������ ����
		}

		int nn = 0; // �� ������ ������ ��ư�� �� ����Ͽ� ������ ���� => '>>'
		if (startblock >= lastpageStart) {
			n = -1;
			nn = -1; // ��ư ���� ���ڰ� ������ ������ ���� ��ư ���ں��� ũ�ų� ������ -1�� ����
		} else {
			nn = lastnumber; // ��ư ���� ���ڰ� ������ ������ ���� ��ư ���ں��� ������ ������ ������ ������ ��ȣ�� ����
		}

		pagination.setC(currentPage); // ���� ������ ���� Pagination ��ü�� 'C' ������ ����
		pagination.setS(startblock); // ��ư ���� ���� ���� Pagination ��ü�� 'S' ������ ����
		pagination.setE(endblock); // ��ư ������ ���� ���� Pagination ��ü�� 'E' ������ ����
		pagination.setP(p); // ���� ��ư '<'�� �ش��ϴ� ���� 'p'�� Pagination ��ü�� 'P' ������ ����
		pagination.setPp(pp); // �� ó������ ���� ��ư '<<'�� �ش��ϴ� ���� 'pp'�� Pagination ��ü�� 'Pp' ������ ����
		pagination.setN(n); // ���� ���������� 10�� ���� ���� 'n'�� Pagination ��ü�� 'N' ������ ����
		pagination.setNn(nn); // �� ������ ������ ��ư '>>'�� �ش��ϴ� ���� 'nn'�� Pagination ��ü�� 'Nn' ������ ����

		return pagination;// ������� ������ ��ü ��ȯ
	}
}

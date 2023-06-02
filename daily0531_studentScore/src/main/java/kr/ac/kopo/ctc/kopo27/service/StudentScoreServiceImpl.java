package kr.ac.kopo.ctc.kopo27.service;

import kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao;
import kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl;
import kr.ac.kopo.ctc.kopo27.dto.Pagination;

public class StudentScoreServiceImpl implements StudentScoreService {

	@Override
	public Pagination getPagination(int page, int countPerPage) {//����� �Է��ϴ� ������ , �������� ����� ���� �Ķ��
		Pagination pagination = new Pagination();
		
		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
		
		int totalData = studentScoreDao.count();// ��ü ������ ����
		
		//������ ������ �� ���ϱ� => nn
		int lastnumber = totalData % countPerPage == 0 ? totalData / countPerPage : ((totalData / countPerPage) + 1); 
		
		int currentPage = 0; // ���� ������ => c
		if (page <= 0) {//�Է¹��� ������ ���� 0���� ���� ��� 
			currentPage = 1; 
		}else if(page > lastnumber) {//������ ������ ��ȣ���� Ŭ ���
			currentPage = lastnumber; 
		}else {
			currentPage = page;
		}
		
		int startblock = ((currentPage-1)/10)*10+1; // ��ư ���� ���� => s
		
		int lastpageStart = ((lastnumber-1)/10)*10+1; // ������ ������ ���� ��ư ���� => s1
		
		int endblock = (startblock + 10) - 1; //��ư ������ ���� => e
		if(endblock > lastnumber) {
			endblock = lastnumber;
		}
		
	    int p = currentPage - 10; // => ���� ��ư <
	    if(p > 0) {
	    	p = currentPage - 10;
	    }else {
	    	p = -1;
	    }
	    
	    int pp = currentPage - 10;// =>�� ó������ ���� ��ư <<
	    if(pp <= 0) {
	    	pp = - 1;
	    }else {
	    	pp = 1;
	    }
	    
	    int n = 0; // => ���������� + 10 >
	    if ( currentPage + 10 > lastnumber) {
			n = lastnumber;
		}else {
			n = currentPage + 10;
		}
	   
	    int nn = 0; // => �� ������ ������ ��ư >>
	    if (startblock >= lastpageStart) {
	    	n = -1;
	    	nn = -1;
		}else {
			nn = lastnumber;
		}
	    
		pagination.setC(currentPage);
		pagination.setS(startblock);
		pagination.setE(endblock);
		pagination.setP(p);
		pagination.setPp(pp);
		pagination.setN(n);
		pagination.setNn(nn);
		return pagination;
	}
}

package kr.ac.kopo.ctc.kopo27.service;

import kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao;
import kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl;
import kr.ac.kopo.ctc.kopo27.dto.Pagination;

public class StudentScoreServiceImpl implements StudentScoreService {

	@Override
	public Pagination getPagination(int page, int countPerPage) {//사용자 입력하는 페이지 , 한페이지 출력할 갯수 파라미
		Pagination pagination = new Pagination();
		
		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
		
		int totalData = studentScoreDao.count();// 전체 데이터 갯수
		
		//마지막 페이지 값 구하기 => nn
		int lastnumber = totalData % countPerPage == 0 ? totalData / countPerPage : ((totalData / countPerPage) + 1); 
		
		int currentPage = 0; // 현재 페이지 => c
		if (page <= 0) {//입력받은 페이지 값이 0보다 작은 경우 
			currentPage = 1; 
		}else if(page > lastnumber) {//마지막 페이지 번호보다 클 경우
			currentPage = lastnumber; 
		}else {
			currentPage = page;
		}
		
		int startblock = ((currentPage-1)/10)*10+1; // 버튼 시작 숫자 => s
		
		int lastpageStart = ((lastnumber-1)/10)*10+1; // 마지막 페이지 시작 버튼 숫자 => s1
		
		int endblock = (startblock + 10) - 1; //버튼 마지막 숫자 => e
		if(endblock > lastnumber) {
			endblock = lastnumber;
		}
		
	    int p = currentPage - 10; // => 이전 버튼 <
	    if(p > 0) {
	    	p = currentPage - 10;
	    }else {
	    	p = -1;
	    }
	    
	    int pp = currentPage - 10;// =>맨 처음으로 가는 버튼 <<
	    if(pp <= 0) {
	    	pp = - 1;
	    }else {
	    	pp = 1;
	    }
	    
	    int n = 0; // => 현재페이지 + 10 >
	    if ( currentPage + 10 > lastnumber) {
			n = lastnumber;
		}else {
			n = currentPage + 10;
		}
	   
	    int nn = 0; // => 맨 마지막 페이지 버튼 >>
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

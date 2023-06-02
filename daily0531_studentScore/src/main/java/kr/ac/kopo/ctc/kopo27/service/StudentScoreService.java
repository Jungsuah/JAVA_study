package kr.ac.kopo.ctc.kopo27.service;

import kr.ac.kopo.ctc.kopo27.dto.Pagination;

public interface StudentScoreService {
	
	Pagination getPagination(int page, int countPerPage);
	
}

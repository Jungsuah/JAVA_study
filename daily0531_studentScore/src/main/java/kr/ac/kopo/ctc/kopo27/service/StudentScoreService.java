package kr.ac.kopo.ctc.kopo27.service;

import kr.ac.kopo.ctc.kopo27.dto.Pagination;

public interface StudentScoreService {

    /**
     * 페이지 정보를 생성하여 반환
     * page         현재 페이지
     * countPerPage 페이지당 항목 수
     * Pagination 	객체
     */
    Pagination getPagination(int page, int countPerPage);

}

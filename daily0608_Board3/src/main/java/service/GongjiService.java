package service;

import dto.Pagination;

public interface GongjiService {

    /**
     * 페이지 정보를 생성하여 반환
     * page         현재 페이지
     * countPerPage 페이지당 항목 수
     * Pagination 	객체
     */
    Pagination getPagination(int page, int countPerPage);
}

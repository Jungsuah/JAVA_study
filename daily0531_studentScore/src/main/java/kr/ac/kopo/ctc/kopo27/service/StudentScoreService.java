package kr.ac.kopo.ctc.kopo27.service;

import kr.ac.kopo.ctc.kopo27.dto.Pagination;

public interface StudentScoreService {

    /**
     * ������ ������ �����Ͽ� ��ȯ
     * page         ���� ������
     * countPerPage �������� �׸� ��
     * Pagination 	��ü
     */
    Pagination getPagination(int page, int countPerPage);

}

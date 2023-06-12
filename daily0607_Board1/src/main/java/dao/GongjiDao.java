package dao;

import java.util.List;

import domain.Gongji;

public interface GongjiDao {
	
	int makeData();//테이블 생성

	List<Gongji> selectAllGongji();//전체 공지사항 가져오기 -> 페이지 처리 전

	Gongji selectOneGongji(int id);// id로 객체 찾아오기

	int deleteOneGongji(int id);//아이디로 객체 지우기

	int updateGongji(Gongji gongji);//객체를 받아서 업데이트 하기

	int count();//전체 공지 테이블의 총 갯수 세기

	List<Gongji> selectAll(int pageNum, int countPerPage);//전체 공지사항 가져오기 -> 페이지 기능 구현

	int insertGongji(String title, String content);//제목과 내용으로 새글 입력받기

	Gongji newGongji();//가장 최신 게시글 찾아오기

	int updatePeopleCount(int viewcnt, int id);//조회수 업데이트
}

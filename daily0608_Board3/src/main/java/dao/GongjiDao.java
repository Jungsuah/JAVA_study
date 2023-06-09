package dao;
import java.util.List;

import domain.Gongji;

public interface GongjiDao {
	
	int makeData();//테이블 생성

	Gongji selectOneGongji(int id);// id로 객체 찾아오기

	int insertGongji(Gongji gongji);// 원글 등록

	int updateWongul(Gongji gongji);//원글 수정 
	
	int insertReply(Gongji gongji);//댓글 등록
	
	int updateReply(Gongji gongji);//댓글 수정

	int count();//전체 공지 테이블의 총 갯수 세기

	List<Gongji> selectAll(int pageNum, int countPerPage);//전체 게시글 가져오기 -> 페이지 기능 구현

	int updatePeopleCount(int viewcnt, int id);//조회수 업데이트
	
	int insertNewGongji(String title, String content, int rootid);// 원글 등록
	
	int getMiddleRecnt(int rootid, int relevel, int recnt);//댓글의 중간 recnt 구하기
	
	int getMaxRecnt(int rootid);//댓글의 마지막 recnt 구하기

	int delete(int rootid, int relevel, int recnt);//원글과 댓글 삭제하기
}



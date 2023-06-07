package dao;

import java.util.List;

import domain.Gongji;

public interface GongjiDao {
	
	int makeData();//테이블 생성

	List<Gongji> selectAllGongji();

	Gongji selectOneGongji(int id);

	int deleteOneGongji(int id);

	int updateGongji(Gongji gongji);

	int count();

	List<Gongji> selectAll(int pageNum, int countPerPage);

	int insertGongji(String title, String content);

	Gongji newGongji();//가장 최신 게시글 찾아오기
}

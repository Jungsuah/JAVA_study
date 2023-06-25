package dao;

import java.util.List;

import domain.parking;

public interface parkingDao {
	List<parking> selectAll();// 전체 게시글 가져오기 -> 페이지 기능 구현
}

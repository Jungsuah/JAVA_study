package dao;

import java.util.List;

import domain.Stock;

public interface StockDao {
	
	int makeData();//테이블 생성

	List<Stock> selectAllStock();

	Stock selectOneStock(int id);

	int deleteOneStock(int id);

	int updateStock(Stock stock);

	int count();

	List<Stock> selectAll(int pageNum, int countPerPage);

	int insertStock(Stock stock);

	Stock newStock();//가장 최신 게시글 찾아오기
}

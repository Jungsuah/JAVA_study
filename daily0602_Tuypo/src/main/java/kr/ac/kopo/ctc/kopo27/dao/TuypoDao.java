package kr.ac.kopo.ctc.kopo27.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.Hubo_Table;
import kr.ac.kopo.ctc.kopo27.domain.VotingResult;

public interface TuypoDao {
	
	List<Hubo_Table> selectAll(); //전체 후보 테이블 조회

	int deleteById(int id); //id로 후보 삭제
	
	int insertHubo(int id, String name); // 후보 추가하기

	List<VotingResult> getVotingResultsHubo();//후보별 득표수와 득표율 가져오기

	List<VotingResult> getVotingResultsAge(int id);//후보의 연령대별 득표수와 득표율 가져오기

	int blankHuboNumber();//빈 후보 번호 가져오기

	int insertTuypo(int id, int age);//투표하기

}

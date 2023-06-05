package kr.ac.kopo.ctc.kopo27.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.Hubo_Table;
import kr.ac.kopo.ctc.kopo27.domain.VotingResult;

public interface TuypoDao {
	
	List<Hubo_Table> selectAll(); //��ü �ĺ� ���̺� ��ȸ

	int deleteById(int id); //id�� �ĺ� ����
	
	int insertHubo(int id, String name); // �ĺ� �߰��ϱ�

	List<VotingResult> getVotingResultsHubo();//�ĺ��� ��ǥ���� ��ǥ�� ��������

	List<VotingResult> getVotingResultsAge(int id);//�ĺ��� ���ɴ뺰 ��ǥ���� ��ǥ�� ��������

	int blankHuboNumber();//�� �ĺ� ��ȣ ��������

	int insertTuypo(int id, int age);//��ǥ�ϱ�

}

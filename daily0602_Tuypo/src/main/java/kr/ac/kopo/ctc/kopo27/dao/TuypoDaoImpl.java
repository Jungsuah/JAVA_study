package kr.ac.kopo.ctc.kopo27.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.Hubo_Table;
import kr.ac.kopo.ctc.kopo27.domain.VotingResult;

public class TuypoDaoImpl implements TuypoDao {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rset = null;

	@Override
	public int insertHubo(int id, String name) {// �ĺ� �߰��ϱ�
		int result = 1;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			int startID = 0;

			ResultSet rset = stmt.executeQuery("select * from hubo_table;");
			// sql������ �����ϰ� ����� ResultSet�� ��ȯ�Ѵ�
			startID = 1;// ���� �й��� fromId ������ ����
			while (rset.next()) { // rset��ü�� �� ���� �ݺ��Ѵ�
				if (startID == rset.getInt(1)) { // ù��° �ڷ���� ���ʴ�� �й��� �̾� �����ϸ�
					startID++; // �����й����� �Ѿ��
				} else { // �ش��й��� �������� ������
					id = startID;
					break; // ������ �����Ѵ�
				}
			}

			// INSERT ������ ����Ͽ� ���ο� �й��� �߰�
			String sql = "INSERT INTO hubo_table(id, name) VALUES(" + id + ", '" + name + "');";

			stmt.execute(sql);

			System.out.println("insert ����");

			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int insertTuypo(int id, int age) {// �ĺ� �߰��ϱ�
		int result = 1;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();
			
			int startID = 0;
			
			// INSERT ������ ����Ͽ� ���ο� �й��� �߰�
			String sql = "INSERT INTO Tupyo_table(id,age ) VALUES(" + id + ", " + age + ");";

			stmt.execute(sql);

			System.out.println("��ǥ ����");

			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�
			
		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int blankHuboNumber() {// �ĺ� �߰��ϱ�
		int startID = 0;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();
			
			ResultSet rset = stmt.executeQuery("select * from hubo_table;");
			// sql������ �����ϰ� ����� ResultSet�� ��ȯ�Ѵ�
			startID = 1;// ���� �й��� fromId ������ ����
			while (rset.next()) { // rset��ü�� �� ���� �ݺ��Ѵ�
				if (startID == rset.getInt(1)) { // ù��° �ڷ���� ���ʴ�� �й��� �̾� �����ϸ�
					startID++; // �����й����� �Ѿ��
				} else { // �ش��й��� �������� ������
					break; // ������ �����Ѵ�
				}
			}
			
			System.out.println("��ȣ �������� ����");
			
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return startID;
	}

	@Override
	public List<VotingResult> getVotingResultsHubo() {// �ĺ��ں� ��ǥ���� ��ǥ�� ��������
		List<VotingResult> voteResultList = new ArrayList<VotingResult>();
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();

			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			String query = "SELECT h.id, h.name, COUNT(*) AS voteCount, "
				    + "(COUNT(*) * 100 / total.total_votes) AS votePercentage "
				    + "FROM hubo_table h "
				    + "JOIN Tupyo_table t ON h.id = t.id "
				    + "CROSS JOIN (SELECT COUNT(*) AS total_votes FROM Tupyo_table) AS total "
				    + "GROUP BY h.id, h.name, total.total_votes;";

			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				VotingResult result = new VotingResult();
				result.setId(rset.getInt(1));
				result.setName(rset.getString(2));
				result.setVoteCount(rset.getInt(3));
				result.setVotePercentage(rset.getInt(4));
				voteResultList.add(result);
			}
			
			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(voteResultList.toString());
		return voteResultList;
	}

	@Override
	public List<VotingResult> getVotingResultsAge(int id) {// �ĺ��� ���ɴ뺰 ��ǥ���� ��ǥ�� ��������
		System.out.println("���ɺ� ��������!!!!!!!!");
		List<VotingResult> voteResultList = new ArrayList<VotingResult>();
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();

			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			String query = "select B.name, A.���ɴ�, A.��ǥ��, A.��ǥ�� " + "from (select id, age*10 as ���ɴ�, count(age) as ��ǥ��, "
					+ "count(age)/(select count(*) from Tupyo_table where id = "+  id + ") * 100 as ��ǥ�� "
					+ "from Tupyo_table where id = "+ id +" group by age order by age) as A "
					+ "inner join hubo_table B on A.id = B.id";

			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				VotingResult result = new VotingResult();
				result.setName(rset.getString(1));
				result.setAgeGroup(rset.getInt(2));
				result.setVoteCount(rset.getInt(3));
				result.setVotePercentage(rset.getInt(4));
				voteResultList.add(result);
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voteResultList;
	}

	@Override
	public List<Hubo_Table> selectAll() {// StudentScore ��ü���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ� selectAll
		System.out.println("===> hubo_Table�� ���� ����!");

		List<Hubo_Table> list = new ArrayList<Hubo_Table>();
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			// examtable���� ��ü ���� ��ȸ�ϴ� ����
			rset = stmt.executeQuery("select * from hubo_table;");

			while (rset.next()) {
				Hubo_Table hubo = new Hubo_Table();
				hubo.setId(rset.getInt("id"));
				hubo.setName(rset.getString("NAME"));
				list.add(hubo);
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
//		for (Hubo_Table hubo_Table : list) {
//			System.out.println(hubo_Table.getId() + hubo_Table.getName());
//		}
		return list;
	}

	@Override
	public int deleteById(int id) {// id�� ����
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			stmt = conn.createStatement();
			String sql1 = "DELETE FROM Tupyo_table WHERE id = " + id;
			stmt.executeUpdate(sql1);
			String sql2 = "DELETE FROM hubo_table WHERE id = " + id;
			stmt.executeUpdate(sql2);
			System.out.println("delete id�� ����");
			result = 1;

		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				result = -1;
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				result = -1;
				e.printStackTrace();
			}
		}
		return result;
	}

}

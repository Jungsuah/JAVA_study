package kr.ac.kopo.ctc.kopo27.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.StudentScore;

public class StudentScoreDaoImpl implements StudentScoreDao {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rset = null;

	@Override
	public int count() {
		int count = 0;
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
			rset = stmt.executeQuery("SELECT count(*) FROM examtable;");

			while (rset.next()) {
				count = rset.getInt(1);
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int updateDataCount(int studentId) {
		int count = 0;
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
			rset = stmt.executeQuery("SELECT * FROM examtable;");
			
			while (rset.next()) {
				count ++;
				if(studentId == rset.getInt("STUDENTID")) {
					break;
				}
			}
			
			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public StudentScore create(StudentScore studentScore) {// insert
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			// �Ķ���� name�� �޾Ƽ� ���ڿ� ���� cTmp�� �Ҵ�
			String name = studentScore.getName();
			int studentId = studentScore.getStudentid();
			int kor = studentScore.getKor();
			int eng = studentScore.getEng();
			int mat = studentScore.getMat();
			int startID = 0;
			
			 ResultSet rset = stmt.executeQuery("select * from examtable;");
	            //sql������ �����ϰ� ����� ResultSet�� ��ȯ�Ѵ�
	            startID = 209901;//���� �й��� fromId ������ ����
	            while (rset.next()){ //rset��ü�� �� ���� �ݺ��Ѵ�
	                if (startID == rset.getInt(3)) { //ù��° �ڷ���� ���ʴ�� �й��� �̾� �����ϸ�
	                    startID++;   //�����й����� �Ѿ��
	                } else { //�ش��й��� �������� ������
	                    break; //������ �����Ѵ�
	                }
	            }     

	            // INSERT ������ ����Ͽ� ���ο� �й��� �߰�
	            String sql = "INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('"
	            + name + "'," + startID + ", " + kor + ", " + eng + ", " + mat + ")";

			// INSERT ������ ����Ͽ� ���ο� �й��� �߰�
//			String sql = "INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('" + name + "'," + studentId
//					+ ", " + kor + ", " + eng + ", " + mat + ")";

			stmt.execute(sql);

			System.out.println("insert ����");

			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentScore;
	}

	@Override
	public StudentScore selectOne(int id) {
		StudentScore studentScore = null;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();

			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE id = " + id + ";");

			if (rset.next()) {
				studentScore = new StudentScore();
				studentScore.setId(rset.getInt("ID"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("kor"));
				studentScore.setEng(rset.getInt("eng"));
				studentScore.setMat(rset.getInt("mat"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentScore;
	}
	
	@Override
	public StudentScore selectBystudentid(int studentid) {
		StudentScore studentScore = null;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();
			
			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE studentid = " + studentid + ";");
			
			if (rset.next()) {
				studentScore = new StudentScore();
				studentScore.setId(rset.getInt("ID"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("kor"));
				studentScore.setEng(rset.getInt("eng"));
				studentScore.setMat(rset.getInt("mat"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
			}
			
			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentScore;
	}

	@Override
	public List<StudentScore> selectAll(int page, int countPerPage) {// StudentScore ��ü���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ� selectAll
		System.out.println("===> examtable�� ���� ����!");

		int rstart = (page - 1) * countPerPage;// ù��° ������ �ε��� ���ϱ�
		System.out.println(rstart);

		List<StudentScore> StudentScoreList = new ArrayList<StudentScore>();
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
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
				StudentScore studentScore = new StudentScore();
				studentScore.setId(rset.getInt("id"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("KOR"));
				studentScore.setEng(rset.getInt("ENG"));
				studentScore.setMat(rset.getInt("MAT"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
				StudentScoreList.add(studentScore);
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StudentScoreList;
	}

	@Override
	public StudentScore update(int id, StudentScore studentScore) {
		StudentScore ss = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			// SQL �������� �����ϱ� ���� executeUpdate �޼��带 ȣ���մϴ�.
			String updateQuery = "UPDATE examtable SET " + "name = '" + studentScore.getName() + "', " + "studentid = "
					+ studentScore.getStudentid() + ", kor = " + studentScore.getKor() + ", eng = "
					+ studentScore.getEng() + ", mat = " + studentScore.getMat() + " WHERE id = " + id;

			stmt.executeUpdate(updateQuery);

			System.out.println("update ����");

			// ������Ʈ�� ����� Ȯ���ϱ� ���� select ������ �����մϴ�.
			rset = stmt.executeQuery("SELECT * FROM examtable WHERE id = " + id);

			while (rset.next()) {
				ss = new StudentScore();
				ss.setId(rset.getInt("id"));
				ss.setName(rset.getString("name"));
				ss.setStudentid(rset.getInt("studentid"));
				ss.setKor(rset.getInt("kor"));
				ss.setEng(rset.getInt("eng"));
				ss.setMat(rset.getInt("mat"));
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public void deleteById(int id) {// id�� ����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			stmt = conn.createStatement();
			String sql = "DELETE FROM examtable WHERE id = " + id;
			stmt.executeUpdate(sql);

			System.out.println("delete id�� ����");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByStudentId(int studentId) {// studentId�� ����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			stmt = conn.createStatement();
			String sql = "DELETE FROM examtable WHERE studentid = " + studentId;
			stmt.executeUpdate(sql);

			System.out.println("delete studentId�� ����");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String createTable() {
		String errorMessage = "";// ������ �����ֱ� ���� ���ڿ� ���� ����

		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();

			// examtable�̶�� ���̺��� �����ϴ� SQL���� �����մϴ�.
			stmt.execute("create table examtable ( id INT AUTO_INCREMENT PRIMARY KEY," + "name varchar(20),"
					+ "studentid int not null unique," + "kor int," + "eng int," + "mat int)"
					+ "DEFAULT CHARSET=utf8;");

			// ���̺� �����ϸ� ���� ����ϱ�
			System.out.println("���̺� ����� OK");

			stmt.close();// Statement ��ü�� �ݽ��ϴ�.
			conn.close();// Connection ��ü�� �ݽ��ϴ�.
		} catch (SQLException e) {// sql������ ������ ������
			errorMessage = e.getMessage();// �����޽����� ����� ���ڿ��� ���
		} catch (ClassNotFoundException e) {// Ŭ������ ã�����ϴ� ������ ������
			errorMessage = "����̹� �ε� ����: " + e.getMessage();// �����޽����� ����� ���ڿ��� ���
		}

		if (!errorMessage.isEmpty()) {// ���� �����޽����� �ִٸ�
			System.out.println("���� �߻�: " + errorMessage);// ����ϱ�
		}
		return errorMessage;
	}

	@Override
	public String dropTable() {
		String errorMessage = "";// ������ �����ֱ� ���� ���ڿ� ���� ����

		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();

			// SQL �������� �����ϱ� ���� execute �޼��带 ȣ���մϴ�.
			// �� �ڵ忡���� "drop from examtable" ������ �����Ͽ� examtable�� �����մϴ�.
			stmt.execute("drop table examtable;");

			System.out.println("���̺� ����� OK");

			stmt.close();// Statement ��ü�� �ݽ��ϴ�.
			conn.close();// Connection ��ü�� �ݽ��ϴ�.

		} catch (SQLException e) {// sql������ ������ ������
			errorMessage = e.getMessage();// �����޽����� ����� ���ڿ��� ���
		} catch (ClassNotFoundException e) {// Ŭ������ ã�����ϴ� ������ ������
			errorMessage = "����̹� �ε� ����: " + e.getMessage();// �����޽����� ����� ���ڿ��� ���
		}

		if (!errorMessage.isEmpty()) {// ���� �����޽����� �ִٸ�
			System.out.println("���� �߻�: " + errorMessage);// ����ϱ�
		}
		return errorMessage;
	}

	@Override
	public StudentScore selectByName(String name) {
		StudentScore studentScore = null;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();
			
			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE name = '" + name + "';");
			
			if (rset.next()) {
				studentScore = new StudentScore();
				studentScore.setId(rset.getInt("ID"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("kor"));
				studentScore.setEng(rset.getInt("eng"));
				studentScore.setMat(rset.getInt("mat"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
			}
			
			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentScore;
	}

	@Override
	public String insertAll() {
		String errorMessage = "";// ������ �����ֱ� ���� ���ڿ� ���� ����
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();
			
		for (int i = 0; i < 150; i++) {//i�� 0���� 999���� �ݺ��ϴ� �ݺ���
			int cnt = i + 1;
	        String name = "ȫ��"+cnt;
	        int studentid = 209900 + cnt;
	        stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat) VALUE ('" + name + "', " +studentid +"," + "rand()*100, rand()*100, rand()*100);");
		}
			// ���̺� �����ϸ� ���� ����ϱ�
			System.out.println("������ �Է� OK");

			stmt.close();// Statement ��ü�� �ݽ��ϴ�.
			conn.close();// Connection ��ü�� �ݽ��ϴ�.
		} catch (SQLException e) {// sql������ ������ ������
			errorMessage = e.getMessage();// �����޽����� ����� ���ڿ��� ���
		} catch (ClassNotFoundException e) {// Ŭ������ ã�����ϴ� ������ ������
			errorMessage = "����̹� �ε� ����: " + e.getMessage();// �����޽����� ����� ���ڿ��� ���
		}

		if (!errorMessage.isEmpty()) {// ���� �����޽����� �ִٸ�
			System.out.println("���� �߻�: " + errorMessage);// ����ϱ�
		}
		return errorMessage;
	}

	@Override
	public int peopleCount() {
		int peopleCount = 0;
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
			rset = stmt.executeQuery("SELECT * FROM countpeople;");

			while (rset.next()) {
				peopleCount = rset.getInt(1);
			}
			
			System.out.println("�� : " + peopleCount);
			
			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return peopleCount;
	}

	@Override
	public int updatePeopleCount(int peopleCount) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
	        stmt = conn.createStatement();
	        
	        String query = "UPDATE countpeople SET countnum = " + peopleCount;
	        int rowsAffected = stmt.executeUpdate(query);

	        System.out.println("�湮�ڼ� ������Ʈ ����");
	        System.out.println(rowsAffected + " ���� ������Ʈ�Ǿ����ϴ�.");
	        
	        stmt.close();
	        conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return peopleCount;
	}
	
	@Override
	public boolean isTableExists(String tableName) {
	    boolean tableExists = false;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
	        stmt = conn.createStatement();
	        String table = "kopo27";
	        
	        String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + table + "' AND table_name = '" + tableName + "'";
	        ResultSet resultSet = stmt.executeQuery(query);
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            if (count > 0) {
	                tableExists = true;
	            }
	        }
	        
	        resultSet.close();
	        stmt.close();
	        conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return tableExists;
	}

}

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

	private Connection conn = null;  // �����ͺ��̽� ������ ���� Connection ��ü
	private Statement stmt = null;  // SQL�� ������ ���� Statement ��ü
	private ResultSet rset = null;  // SQL ���� ����� �����ϱ� ���� ResultSet ��ü
	
	@Override
	// �л� ���� �������� �� ������ ��ȯ�մϴ�.
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
			// examtable���� ��ü �� ������ ��ȸ�ϴ� ����
			rset = stmt.executeQuery("SELECT count(*) FROM examtable;");

			//rset�� �޾ƿ� ���� ���������� �ݺ��ϸ鼭 �� ������
			while (rset.next()) {
				count = rset.getInt(1);//��ȯ�Ǵ� ù��° ���ڸ� count�� ����
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {//������ �߻��ϸ� 
			e.printStackTrace();//������ ���
		}
		return count;//count���� ��ȯ
	}

	@Override
	// �־��� �л� id�� �ش��ϴ� �л� ���� �������� ������ ������ ��ȸ�Ͽ� �������� ���ߵǴ� studentId�� ��ȯ�մϴ�.
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
			// examtable���� ��ü ���� ���� �������� ����
			rset = stmt.executeQuery("SELECT * FROM examtable;");

			while (rset.next()) {// rset�� �޾ƿ� ���� ���������� �ݺ��ϸ鼭 �� ������
				count++;// �Ķ���ͷ� studentId�� �޾Ƽ� STUDENTIDĮ������ ���� ���� �ֱ� ������ +1�� �ϸ鼭 ����
				if (studentId == rset.getInt("STUDENTID")) {
					break;// ���� ���� �ִٸ� �ݺ��� Ż��
				}
			}
			
			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}
		return count;// count���� ��ȯ
	}

	@Override
	public StudentScore create(StudentScore studentScore) {// studentScore��ü�� �Ķ���ͷ� �޾Ƽ� �����ͺ��̽��� �߰��ϴ� �Լ�
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			String name = studentScore.getName();// �Ķ���� studentScore ��ü�� �޾Ƽ� ���ڿ� ���� name�� �Ҵ�
			int kor = studentScore.getKor();// �Ķ���� studentScore ��ü�� �޾Ƽ� ������ ���� kor�� �Ҵ�
			int eng = studentScore.getEng();// �Ķ���� studentScore ��ü�� �޾Ƽ� ������ ���� eng�� �Ҵ�
			int mat = studentScore.getMat();// �Ķ���� studentScore ��ü�� �޾Ƽ� ������ ���� mat�� �Ҵ�
			int startID = 0;//������ ������ ���� ��ȣ�� studentid������ �ֱ����� startid ������ ���� ����

			// sql������ �����ϰ� ����� ResultSet�� ��ȯ�Ѵ�
			ResultSet rset = stmt.executeQuery("select * from examtable;");
			startID = 209901;// ���� �й��� startID ������ ����
			while (rset.next()) { // rset ��ü�� �� ���� �ݺ��Ѵ�
				if (startID == rset.getInt(3)) { // ù��° �ڷ���� ���ʴ�� �й��� �̾� �����ϸ�
					startID++; // �����й����� �Ѿ��
				} else { // �ش��й��� �������� ������
					break; // ������ �����Ѵ�
				}
			}

			// INSERT ������ ����Ͽ� ����ִ� �й��ڸ��� ��ü �߰� 
			String sql = "INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('" + name + "'," + startID
					+ ", " + kor + ", " + eng + ", " + mat + ")";

			stmt.execute(sql);//sql���� �����Ѵ�.

			System.out.println("insert ����");//������ insert ���� ���

			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}

		return studentScore;//������ studentScore ��ü�� ��ȯ�Ѵ�.
	}

	@Override
	// �־��� id�� �ش��ϴ� �л� ���� �����͸� ��ȸ�մϴ�.
	public StudentScore selectOne(int id) {
		StudentScore studentScore = null;//studentScore ��ü ���� �� �ʱ�ȭ 
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			Statement stmt = conn.createStatement();

			// ���� ������� ���� ResultSet ��ü�� �����մϴ�.
			//id������ ���ϴ� ���� ������ �˻��ؼ� �������µ� id�� �Ķ���ͷ� ���� id�� ���� ���� ��ȸ
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE id = " + id + ";");

			while (rset.next()) {// rset�� �޾ƿ� ���� ���������� �ݺ��ϸ鼭 �� ������
				studentScore = new StudentScore();//�ݺ����� �������� ��ü�� �ʱ�ȭ �����ֱ� ���ؼ� ���ο� ��ü ����
				studentScore.setId(rset.getInt("ID"));//rset���� Į���� ID�� �����ͼ� studentScore�� id�� ����
				studentScore.setName(rset.getString("NAME"));//rset���� Į���� NAME�� �����ͼ� studentScore�� NAME�� ����
				studentScore.setStudentid(rset.getInt("STUDENTID"));//rset���� Į���� STUDENTID�� �����ͼ� studentScore�� STUDENTID�� ����
				studentScore.setKor(rset.getInt("kor"));//rset���� Į���� kor�� �����ͼ� studentScore�� kor�� ����
				studentScore.setEng(rset.getInt("eng"));//rset���� Į���� eng�� �����ͼ� studentScore�� eng�� ����
				studentScore.setMat(rset.getInt("mat"));//rset���� Į���� mat�� �����ͼ� studentScore�� mat�� ����
				studentScore.setSum(rset.getInt("sum"));//rset���� Į���� sum�� �����ͼ� studentScore�� sum�� ����
				studentScore.setAve(rset.getInt("ave"));//rset���� Į���� ave�� �����ͼ� studentScore�� ave�� ����
				studentScore.setRanking(rset.getInt("ranking"));//rset���� Į���� ranking�� �����ͼ� studentScore�� ranking�� ����
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		}catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}
		return studentScore;//id������ ��ȸ�� �л� ���� ������ ��ȯ
	}

	@Override
	// �־��� �л� studentId�� �ش��ϴ� �л� ���� �����͸� ��ȸ�մϴ�.
	public StudentScore selectByStudentId(int studentid) {
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
			//�Ķ���ͷ� ���� studentid���� ���� studentid�� �л� ���� �����͸� �������� ������ �����Ѵ�.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE studentid = " + studentid + ";");
			
			// ResultSet���� �����͸� �о�� StudentScore ��ü�� �����մϴ�.
			while (rset.next()) {
			    // ���ο� StudentScore ��ü�� �����մϴ�.
			    studentScore = new StudentScore();

			    // ResultSet���� �� �÷��� ���� �����ͼ� StudentScore ��ü�� �����մϴ�.
			    studentScore.setId(rset.getInt("ID"));  // ID �÷� �� ����
			    studentScore.setName(rset.getString("NAME"));  // NAME �÷� �� ����
			    studentScore.setStudentid(rset.getInt("STUDENTID"));  // STUDENTID �÷� �� ����
			    studentScore.setKor(rset.getInt("kor"));  // kor �÷� �� ����
			    studentScore.setEng(rset.getInt("eng"));  // eng �÷� �� ����
			    studentScore.setMat(rset.getInt("mat"));  // mat �÷� �� ����
			    studentScore.setSum(rset.getInt("sum"));  // sum �÷� �� ����
			    studentScore.setAve(rset.getInt("ave"));  // ave �÷� �� ����
			    studentScore.setRanking(rset.getInt("ranking"));  // ranking �÷� �� ����
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		}catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}
		return studentScore;// �־��� �л� studentId�� �ش��ϴ� �л� ���� �����͸� ��ȯ
	}

	@Override
	public List<StudentScore> selectAll(int page, int countPerPage) {// StudentScore ��ü���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ� selectAll
		System.out.println("===> examtable�� ���� ����!");//Ȯ�ο� ��±���

		int rstart = (page - 1) * countPerPage;// ����ϰ� ���� �������� ù��° ������ �ε��� ���ϱ�

		//StudentScore ��ü���� ����Ʈ�� ������� ����Ʈ ���� �� �ʱ�ȭ
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
			// examtable���� �������� ù��° ���� �ε������� ���������� ����� ���� ��ŭ ������ ������ �����ؼ� ��������
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t ORDER BY studentid ASC LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
			    // ���ο� StudentScore ��ü�� �����մϴ�.
			    StudentScore studentScore = new StudentScore();

			    // ResultSet���� �� �÷��� ���� �����ͼ� StudentScore ��ü�� �����մϴ�.
			    studentScore.setId(rset.getInt("id"));  // id �÷� �� ����
			    studentScore.setName(rset.getString("NAME"));  // NAME �÷� �� ����
			    studentScore.setStudentid(rset.getInt("STUDENTID"));  // STUDENTID �÷� �� ����
			    studentScore.setKor(rset.getInt("KOR"));  // KOR �÷� �� ����
			    studentScore.setEng(rset.getInt("ENG"));  // ENG �÷� �� ����
			    studentScore.setMat(rset.getInt("MAT"));  // MAT �÷� �� ����
			    studentScore.setSum(rset.getInt("sum"));  // sum �÷� �� ����
			    studentScore.setAve(rset.getInt("ave"));  // ave �÷� �� ����
			    studentScore.setRanking(rset.getInt("ranking"));  // ranking �÷� �� ����

			    // StudentScore ��ü�� StudentScoreList�� �߰��մϴ�.
			    StudentScoreList.add(studentScore);
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		}catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}
		return StudentScoreList;//StudentScore ��ü���� ����Ʈ�� ��ȯ
	}

	@Override
	// �־��� id�� �ش��ϴ� �л� ���� �����͸� �Ķ���ͷ� �޾� ������ ������Ʈ�ϴ� �Լ�
	public StudentScore update(int id, StudentScore studentScore) {
		StudentScore ss = null;//������Ʈ�� ��ü�� ��ȯ�ϱ����� StudentScore ��ü ����
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
			    // ���ο� StudentScore ��ü�� �����մϴ�.
			    ss = new StudentScore();

			    // ResultSet���� �� �÷��� ���� �����ͼ� StudentScore ��ü�� �����մϴ�.
			    ss.setId(rset.getInt("id"));  // id �÷� �� ����
			    ss.setName(rset.getString("name"));  // name �÷� �� ����
			    ss.setStudentid(rset.getInt("studentid"));  // studentid �÷� �� ����
			    ss.setKor(rset.getInt("kor"));  // kor �÷� �� ����
			    ss.setEng(rset.getInt("eng"));  // eng �÷� �� ����
			    ss.setMat(rset.getInt("mat"));  // mat �÷� �� ����
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		}catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}
		return ss;//������Ʈ�� ��ü�� ��ȯ
	}

	@Override
	// �־��� id�� �ش��ϴ� �л� ���� �����͸� �����ϴ� �Լ�
	public void deleteById(int id) {
	    try {
	        // JDBC ����̹� Ŭ������ �������� �ε��մϴ�.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement ��ü�� �����մϴ�.
	        stmt = conn.createStatement();

	        // DELETE ���� �����Ͽ� �־��� id�� �ش��ϴ� �����͸� �����մϴ�.
	        String sql = "DELETE FROM examtable WHERE id = " + id;
	        stmt.executeUpdate(sql);

	        System.out.println("delete id�� ����");

	    } catch (Exception e) {//������ �߻��ϸ� 
	        e.printStackTrace();//������ ���
	    } finally {
	        try {
	            stmt.close();  // ����� Statement ��ü�� �ݽ��ϴ�.
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            conn.close();  // ����� Connection ��ü�� �ݽ��ϴ�.
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	// �־��� �л� studentId�� �ش��ϴ� �л� ���� �����͸� �����մϴ�.
	public void deleteByStudentId(int studentId) {// studentId�� ����
	    try {
	        // JDBC ����̹� Ŭ������ �������� �ε��մϴ�.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement ��ü�� �����մϴ�.
	        stmt = conn.createStatement();

	        // DELETE ���� �����Ͽ� �־��� studentId�� �ش��ϴ� �����͸� �����մϴ�.
	        String sql = "DELETE FROM examtable WHERE studentid = " + studentId;
	        stmt.executeUpdate(sql);

	        System.out.println("delete studentId�� ����");

	    } catch (Exception e) {//������ �߻��ϸ� 
	        e.printStackTrace();//������ ���
	    } finally {
	        try {
	            stmt.close();  // ����� Statement ��ü�� �ݽ��ϴ�.
	        } catch (SQLException e) {
	            e.printStackTrace();//������ ���
	        }
	        try {
	            conn.close();  // ����� Connection ��ü�� �ݽ��ϴ�.
	        } catch (SQLException e) {
	            e.printStackTrace();//������ ���
	        }
	    }
	}


	@Override
	// examtable ���̺��� �����ϴ� �Լ��Դϴ�.
	public String createTable() {
	    String errorMessage = ""; // ������ �����ֱ� ���� ���ڿ� ���� ����

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

	        stmt.close(); // Statement ��ü�� �ݽ��ϴ�.
	        conn.close(); // Connection ��ü�� �ݽ��ϴ�.
	    } catch (SQLException e) { // sql������ ������ ���� ��
	        errorMessage = e.getMessage(); // �����޽����� ����� ���ڿ��� ���
	    } catch (ClassNotFoundException e) { // Ŭ������ ã�� ���ϴ� ������ ���� ��
	        errorMessage = "����̹� �ε� ����: " + e.getMessage(); // �����޽����� ����� ���ڿ��� ���
	    }

	    if (!errorMessage.isEmpty()) { // ���� �����޽����� �ִٸ�
	        System.out.println("���� �߻�: " + errorMessage); // ����ϱ�
	    }
	    return errorMessage;//�����޽����� ��ȯ
	}


	@Override
	// examtable ���̺��� �����ϴ� �Լ��Դϴ�.
	public String dropTable() {
	    String errorMessage = ""; // ������ �����ֱ� ���� ���ڿ� ���� ����

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

	        stmt.close(); // Statement ��ü�� �ݽ��ϴ�.
	        conn.close(); // Connection ��ü�� �ݽ��ϴ�.

	    } catch (SQLException e) { // sql������ ������ ���� ��
	        errorMessage = e.getMessage(); // �����޽����� ����� ���ڿ��� ���
	    } catch (ClassNotFoundException e) { // Ŭ������ ã�� ���ϴ� ������ ���� ��
	        errorMessage = "����̹� �ε� ����: " + e.getMessage(); // �����޽����� ����� ���ڿ��� ���
	    }

	    if (!errorMessage.isEmpty()) { // ���� �����޽����� �ִٸ�
	        System.out.println("���� �߻�: " + errorMessage); // ����ϱ�
	    }
	    return errorMessage;//�����޽����� ��ȯ
	}


	@Override
	// examtable ���̺� ��� �����͸� �����ϴ� �Լ��Դϴ�.
	public String insertAll() {
	    String errorMessage = ""; // ������ �����ֱ� ���� ���ڿ� ���� ����
	    try {
	        // "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
	        // MySQL �����ͺ��̽����� ����
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
	        // getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement ��ü�� �����մϴ�.
	        Statement stmt = conn.createStatement();

	        for (int i = 0; i < 150; i++) { // i�� 0���� 149���� 150�� �ݺ��ϴ� �ݺ���
	            int cnt = i + 1;//�̸��ڿ� ���ڸ� ���̱� ���� cnt ���� ����
	            String name = "ȫ��" + cnt;//������� cnt�� ȫ��ڿ� �ϳ��� ���̸鼭 �̸��� ����
	            int studentid = 209900 + cnt;//�й��� ����� ���� �ʱⰪ 209900�� cnt�� ���ؼ� studentid�� ����
	            //������� ������ insert�ϴ� ���� �ѹ� ����
	            stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat) VALUE ('" + name + "', "
	                    + studentid + "," + "rand()*100, rand()*100, rand()*100);");
	        }
	        // ������ ���� �� ���� ����ϱ�
	        System.out.println("������ �Է� OK");

	        stmt.close(); // Statement ��ü�� �ݽ��ϴ�.
	        conn.close(); // Connection ��ü�� �ݽ��ϴ�.
	    } catch (SQLException e) { // sql������ ������ ���� ��
	        errorMessage = e.getMessage(); // �����޽����� ����� ���ڿ��� ���
	    } catch (ClassNotFoundException e) { // Ŭ������ ã�� ���ϴ� ������ ���� ��
	        errorMessage = "����̹� �ε� ����: " + e.getMessage(); // �����޽����� ����� ���ڿ��� ���
	    }

	    if (!errorMessage.isEmpty()) { // ���� �����޽����� �ִٸ�
	        System.out.println("���� �߻�: " + errorMessage); // ����ϱ�
	    }
	    return errorMessage;//�����޽����� ��ȯ
	}


	@Override
	public int peopleCount() {//�湮�� ���� ���� �Լ� 
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
			// countpeople���� ��ü ���� ��ȸ�ϴ� ����
			rset = stmt.executeQuery("SELECT * FROM countpeople;");

			while (rset.next()) {
				peopleCount = rset.getInt(1);
			}

			System.out.println("�� : " + peopleCount);

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {//������ �߻��ϸ�
			e.printStackTrace();//������ ���
		}
		return peopleCount;//�湮�� ���� ��ȯ
	}

	@Override
	public int updatePeopleCount(int peopleCount) {
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			//�湮�� ���� ������Ʈ �ϴ� ������ ����
			String query = "UPDATE countpeople SET countnum = " + peopleCount;
			int rowsAffected = stmt.executeUpdate(query);//������ �����ϰ� ����� ������ ������ ���

			System.out.println("�湮�ڼ� ������Ʈ ����");//�湮�ڼ� ������Ʈ ������ ���

			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {//������ �߻��ϸ�
			e.printStackTrace();//������ ���
		}

		return peopleCount;//������Ʈ�� �湮�� ���� ������Ʈ
	}

	@Override
	// �־��� ���̺���� �����ϴ��� Ȯ���ϴ� �Լ��Դϴ�.
	public boolean isTableExists(String tableName) {
	    boolean tableExists = false;
	    try {
	        // JDBC ����̹� Ŭ������ �������� �ε��մϴ�.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement ��ü�� �����մϴ�.
	        stmt = conn.createStatement();
	        String table = "kopo27";

	        // �־��� ���̺���� ���� ��Ű�� ���� �����ϴ��� Ȯ���ϴ� ������ �����մϴ�.
	        String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + table
	                + "' AND table_name = '" + tableName + "'";
	         rset = stmt.executeQuery(query);

	        //rset ��ü�� rset���� ����� �����ͼ� rset.getInt(1)�� ��� ������ ù ��° ���� ���� ��������
	         //���� 0���� ū ���, ���̺��� �����ϴ� ��� tableExists ������ true�� �����մϴ�.
	        while (rset.next()) {
	            int count = rset.getInt(1);
	            if (count > 0) {
	                tableExists = true;
	            }
	        }

	        rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

	    } catch (Exception e) {//������ �߻��ϸ� 
	        e.printStackTrace();//�������
	    }
	    return tableExists;//���̺��� ���������� ��ȯ
	}

	@Override
	// �־��� �л� name�� �ش��ϴ� �л� ���� �����͸� ��ȯ
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
			//�Ķ���ͷ� ���� name���� ���� name�� �л� ���� �����͸� �������� ������ �����Ѵ�.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE name = '" + name + "';");
			
			// ResultSet���� �����͸� �о�� StudentScore ��ü�� �����մϴ�.
			while (rset.next()) {
			    // ���ο� StudentScore ��ü�� �����մϴ�.
			    studentScore = new StudentScore();

			    // ResultSet���� �� �÷��� ���� �����ͼ� StudentScore ��ü�� �����մϴ�.
			    studentScore.setId(rset.getInt("ID"));  // ID �÷� �� ����
			    studentScore.setName(rset.getString("NAME"));  // NAME �÷� �� ����
			    studentScore.setStudentid(rset.getInt("STUDENTID"));  // STUDENTID �÷� �� ����
			    studentScore.setKor(rset.getInt("kor"));  // kor �÷� �� ����
			    studentScore.setEng(rset.getInt("eng"));  // eng �÷� �� ����
			    studentScore.setMat(rset.getInt("mat"));  // mat �÷� �� ����
			    studentScore.setSum(rset.getInt("sum"));  // sum �÷� �� ����
			    studentScore.setAve(rset.getInt("ave"));  // ave �÷� �� ����
			    studentScore.setRanking(rset.getInt("ranking"));  // ranking �÷� �� ����
			}

			rset.close();// ����� ResultSet ��ü �ݱ�
			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		}catch (Exception e) {// ������ �߻��ϸ�
			e.printStackTrace();// ������ ���
		}
		return studentScore;// �־��� �л� name�� �ش��ϴ� �л� ���� �����͸� ��ȯ
	}
}

package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Basic_Traning_3_score {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt = k27_conn.createStatement();//��ü �л��� ���κ� ����/����/����� ������ Statement ��ü
		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt1 = k27_conn.createStatement();//�������� ����/����� ������ Statement ��ü
		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt2 = k27_conn.createStatement();//���� ����/����� ������ Statement ��ü

		System.out.println("                              ��������ǥ");//���
		LocalDateTime time_k27 = LocalDateTime.now();// ����ð��ҷ�����
		String k27_time = time_k27.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// ��¥ ��� ���� ������

		int k27_page = 1;//������ ���� ���� �� �ʱ�ȭ
		for (int i = 0; i < 1000; i += 30) {//����ǥ ����� ���� �ݺ��� -> �ѹ� �ݺ��� i���� 30�� ����
			// ������ ��� ���
 			System.out.println("PAGE: " + k27_page + "                                          ������� : " + k27_time);
			System.out.println("==============================================================================");
			System.out.println("��ȣ        �̸�          ����        ����        ����        ����         ���");
			System.out.println("==============================================================================");


			// ������� ������ Statement�� executeQuery�޼ҵ��� ���ڷ� ������
			String k27_QueryTxt = String.format(//��ü �л��� ��ȣ, �̸�, ����, ����, ��Ȯ, ����, ����� 30���� �������� ���� �ۼ�
					"select *, kor+eng+mat as totalsum ,floor((kor+eng+mat)/3) as totalavg from score limit %d,30;", i);
			//������ ������� �������� ResultSet�� �Ҵ��Ͽ� ���
			ResultSet k27_rset = k27_stmt.executeQuery(k27_QueryTxt);
			while (k27_rset.next()) {//������ ������� �ִٸ�
				//ĭ���� �����ְ� ��� -> �л��� ��ȣ, �̸�, ����, ����, ��Ȯ, ����, ����� ResultSet���� �����ͼ� ���
				System.out.printf("%04d   %8s%11s%11s%11s%11s%11s\n", k27_rset.getInt(1),
						k27_rset.getString(2), k27_rset.getString(3), k27_rset.getString(4), k27_rset.getString(5), k27_rset.getString(6),
						k27_rset.getString(7));// ������ ������ ���
			}
			k27_page++;// 30�� ����Ҷ����� ī��� �ø���

			System.out.println("==============================================================================");//�ٳ�����

			// ������� ������ Statement�� executeQuery�޼ҵ��� ���ڷ� ������
			String k27_QueryTxt1 = String.format(//30���� ����, ����, ��Ȯ, ����, ����� �հ�� ����� �������� ����
					"select sum(a.kor) , sum(a.eng), sum(a.mat), sum(a.totalsum), sum(a.totalavg), "
					+ "floor(avg(a.kor)), floor(avg(a.eng)), floor(avg(a.mat)), floor(avg(a.totalsum)), floor(avg(a.totalavg))"
					+ "from (select *, (kor+eng+mat) as totalsum ,floor((kor+eng+mat)/3) as totalavg from score limit %d,30) as a;",
					i);
			//������ ������� �������� ResultSet�� �Ҵ��Ͽ� ���
			ResultSet k27_rset1 = k27_stmt1.executeQuery(k27_QueryTxt1);

			while (k27_rset1.next()) {//������ ������� �ִٸ�
				//ĭ���� �����ְ� ��� -> 30���� ����, ����, ��Ȯ, ����, ����� �հ�� ����� ���
				System.out.printf("�հ�   %21s%11s%11s%11s%11s\n", k27_rset1.getString(1), k27_rset1.getString(2),
						k27_rset1.getString(3), k27_rset1.getString(4), k27_rset1.getString(5));// ���
				System.out.printf("���   %21s%11s%11s%11s%11s\n", k27_rset1.getString(6), k27_rset1.getString(7),
						k27_rset1.getString(8), k27_rset1.getString(9), k27_rset1.getString(10));// ���
			}

			System.out.println("==============================================================================");//�ٳ�����
			
			// ������� ������ Statement�� executeQuery�޼ҵ��� ���ڷ� ������
			String k27_QueryTxt2 = String.format(//0���� i+30���� ������ ������ �л��� ����, ����, ��Ȯ, ����, ����� �հ�� ����� ���
					"select sum(a.kor), sum(a.eng), sum(a.mat), sum(a.totalsum), sum(a.totalavg),"
					+ "floor(avg(a.kor)), floor(avg(a.eng)), floor(avg(a.mat)), floor(avg(a.totalsum)), floor(avg(a.totalavg))"
					+ "from (select *, kor+eng+mat as totalsum ,floor((kor+eng+mat)/3) as totalavg from score limit 0, %d) as a;",
					i + 30);
			//������ ������� �������� ResultSet�� �Ҵ��Ͽ� ���
			ResultSet k27_rset2 = k27_stmt2.executeQuery(k27_QueryTxt2);

			while (k27_rset2.next()) {
				//ĭ���� �����ְ� ��� -> ������ �л��� ����, ����, ��Ȯ, ����, ����� ���� �հ�� ���� ����� ���
				System.out.printf("���� �հ� %19s%11s%11s%11s%11s\n", k27_rset2.getString(1), k27_rset2.getString(2),
						k27_rset2.getString(3), k27_rset2.getString(4), k27_rset2.getString(5));// ���
				System.out.printf("���� ��� %19s%11s%11s%11s%11s\n", k27_rset2.getString(6), k27_rset2.getString(7),
						k27_rset2.getString(8), k27_rset2.getString(9), k27_rset2.getString(10));// ���
				System.out.println();//�ٳѱ�
				System.out.println();//�ٳѱ�
			}
			k27_rset.close();// k27_rset ��ü�� �ݽ��ϴ�.
			k27_rset1.close();// k27_rset1 ��ü�� �ݽ��ϴ�.
			k27_rset2.close();// k27_rset2 ��ü�� �ݽ��ϴ�.
		}
		k27_stmt.close();// Statement ��ü�� �ݽ��ϴ�.
		k27_conn.close();// Connection ��ü�� �ݽ��ϴ�.
	}
}

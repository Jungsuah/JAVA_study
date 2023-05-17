package daily0516;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Advantage_1_table_���� {
	public static void main(String[] args) throws ClassNotFoundException{
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		Connection k27_conn = null;
		try {
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� ����
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ���� ���
		}

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt= null;
		try {
			//conn��ü�� createStatement�� �޼ҵ带 ����� Statement ��ü�� �Ҵ��Ѵ�.
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ���� ���
		}
		
		try {//stock ���̺��� �����ϴ� ���� �ۼ�
			k27_stmt.execute("create table stock("+
	                   "stnd_iscd varchar(200) not null,"+//�������� ���� �����ڵ�
	                   "bsop_date int not null,"+//�ֽ� ���� ���� 
	                   "stck_prpr   int ,"+//�ֽ� ���� 
	                   "stck_oprc int,"+//�ֽ� �ð� 
	                   "stck_hgpr int,"+//�ֽ� �ְ�
	                   "stck_lwpr int,"+//�ֽ� ������
	                   "acml_vol long,"+//���� �ŷ��� 
	                   "acml_tr_pbmn long,"+//���� �ŷ� ���
					   "primary key(bsop_date,stnd_iscd));" );//�ֽ� ���� ����,������ ���� pk�� ���
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		
		try {
			// Statement ��ü�� �ݽ��ϴ�.
			k27_stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		try {
			// Connection ��ü�� �ݽ��ϴ�.
			k27_conn.close();
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
	}
}

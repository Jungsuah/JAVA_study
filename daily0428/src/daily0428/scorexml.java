package daily0428;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class scorexml {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// 파싱을 위한 준비
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// xml 파일을 처리하기 위해 전체 경로를 지정하고, 파싱 처리를 시작함
		Document doc = docBuilder.parse(new File("C:\\Users\\정수아\\Documents\\Documents\\score.xml"));
		// XML의 루트 요소를 얻음
		Element root = doc.getDocumentElement();
		// 각 태그의 값을 가져오기 위해 NodeList 생성
		NodeList tag_name = doc.getElementsByTagName("name");
		NodeList tag_studentid = doc.getElementsByTagName("studentid");
		NodeList tag_kor = doc.getElementsByTagName("kor");
		NodeList tag_eng = doc.getElementsByTagName("eng");
		NodeList tag_mat = doc.getElementsByTagName("mat");
		// 출력 준비
		System.out.printf("******************\n");
		// NodeList의 길이만큼 반복하여 각 태그의 값을 출력함
		for (int i = 0; i < tag_name.getLength(); i++) {
			System.out.printf("이름 : %s\n", tag_name.item(i).getFirstChild().getNodeValue());
			System.out.printf("학번 : %s\n", tag_studentid.item(i).getFirstChild().getNodeValue());
			System.out.printf("국어 : %s\n", tag_kor.item(i).getFirstChild().getNodeValue());
			System.out.printf("영어 : %s\n", tag_eng.item(i).getFirstChild().getNodeValue());
			System.out.printf("수학 : %s\n", tag_mat.item(i).getFirstChild().getNodeValue());
			System.out.printf("******************\n");
		}
	}
}

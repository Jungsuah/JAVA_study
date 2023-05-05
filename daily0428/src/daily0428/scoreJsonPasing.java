package daily0428;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class scoreJsonPasing {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException { // main 메서드 선언 시작

		// JSON 파서 객체 생성
		JSONParser k27_parser = new JSONParser();

		// JSON 파일을 FileReader를 사용해 읽어와서 파싱하여 Object에 저장
		Object k27_obj = k27_parser.parse(new FileReader("C:\\Users\\정수아\\Documents\\Documents\\score.json"));

		// Object를 JSONObject로 캐스팅
		JSONObject k27_jsonObject = (JSONObject) k27_obj;

		// JSONObject에서 "datas" 키를 가진 JSONArray를 가져옴
		JSONArray k27_array = (JSONArray) k27_jsonObject.get("datas");

		// for문을 이용해 JSONArray에서 JSONObject를 하나씩 가져와 출력
		System.out.println("****************");
		for (int k27_i = 0; k27_i < k27_array.size(); k27_i++) {

			// JSONArray에서 JSONObject를 하나씩 가져옴
			JSONObject k27_result = (JSONObject) k27_array.get(k27_i);

			// JSONObject에서 "name"과 "studentid"를 가져와 출력
			System.out.println("이름 : " + k27_result.get("name"));
			System.out.println("학번 : " + k27_result.get("studentid"));

			// JSONObject에서 "score"를 가져와 JSONObject로 캐스팅
			JSONObject k27_score = (JSONObject) k27_result.get("score");

			// JSONObject에서 "kor", "eng", "mat"을 가져와 출력
			long k27_kor = (long) k27_score.get("kor");
			long k27_eng = (long) k27_score.get("eng");
			long k27_mat = (long) k27_score.get("mat");
			System.out.println("국어 : " + k27_kor);
			System.out.println("영어: " + k27_eng);
			System.out.println("수학: " + k27_mat);

			// 총점과 평균을 계산하여 출력
			System.out.println("총점 : " + (k27_kor + k27_eng + k27_mat));
			System.out.println("총점 : " + (k27_kor + k27_eng + k27_mat));
			System.out.println("평균 : " + ((k27_kor + k27_eng + k27_mat) / 3.0));
			System.out.println("****************");
		}
	} // main 메서드 선언 종료
}

package daily0428;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class scoreJsonPasing {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{ // TODO
																										
		JSONParser k27_parser = new JSONParser();
		Object k27_obj = k27_parser.parse(new FileReader("C:\\Users\\정수아\\Documents\\Documents\\score.json"));
		JSONObject k27_jsonObject = (JSONObject) k27_obj; 
//		JSONArray array = (JSONArray) obj; 
		JSONArray k27_array = (JSONArray) k27_jsonObject.get("datas");
		
		
		System.out.println("****************");
		for (int k27_i = 0; k27_i < k27_array.size(); k27_i++) {
			JSONObject k27_result = (JSONObject) k27_array.get(k27_i);
			System.out.println("이름 : " + k27_result.get("name"));
			System.out.println("학번 : " + k27_result.get("studentid"));

//			JSONArray score = (JSONArray) result.get("score");
			JSONObject k27_score = (JSONObject) k27_result.get("score");
			long k27_kor = (long) k27_score.get("kor");
			long k27_eng = (long) k27_score.get("eng");
			long k27_mat = (long) k27_score.get("mat");
			System.out.println("국어 : " + k27_kor);
			System.out.println("영어: " + k27_eng);
			System.out.println("수학: " + k27_mat);
			System.out.println("총점 : " + (k27_kor + k27_eng + k27_mat));
			System.out.println("총점 : " + (k27_kor + k27_eng + k27_mat));
			System.out.println("평균 : " + ((k27_kor + k27_eng + k27_mat) / 3.0));
			System.out.println("****************");
		}
	}
}

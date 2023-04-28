package daily0428;

import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class scoreJsonMake {

	@SuppressWarnings("unchecked")
	public static JSONObject oneRec(String name, int studentid, int kor, int eng, int mat) {
		JSONObject k27_dataObject = new JSONObject();
		k27_dataObject.put("name", name);
		k27_dataObject.put("studentid", studentid);
		// Json Array 생성.
		JSONArray k27_score = new JSONArray();
		k27_score.add(kor);
		k27_score.add(eng);
		k27_score.add(mat);
		k27_dataObject.put("score", k27_score);
		return k27_dataObject;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 최종 완성될 JSONObject 선언(전체) JSONObject jsonObject = new JSONObject(); // 한명 성적의
		// JSON정보를 담을 Array 선언 JSONArray datasArray = new JSONArray();
		// 한명 정보가 들어갈 JSONObject 선언 JSONObject dataObject = new JSONObject();
		// dataObject.put("name", ""); dataObject.put("studentid", 209901);
		// Json Array 생성
		JSONObject k27_jsonObject = new JSONObject();
		JSONArray k27_datasArray = new JSONArray();

		JSONObject k27_dataObject = new JSONObject();
		k27_dataObject.put("name", "나연");
		k27_dataObject.put("studentid", 209901);
		JSONArray k27_score = new JSONArray();
		k27_score.add(90);
		k27_score.add(100);
		k27_score.add(95);
		k27_dataObject.put("score", k27_score);
		k27_datasArray.add(k27_dataObject);
		// 깔끔하게 함수 처리
		k27_datasArray.add(oneRec("정연", 209902, 100, 85, 75));
		k27_datasArray.add(oneRec("모모", 209903, 90, 75, 85));
		k27_datasArray.add(oneRec("사나", 209904, 90, 85, 75));
		k27_datasArray.add(oneRec("지효", 209905, 80, 75, 85));
		k27_datasArray.add(oneRec("미나", 209906, 90, 85, 55));
		k27_datasArray.add(oneRec("다연", 209907, 70, 75, 65));
		k27_datasArray.add(oneRec("채영", 209908, 100, 75, 95));
		k27_datasArray.add(oneRec("쯔위", 209909, 80, 65, 95));

		try {
			FileWriter k27_file = new FileWriter("C:\\Users\\nahyun\\test.json");
			k27_file.write(k27_datasArray.toJSONString());
			k27_file.flush();
			k27_file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JSON : " + k27_datasArray);
	}
}
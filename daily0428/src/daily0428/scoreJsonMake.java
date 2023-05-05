package daily0428;

import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class scoreJsonMake {

    // 한 학생의 성적 정보를 JSON 객체로 만들어주는 함수
    @SuppressWarnings("unchecked")
    public static JSONObject oneRec(String name, int studentid, int kor, int eng, int mat) {
        JSONObject k27_dataObject = new JSONObject();
        k27_dataObject.put("name", name); // 이름 정보
        k27_dataObject.put("studentid", studentid); // 학생 번호 정보

        // 과목별 성적 정보를 담을 JSON 배열 생성
        JSONArray k27_score = new JSONArray();
        k27_score.add(kor); // 국어 성적 추가
        k27_score.add(eng); // 영어 성적 추가
        k27_score.add(mat); // 수학 성적 추가

        k27_dataObject.put("score", k27_score); // 성적 정보를 JSON 객체에 추가
        return k27_dataObject; // 완성된 JSON 객체 반환
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // 최종 완성될 JSON 객체 선언
        JSONObject jsonObject = new JSONObject();

        // 학생들의 성적 정보가 들어갈 JSON 배열 선언
        JSONArray datasArray = new JSONArray();

        // 한 명의 성적 정보가 들어갈 JSON 객체 선언
        JSONObject dataObject = new JSONObject();
        dataObject.put("name", ""); // 이름 정보(빈 값)
        dataObject.put("studentid", 209901); // 학생 번호 정보(기본값)
        
        // K27: 불필요한 변수 선언 및 초기화 부분 제거
        JSONObject k27_jsonObject = new JSONObject();
        JSONArray k27_datasArray = new JSONArray();

        // JSON 객체를 이용하여 한 명의 성적 정보를 생성하고, 이를 JSON 배열에 추가
        JSONObject k27_dataObject = new JSONObject();
        k27_dataObject.put("name", "나연"); // 이름 정보
        k27_dataObject.put("studentid", 209901); // 학생 번호 정보
        JSONArray k27_score = new JSONArray();
        k27_score.add(90); // 국어 성적 추가
        k27_score.add(100); // 영어 성적 추가
        k27_score.add(95); // 수학 성적 추가
        k27_dataObject.put("score", k27_score); // 성적 정보를 JSON 객체에 추가
        k27_datasArray.add(k27_dataObject); // 생성된 JSON 객체를 JSON 배열에 추가

        // 함수를 이용하여 각 학생들의 성적 정보를 생성하고, 이를 JSON 배열에 추가
		k27_datasArray.add(oneRec("정연", 209902, 100, 85, 75));
		k27_datasArray.add(oneRec("모모", 209903, 90, 75, 85));
		k27_datasArray.add(oneRec("사나", 209904, 90, 85, 75));
		k27_datasArray.add(oneRec("지효", 209905, 80, 75, 85));
		k27_datasArray.add(oneRec("미나", 209906, 90, 85, 55));
		k27_datasArray.add(oneRec("다연", 209907, 70, 75, 65));
		k27_datasArray.add(oneRec("채영", 209908, 100, 75, 95));
		k27_datasArray.add(oneRec("쯔위", 209909, 80, 65, 95));

		try {// 파일 출력시 예외 발생 여부를 처리하기 위해 사용
			//FileWriter를 이용해 C:\Users\nahyun\test.json 경로에 파일을 생성하고 JSON 형태로 데이터를 작성
			FileWriter k27_file = new FileWriter("C:\\Users\\nahyun\\test.json");
			//JSON 형태의 문자열로 변환
			k27_file.write(k27_datasArray.toJSONString());
			//버퍼에 남아있는 데이터를 모두 출력
			k27_file.flush();
			//close() 메서드를 이용해 파일을 닫기
			k27_file.close();
		} catch (IOException e) {
			//예외가 발생할 경우 printStackTrace() 메서드를 이용해 예외 내용을 출력
			e.printStackTrace();
		}
		//성적 정보를 출력
		System.out.println("JSON : " + k27_datasArray);
	}
}
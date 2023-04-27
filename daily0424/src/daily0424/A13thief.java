package daily0424;

import java.util.*;
//어려움 질문할거 많음
class Info implements Comparable<Info>{   //인터페이스를 상속받는 Info클래스 선언
 public String name;
 public int time;
 Info(String name, int time){   //클래스의 기본생성자
    this.name = name;
    this.time = time;
 }

 @Override
 public int compareTo(Info ob) {   //Info타입의 객체를 compareTo의 파라미터로 받는다
    //System.out.println("compare out : " + (this.time - ob.time));
    return this.time - ob.time;
//    return this.name.compareTo(ob.name);
 }   
}
public class A13thief {
 public int getTime(String time) {
    int H = Integer.parseInt(time.split(":")[0]);
    int M = Integer.parseInt(time.split(":")[1]);
    return H*60+M;
    //문자열로 입력된 시간을 분단위 integer로 바꿔주는 메소드
 }
 
 public String[] solution(String[] reports, String times){
    //String[] answer = {};
    ArrayList<Info> tmp = new ArrayList<>();
    for(String x : reports) {
       //reports의 모든 키 값을 순회하며 반복문 실행. 현재 키 값을 x에 할당
       String a = x.split(" ")[0];   //이름
       String b = x.split(" ")[1];   //보안키 사용시간
       tmp.add(new Info(a, getTime(b)));
    }
    Collections.sort(tmp);   //오름차순 정렬
    
    int s = getTime(times.split(" ")[0]);   //도난 추정시작시간
    Info startTime = new Info("startTime", s);
    int e = getTime(times.split(" ")[1]);   //도난 추정마지막시간
    Info endTime = new Info("endTime", e);
          
    ArrayList<String> res = new ArrayList<>();   //출력할 대상을 담기위해 문자열형 list를 선언
    for(Info ob : tmp) {
       if(ob.compareTo(startTime) >= 0 && ob.compareTo(endTime) <= 0) {
          //보안키 사용시간이 도난추정시간 이내에 걸리면
          res.add(ob.name);   //해당자를 res에 추가한다
       }
       if(ob.compareTo(endTime) > 0) break;   //추정시간에 걸리지 않으면 break
    }
    String[] answer = new String[res.size()];   //출력할 대상을 담기 위해 문자열형 배열 선언
    for(int i = 0; i < res.size(); i++) {
       answer[i] = res.get(i);
       //res를 answer배열에 담아줌
    }
    return answer;
 }

 public static void main(String[] args){
    A13thief T = new A13thief();
    System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
    System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
    System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
 }
}
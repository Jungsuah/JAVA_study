package daily0424;

import java.util.*;
//����� �����Ұ� ����
class Info implements Comparable<Info>{   //�������̽��� ��ӹ޴� InfoŬ���� ����
 public String name;
 public int time;
 Info(String name, int time){   //Ŭ������ �⺻������
    this.name = name;
    this.time = time;
 }

 @Override
 public int compareTo(Info ob) {   //InfoŸ���� ��ü�� compareTo�� �Ķ���ͷ� �޴´�
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
    //���ڿ��� �Էµ� �ð��� �д��� integer�� �ٲ��ִ� �޼ҵ�
 }
 
 public String[] solution(String[] reports, String times){
    //String[] answer = {};
    ArrayList<Info> tmp = new ArrayList<>();
    for(String x : reports) {
       //reports�� ��� Ű ���� ��ȸ�ϸ� �ݺ��� ����. ���� Ű ���� x�� �Ҵ�
       String a = x.split(" ")[0];   //�̸�
       String b = x.split(" ")[1];   //����Ű ���ð�
       tmp.add(new Info(a, getTime(b)));
    }
    Collections.sort(tmp);   //�������� ����
    
    int s = getTime(times.split(" ")[0]);   //���� �������۽ð�
    Info startTime = new Info("startTime", s);
    int e = getTime(times.split(" ")[1]);   //���� �����������ð�
    Info endTime = new Info("endTime", e);
          
    ArrayList<String> res = new ArrayList<>();   //����� ����� ������� ���ڿ��� list�� ����
    for(Info ob : tmp) {
       if(ob.compareTo(startTime) >= 0 && ob.compareTo(endTime) <= 0) {
          //����Ű ���ð��� ���������ð� �̳��� �ɸ���
          res.add(ob.name);   //�ش��ڸ� res�� �߰��Ѵ�
       }
       if(ob.compareTo(endTime) > 0) break;   //�����ð��� �ɸ��� ������ break
    }
    String[] answer = new String[res.size()];   //����� ����� ��� ���� ���ڿ��� �迭 ����
    for(int i = 0; i < res.size(); i++) {
       answer[i] = res.get(i);
       //res�� answer�迭�� �����
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
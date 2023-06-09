package daily0410;

public class ppt7_4 {
	public static void main(String[] args) { // 메인함수 선언
	    String [] OneRec_k27 = {   //문자열형 배열인 OneRec를 선언하며 배열에 값을 담아준다
	            "구분연월,행태별(개별여행),행태별(부분패키지),행태별(패키지),목적별(레저스포츠),목적별(회의및업무),목적별(휴양및관람),목적별(친지방문),목적별(교육여행),목적별(기타방문),데이터기준일자",
	            "2021-01,441595,21627,2450,66786,24075,296742,67606,0,10463,2021-12-31",
	            "2021-02,778290,12422,0,62141,57452,588701,73437,0,8981,2021-12-31",
	            "2021-03,849441,31129,8646,78458,93387,643293,55459,0,18619,2021-12-31",
	            "2021-04,1034696,30652,13411,72673,65902,871832,55939,0,12413,2021-12-31",
	            "2021-05,1106333,21629,4406,62320,55769,903956,106745,80,3498,2021-12-31",
	            "2021-06,1118567,13446,2241,68387,60504,934448,62745,0,8170,2021-12-31",
	            "2021-07,1101365,21266,4254,36274,73069,968782,32663,0,16097,2021-12-31",
	            "2021-08,942540,21839,5439,43445,51875,848667,18128,0,7703,2021-12-31",
	            "2021-09,846565,20806,0,74382,40312,556900,173601,0,22176,2021-12-31",
	            "2021-10,953193,191222,73740,159009,203258,770962,76544,15,8367,2021-12-31",
	            "2021-11,980793,134590,84664,114236,97990,884800,66931,703,35387,2021-12-31",
	            "2021-12,862572,128164,96166,183629,110943,708458,54437,1077,28358,2021-12-31"
	         };
	         
	         String [] field_name_k27 = OneRec_k27[0].split(",");
	         //배열의 0번째 변수를 쉼표를 기준으로 분해하여 field_name배열에 담아준다
	         for(int i_k27 = 1; i_k27 < OneRec_k27.length-1 ; i_k27++) {
	         //OneRec배열의 1번째부터 마지막까지 for문을 돌며 하나씩 살펴본다
	            
	            String [] field_k27 = OneRec_k27[i_k27].split(",");
	            //배열의 0번째 변수를 쉼표를 기준으로 분해하여 field배열에 담아준다
	            for (int j_k27 = 1; j_k27 < 10; j_k27++) {   //숫자의 한글표시변환을 위해 field배열의 1번째부터 9번째까지 살펴본다
	                     
	            int iNumVal_k27 = Integer.parseInt(field_k27[j_k27]);   //정수형 변수로 선언
	            String sNumVal_k27 = String.valueOf(iNumVal_k27);   //문자열로 형변환하여 String변수에 할당함
	            String sNumVoice_k27 = "";    //String형 변수 선언, 빈 문자열
	            
	            int k27_i, k27_j;   //정수형 변수 선언
	                  
	            String [] k27_units = {"영","일","이","삼","사","오","육","칠","팔","구"};   //문자열 배열 선언, 숫자의 한글표시 10개를 값으로 할당함
	            String [] k27_unitX = {"","십","백","천","만 ","십","백","천","억","십"};   //문자열 배열 선언, 숫자단위의 한글표시 10개를 값으로 할당함
	                  
	            k27_i = 0;   //i는 0, 루프횟수를 카운트하는 변수
	            k27_j = sNumVal_k27.length() - 1;   //j는 문자열의 길이에서 -1한 값, 배열unitX의 마지막변수부터 차례대로 읽어들인다
	                  
	            while(true) {
	               if(k27_i >= sNumVal_k27.length()) break;   //루프의 횟수가 문자열의 길이수와 일치하면 루프를 벗어난다
	                  
	               if(sNumVal_k27.substring(k27_i, k27_i+1).equals("0")) {   
	                  //substring함수로 뽑아온 sNumVal문자열의 i번째 문자가 0일 때                     
	                     if(k27_unitX[k27_j].equals("만") || k27_unitX[k27_j].equals("억")) {   //unitX배열의 j번째 변수가 만이거나 억일때
	                        if (k27_i > 2 && sNumVal_k27.substring(k27_i-3, k27_i).equals("000")) {   //십만, 백만, 천만의 자리가 모두 0일 때
	                           //i > 2는 OutOfBoundException을 방지하기 위한 것 문자열의 0,1,2번째 자리는 i-3에서 오류가 발생한다
	                           sNumVoice_k27 = sNumVoice_k27 + "";      //만단위 출력을 생략한다
	                        } else {
	                           sNumVoice_k27 = sNumVoice_k27 + "" + k27_unitX[k27_j];      //단위를 붙여준다
	                        }
	                     } else {
	                        //억, 만자리 외에는 해당자리가 0이어도 단위값을 붙이지 않는다
	                     }
	               } else {
	                  sNumVoice_k27 = sNumVoice_k27 + k27_units[Integer.parseInt(sNumVal_k27.substring(k27_i, k27_i+1))] + k27_unitX[k27_j];
	                  //substring함수로 뽑아온 sNumVal문자열의 i번째 문자가 0일 때 이외에는 해당숫자값과 단위값을 모두 붙여준다            
	               }
	               k27_i++;    //i는 0부터 시작하여 루프마다 1씩 증가하며 루프의 횟수를 카운트한다
	               k27_j--;   //j는 문자열의 길이에서 -1한 값으로 루프마다 1씩 감소한다, unitX에서 읽어들일 변수를 앞으로 한자리씩 당긴다         
	            }               
	            if(iNumVal_k27 == 0) {   //0일 때
	               sNumVoice_k27 = k27_units[0];   //"영"출력
	            }            
	            field_k27[j_k27] = sNumVoice_k27;   //해당 숫자들의 한글표시를 배열에 다시 담아준다
	            }   
	               
	            System.out.printf("*************************************************\n"); //구분선 출력
	            for (int h_k27 = 0; h_k27 < field_name_k27.length; h_k27++) {   //field_name배열의 0번째부터 마지막까지 for문을 돌며      
	               System.out.printf(" %s : %s\n", field_name_k27[h_k27], field_k27[h_k27]);
	               //field_name배열과 field배열의 h번째 변수의 정보를 출력해준다
	            }
	            System.out.printf("*************************************************\n"); //구분선 출력
	         }      

	}
}

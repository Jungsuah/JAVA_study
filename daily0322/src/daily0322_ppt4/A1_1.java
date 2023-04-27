package daily0322_ppt4;


public class A1_1 {//Dice
   int n, m;

   public A1_1() {
	   this(0, 0);
   }
   
   public A1_1(int n, int m) {
	   this.n = n;
	   this.m = m;
   }
public static void main(String[] args) {
	A1_1 a = new A1_1(3,1);
	a.printResult();
}
   public void printResult() {
      int[] dice = new int[n]; // make dice array size of n
      int sum = 0; // dice total sum
      String result = ""; // String to get result

      while (dice[0] <= m - n +1 ) { // while there is an available number for first dice
         if (dice[0] >= 1 && dice[0] <= 6) { // calculate only when first dice is between 1-6
            sum = 0; // initialize sum as 0 every loop
            for (int i = 0; i < n; i++) { // add numbers of dices at sum
               sum += dice[i];
            }
            if (sum == m) { // if sum is correct
               result += "("; // add result
               for (int i = 0; i < n; i++) {
                  result += dice[i];
                  if (i != n - 1) {
                     result += ",";
                  }
               }
               result += ")\n";
            }
         }
         dice[n - 1]++; // ++ last dice
         for (int i = n - 1; i > 0; i--) {  // from last dice ~ second dice
            if (dice[i] > 6) { // if dice[i] number is unavailable
               dice[i] = 1; // modify dice[i] as 1
               dice[i - 1]++; // previous dice ++;
            } else { // if dice[i] has no problem
               break;
            }
         }
      }
      // print result
      System.out.println(result);
   }
}
package daily0620_Regression_Analysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import com.opencsv.CSVReader;

public class P2 {

   public static double calculatePValue(double tValue, int degreesOfFreedom) {
       TDistribution tDistribution = new TDistribution(degreesOfFreedom);
       double pValue = 2.0 * (1.0 - tDistribution.cumulativeProbability(Math.abs(tValue)));
       return pValue;
   }
   
   public static void main(String[] args) {
      String readFileName = "C:\\Users\\a\\Desktop\\Sleep_health_and_lifestyle_dataset - 복사본.csv";

      try {
          CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "cp949"));


          OLSMultipleLinearRegression multipleRegression = new OLSMultipleLinearRegression();

          String[] header = csvReader.readNext(); 
          int independentVariableCount = header.length - 1; 

          List<double[]> independentVariablesList = new ArrayList<>();
          List<Double> dependentVariableList = new ArrayList<>();

          String[] line;
          while ((line = csvReader.readNext()) != null) {
              double[] independentVariables = new double[independentVariableCount];
              for (int i = 1; i <= independentVariableCount; i++) {
                  independentVariables[i - 1] = Double.parseDouble(line[i]);
              }
              independentVariablesList.add(independentVariables);
              dependentVariableList.add(Double.parseDouble(line[0]));
          }

          double[][] independentVariables = independentVariablesList.toArray(new double[0][0]);
          double[] dependentVariable = dependentVariableList.stream().mapToDouble(Double::doubleValue).toArray();

          multipleRegression.newSampleData(dependentVariable, independentVariables);

          System.out.println("[다중회귀분석 결과]\n");
          
          double[] coefficients = multipleRegression.estimateRegressionParameters();
          
          System.out.println("Intercept = " + coefficients[0]);
          for (int i = 0; i < independentVariableCount; i++) {
              System.out.println("Coefficient for variable " + (i + 1) + " = " + coefficients[i + 1]);
          }
          
          System.out.println();
          
          double[] inputVariables = new double[independentVariableCount]; 

          inputVariables[0] = 50; 
          inputVariables[1] = 56; 
          inputVariables[2] = 4; 
         // inputVariables[3] = 75; 
          //inputVariables[4] = 4200;
        

          double prediction = coefficients[0]; 
          for (int i = 0; i < independentVariableCount; i++) {
              prediction += coefficients[i + 1] * inputVariables[i];
          }
          System.out.println("Prediction = " + prediction);
          System.out.println();

          double totalSumOfSquares = multipleRegression.calculateTotalSumOfSquares();
          double residualSumOfSquares = multipleRegression.calculateResidualSumOfSquares();
          double rSquared = 1.0 - (residualSumOfSquares / totalSumOfSquares);
          System.out.println("R squared = " + rSquared);
          System.out.println();
          
          for (int i = 0; i < independentVariableCount; i++) {
              double tValue = coefficients[i + 1] / multipleRegression.estimateRegressionParametersStandardErrors()[i + 1];
              int degreesOfFreedom = dependentVariable.length - independentVariableCount - 1;
              double pValue = calculatePValue(tValue, degreesOfFreedom);
              System.out.println("p-value for variable " + (i + 1) + " = " + pValue);
          }

          csvReader.close();

          System.out.println("회귀분석 결과가 작성되었습니다.");

      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (Exception e) {
          e.printStackTrace();
      }
   }
}
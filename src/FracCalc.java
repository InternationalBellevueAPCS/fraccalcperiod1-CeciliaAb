
import java.util.*;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
       System.out.println("enter two fractions and an opporator (make sure there are spaces between the fractions and the opporator)");
       Scanner console = new Scanner(System.in);
       String input = " ";
       while (!(input.equals("0 + 0"))) { //allows user to use the calculator multiple times
    	   System.out.println("Enter equation:");
    	   input = console.nextLine();
    	   String y =produceAnswer(input);
    	   System.out.println(y);
       }
    }
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    // TODO: Implement this function to produce the solution to the input
    // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
    // Checkpoint 2: Return the second operand as a string representing each part.
    //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
    // Checkpoint 3: Evaluate the formula and return the result as a fraction.
    //               Example "4/5 * 1_2/4" returns "6/5".
    //               Note: Answer does not need to be reduced, but it must be correct.
    // Final project: All answers must be reduced.
    //               Example "4/5 * 1_2/4" returns "1_1/5".
    public static String produceAnswer(String input) { 
       if (input.indexOf(" ")<0) {
             System.out.println("Incorrect input");//invalid input entered
             return " ";
       }
       // "x" represents the first time we encounter a space in the input, I use this to determine where the first number is.
       int x = input.indexOf(" ");
       // The first number starts from the first index of the string and ends at the first space
       String first_num = input.substring(0,x);
       // the operand is one space after the first number
       String operator = input.substring(x+1,x+2);
       // the second number is one space after the operand, I don't know how long this number is so I leave the substring end 'open' to make sure I dont cut it off
       String second_num = input.substring(x+3);
       //first number is now being analyzed
       String whole_num_1 = whole_number(first_num);
       String numerator_1 = numerator(first_num);
       String denominator_1 = denominator(first_num);
       //second number is now being analyzed 
       String whole_num_2 = whole_number(second_num);
       String numerator_2 = numerator(second_num);
       String denominator_2 = denominator(second_num); 
       //done breaking up the equation
       int whole_number_1 = Integer.parseInt(whole_num_1);
       int numer_1 = Integer.parseInt(numerator_1);
       int denom_1 = Integer.parseInt(denominator_1);
       int whole_number_2 = Integer.parseInt(whole_num_2);
       int numer_2 = Integer.parseInt(numerator_2);
       int denom_2 = Integer.parseInt(denominator_2);
       
//if the operator is adding       
       if (operator.equals("+")) {      
             if (denom_1 == 1 && denom_2 == 1) {
                int sum = whole_number_1+whole_number_2;
                String ret = Integer.toString(sum);
                return ret;
             }
             // If num is a mixed number, convert to normal fraction
             numer_1 = MixedToFrac(whole_number_1,numer_1,denom_1);
             numer_2 = MixedToFrac(whole_number_2,numer_2,denom_2);
             
             // if denominators are not the same, covert them.
             if (denom_1 != denom_2) {
            	 int temp_1 = denom_1;
                 int temp_2 = denom_2;
                 denom_1*=temp_2;
                 numer_1*=temp_2;
                 denom_2*=temp_1;
                 numer_2*=temp_1;  
             } 
             numer_1+=numer_2;
             String answer = (Integer.toString(numer_1) + "/" + Integer.toString(denom_1));
             if (numer_1 == 0 || denom_1 == 0) {
                 return "0";
             } else
            	 return answer;
             
//if the operator is subtracting 
             
      } else if (operator.equals("-")) { 
             if (denom_1 == 1 && denom_2 == 1) {
                int sum = whole_number_1-whole_number_2;
                String ret = Integer.toString(sum);
                return ret;
             }
       // If num1 is a mixed number, convert to normal fraction
             numer_1 = MixedToFrac(whole_number_1,numer_1,denom_1);
             numer_2 = MixedToFrac(whole_number_2,numer_2,denom_2);     
             
             // if denominators are not the same, covert them.
             if (denom_1 != denom_2) {
            	 int temp_1 = denom_1;
                 int temp_2 = denom_2;
                 denom_1*=temp_2;
                 numer_1*=temp_2;
                 denom_2*=temp_1;
                 numer_2*=temp_1;  
             } 
             numer_1-=numer_2;
             String answer = (Integer.toString(numer_1) + "/" + Integer.toString(denom_1));
             if (numer_1 == 0 || denom_1 == 0) {
                 return "0";
             } else
            	 return answer;
       
//if the operator is multiplying 
             
       } else if (operator.equals("*")) {
             if (numer_1 == 0 && numer_2 == 0) {
            	 whole_number_1 *= whole_number_2;
                 return (Integer.toString(whole_number_1));                  
             }
             // If num1 is a mixed number, convert to normal fraction 
             numer_1 =MixedToFrac(whole_number_1,numer_1,denom_1);
             numer_2 =MixedToFrac(whole_number_2,numer_2,denom_2);
             
             numer_1*=numer_2;
             denom_1*=denom_2;
             String answer = (Integer.toString(numer_1) + "/" + Integer.toString(denom_1));
             if (numer_1 == 0 || denom_1 == 0) {
                 return "0";
             } else
            	 return answer;
             
//if the operator is dividing 
             
       } else if (operator.equals("/")) {
             if (numer_1 == 0 && numer_2 == 0 && whole_number_1 > 0 && whole_number_2 > 0) {
            	 String answer = (Integer.toString(whole_number_1)+ "/" + Integer.toString(whole_number_2));
                 return answer;
             } else if (numer_1 == 0 && numer_2 == 0 && whole_number_1 < 0 && whole_number_2 < 0) {
                 whole_number_2 *= -1;
                 String answer = (Integer.toString(whole_number_1)+ "/" + Integer.toString(whole_number_2));
                 return answer;
             }
             numer_1 =MixedToFrac(whole_number_1,numer_1,denom_1);
             numer_2 =MixedToFrac(whole_number_2,numer_2,denom_2);  
             
             numer_1*=denom_2;
             denom_1*=numer_2;
             String answer = (Integer.toString(numer_1)+ "/" + Integer.toString(denom_1));
                    
             if (numer_1 == 0 && denom_1 == 0) {
            	 return "0";
             } else 
            	 return answer;
             
       } else
             return "Something isn't right";
       
       
    }
    
// all methods except the main method are called are below this line   

    // TODO: Fill in the space below with helper methods
    //Method for finding the whole number of the entered parameter.
    public static String whole_number(String num) {
       if ((num.indexOf("_") > 0) || (num.indexOf("/") < 0)){
    	   String[] pieces = num.split(" ");
           //Split the input by spaces to isolate numbers and operator
           String[] num_pieces = num.split("_");
           //Whole number is first index of the array
           String whole_num = num_pieces[0];
           return whole_num;
       } else 
           return "0";
    }
    public static String numerator(String num) {
    	if ((num.indexOf("_")>0)){
    		String[] pieces = num.split(" ");
            //Split the input by spaces to isolate numbers and operator
            String[] num_pieces = num.split("_");
            //Fraction is the second index of the array
            String frac = num_pieces[1];
            //Split the fraction into numerator and denominator as they are seperated by the slash
            String[] num_split = frac.split("/");
            //Assign Numerator 
            String numerator = num_split[0];
            return numerator;
            //-------------------------------------------
            //Checks if NUMBER 2 is strictly a fraction 
            //-------------------------------------------
        } else if ((num.indexOf("/")>0)) {
            //stuff for fractions here
            //splits the fraction at the "/" which gives numerator and denominator 
            String[] num_split = num.split("/");
            String numerator = num_split[0];
            return numerator;
            } else 
            	return "0";
    }
        
    public static String denominator(String num) {
    	if ((num.indexOf("_")>0)){
    		String[] pieces = num.split(" ");
            //Split the input by spaces to isolate numbers and operator
            String[] num_pieces = num.split("_");
            //Fraction is the second index of the array
            String frac = num_pieces[1];
            //Split the fraction into numerator and denominator as they are seperated by the slash
            String[] num_split = frac.split("/");
            //Assign Denominator 
            String denominator = num_split[1];
             
            return denominator;
            //-------------------------------------------
            //Checks if NUMBER 2 is strictly a fraction 
            //-------------------------------------------
        } else if ((num.indexOf("/")>0)) {
            //stuff for fractions here
            //splits the fraction at the "/" which gives numerator and denominator 
            String[] num_split = num.split("/");
            String denominator = num_split[1];
             
            return denominator;
        } else 
            return "1";
    }
    public static int MixedToFrac(int whole_number_1, int numer_1, int denom_1) {
    	if (whole_number_1 > 0) {
    		numer_1 += denom_1*whole_number_1; 
        }
        if (whole_number_1 < 0) {
            whole_number_1*=denom_1;
            numer_1 *= -1;
            numer_1+=whole_number_1;
            return numer_1;
        }
        return numer_1;
        }
    
    
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b) {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}

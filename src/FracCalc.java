import java.util.*;
public class FracCalc {
    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args) 
    {
       System.out.println("enter two fractions and an opporator (make sure there are spaces between the fractions and the opporator)");
       Scanner input = new Scanner(System.in);
       String answer= input.nextLine();
       System.out.println(produceAnswer(answer));
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String answer)
    { 
        for(int i=0; i<answer.length();i++) {
            char y=answer.charAt(i);
            if(y=='+'||y=='-'||y=='*'||( y=='/'&& answer.charAt(i+1)==' ')) {
                    String second=answer.substring(i+1,answer.length());
                    int wholeEnd=second.indexOf("_");
                    int numeratorEnd= second.indexOf("/");
                    String whole= "whole: ";
                    String numerator= "numerator: ";
                    String denominator= "denominator: ";
                    if (wholeEnd<0 && numeratorEnd <0) {
                            wholeEnd=i;
                            whole= "whole: "+second.substring(0,i);
                            numerator= "numerator: 0";
                            denominator=" denominator: 0";
                    }
                    else if (wholeEnd<0) {
                            numerator= "numerator: "+second.substring(0,numeratorEnd);
                            whole ="whole: 0";
                            denominator= "denominator: "+ second.substring(numeratorEnd+1, second.length());
                    }
                    else {
                            whole= "whole: "+second.substring(0,wholeEnd);
                            numerator= "numerator: "+ second.substring(wholeEnd+1,numeratorEnd);
                            denominator= "denominator: "+second.substring(numeratorEnd+1, second.length());
                    }
                    return whole +" "+ numerator+ " "+denominator; 
            }
        }
		return answer;
    }

       /*String[] second= answer.split(" ");
       String[] individual = second.split(_); 
       Sting[] secondI = individual.split(/);
       String words = "whole:"+ individual[0] + " numerator:" + individual[1] + " denominator:" + individual[2];
       return words;*/
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
        

    

    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b)
    {
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
    public static int leastCommonMultiple(int a, int b)
    {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}


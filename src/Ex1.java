//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutte
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
import java.util.Scanner;
import static java.lang.System.*;
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num)
    {
        int ans = -1;
        int index=0,sum = 0,x,base;
        for (int i=0;i<num.length();i++)
        {
            if (num.charAt(i)=='b')
                index=i;
        }
        for (int i=0;i<index;i++)
        {
            x= Character.getNumericValue(num.charAt(i));
            sum+=x*Math.pow(10,(index-i-1));
        }
        for (int i=index;i<num.length();i++)
        {

        }
        if (num.length()==(index+1)||index==0||sum==0||)
        {
            ans = -1;
         }
        return ans;
    }
    public static void main(String[] args) {


    }
}

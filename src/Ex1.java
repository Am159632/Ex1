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
    public static int base(String num)
    {
        int index=0,base;
        for (int i=0;i<num.length();i++)
        {
            if (num.charAt(i)=='b')
                index=i;
        }
        if (num.charAt(index+1)=='A')
            base=10;
        else if (num.charAt(index+1)=='B')
            base=11;
        else if (num.charAt(index+1)=='C')
            base=12;
        else if (num.charAt(index+1)=='D')
            base=13;
        else if (num.charAt(index+1)=='E')
            base=14;
        else if (num.charAt(index+1)=='F')
            base=15;
        else if (num.charAt(index+1)=='G')
            base=16;
        else
            base= Character.getNumericValue(num.charAt(index+1));
        return base;
    }
    public static int digits(String num)
    {
        int count=0;
        for(int i=0;i<num.length();i++)
        {
            if (num.charAt(i)=='b')
                break;
            count++;
        }
        return count;
    }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num)
    {
        int ans = -1;
        int index=0,sum = 0,x,base=base(num);
        for (int i=0;i<num.length();i++)
        {
            if (num.charAt(i)=='b')
                index=i;
        }
        for (int i=0;i<index;i++)
        {
            x= Character.getNumericValue(num.charAt(i));
            ans+=x*Math.pow(base,(index-i-1));
        }
        if (!isNumber(num))
        {
            return -1;
         }
        return ans;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        int sumN=0,sumB=0,index=0,base=base(a);
        for (int i=0;i<a.length();i++)
        {
            if (a.charAt(i)=='b')
                index=i;
        }
        for (int i=0;i<index;i++)
        {

        }
        if (a.charAt(0)=='b'||base<2||index!=(a.length()+1)||a==null)
        {

        }
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        int index=0,sum=0;
        if (num<0||base<2||base>16) {
            return ans;
        }
        for(int i=0;i<num;i++)
        {
            if (Math.pow(base,i)>num)
                break;
            index++;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}

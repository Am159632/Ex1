package assignments.ex1;
/**
 * This class represents a simple solution for assignments.ex1.Ex1.assignments.ex1.Ex1.
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

public class Ex1 {
    /**
     * Check the value of the base of the number,
     * @param num String representing a number.
     * @return the given number's base and if it is not in a valid format returns -1.
     */
    public static int base(String num)
    {
        int index= num.indexOf('b'),base=-1;
        if (num.indexOf('b')==-1) //if just a number without b
            return 10;
        if (num.length()!=(index+2)) //if we have more/less than one char for the base
            return -1;
        if ('A'<= num.charAt(index+1)&& num.charAt(index+1)<='G') //if the base is in digit(10-16)
            base= num.charAt(index+1)-'A'+10;
        else if ('2'<= num.charAt(index+1)&& num.charAt(index+1)<='9') // if the base is number(0-9)
            base=Character.getNumericValue(num.charAt(index+1));
        return base;
    }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return num in decimal representation (as int).
     */
    public static int number2Int(String num)
    {
        int ans = 0;
        int digits =num.indexOf('b'),base=base(num),x;
        if (digits==-1 && isNumber(num)) //regular number, without b
                digits = num.length();
        for (int i = 0; i< digits; i++)
        {
            x= Character.getNumericValue(num.charAt(i)); //If a digit, it returns its value; if a letter, it returns its value according to its Unicode(A=10...)
            ans+=x*Math.pow(base,(digits-(i+1))); //every digit, power his index
        }
        if  (!isNumber(num))
            ans= -1;
        return ans;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     *  “0b1”
     */
    public static boolean isNumber(String a) {
        boolean ans = true,letter=true,digit=false;
        int index=a.indexOf('b'),base=base(a);
        if (base==-1)
            return false;
        if (a.indexOf('b')==-1) { //regular number, without b
            for (int i = 0; i < a.length(); i++)
                if (!(a.charAt(i) >= '0' && a.charAt(i) <= '9'))
                    return false; //letter in base 10 is invalid number
            return true; //if only digit, valid number
        }
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i)<'A'&&a.charAt(i)>'G')&&a.charAt(i)!='b')
                letter=false;
            if ((a.charAt(i)<'0'&&a.charAt(i)>'9'))
                digit=false;
            if ((!letter&&!digit)||a.charAt(i)==' ')//if one of the chars in the string is not in A-G/b/0-9/space
                return false;
        }
        for (int i=0;i<index;i++)
        {
            if (a.charAt(i)>=a.charAt(index+1))
                return false;//if the value of the char bigger than the base
        }
        if ( index==0 || a==null || a.isEmpty())//if 'b' is the first char/null/empty
            ans=false;
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
        String ans ="";
        if(num==0)
            ans+="0";
        int digit =0;
        if (num<0||base<2||base>16) {  //if the num/base invalid
            return ans;
        }
        for(int i=0;i<num;i++)
        {
            if (Math.pow(base,i)>num) //check how much digits the number have(until base^i>num)
                break;
            digit++;
        }
        for(int i = 0; i< digit; i++)
        {
           int x=((int)(num/Math.pow(base,(digit -(i+1))))); //the decimal value of the digit in this index
            num-= (x* Math.pow(base,(digit -(i+1)))); //subtracts from it
            if (x<10)
                ans+=((char)(x +'0'));
            else
                ans+=((char)(x+'A'-10));
        }
        ans+='b';
        if (base<10)
            ans+=((char)(base+'0'));
        else
            ans+=(char)(base+'A'-10);
        return ans;
    }
    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (number2Int(n1)!=number2Int(n2))
            ans=false;
        return ans;
    }
    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans =0,max=number2Int(arr[0]);
        for (int i=0;i<arr.length;i++)
        {
            if (number2Int(arr[i])>max) {
                ans = i;
                max = number2Int(arr[i]);
            }
        }
        return ans;
    }
}

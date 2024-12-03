import java.util.Scanner;

import static java.lang.System.in;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gut
public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program):");
        String num1 = scanner.nextLine();
        if (num1=="quit")
            return;
        System.out.println("num1= "+num1+" is number: "+ Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));
        if (!Ex1.isNumber(num1)){
            System.out.println("ERR: num1 is in the wrong format! ("+num1+")");
            return;
        }
        System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
        String num2 = scanner.nextLine();
        if (num2=="quit")
            return;
        System.out.println("num2= "+num2+" is number: "+ Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));
        if (!Ex1.isNumber(num2)){
            System.out.println("ERR: num2 is in the wrong format! ("+num2+")");
            return;
        }
        System.out.println("Enter a base for output: (a number [2,16]");
        int base=scanner.nextInt();
        String sum=Ex1.int2Number((Ex1.number2Int(num1)+Ex1.number2Int(num2)),base);
        String multi=Ex1.int2Number((Ex1.number2Int(num1)*Ex1.number2Int(num2)),base);
        System.out.println(num1+" + "+ num2+" = "+sum);
        System.out.println(num1+" * "+ num2+" = "+multi);
        String [] a =new String[] {num1,num2,sum,multi};
        System.out.println("Max number over ["+num1+","+num2+","+sum+","+multi+"] is: "+a[Ex1.maxIndex(a)]);
    }
}
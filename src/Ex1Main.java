import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gut

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "";
        while (!num1.equals("quit") && !num2.equals("quit")) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program):");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));
                if (Ex1.isNumber(num1)) {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
                    num2 = sc.next();
                    if (!num2.equals("quit")) {
                        System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));
                        if (Ex1.isNumber(num2)) {
                            System.out.println("Enter a base for output: (a number [2,16]");
                            int base = sc.nextInt();
                            String sum = Ex1.int2Number((Ex1.number2Int(num1) + Ex1.number2Int(num2)), base);
                            String multi = Ex1.int2Number((Ex1.number2Int(num1) * Ex1.number2Int(num2)), base);
                            System.out.println(num1 + " + " + num2 + " = " + sum);
                            System.out.println(num1 + " * " + num2 + " = " + multi);
                            String[] a = new String[]{num1, num2, sum, multi};
                            System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + multi + "] is: " + a[Ex1.maxIndex(a)]);
                        } else {
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        }
                    }
                } else {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                }
            }
        }
        System.out.println("quiting now...");
}
}
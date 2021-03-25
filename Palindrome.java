//toan le
//occc spring 2021
//advance java
//palindrome homework
import java.util.Scanner;
import java.util.*;


//A program that allows the user to enter a string, and then determines if
//that string is a strict palindrome, an ordinary palindrome, or not a palindrome.


class Palindrome
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker program! ");
        System.out.println("\nThis program will classify the palindrome as: \nStrict, Ordinary, or not a palindrome");

        System.out.print("\nPlease enter a string or numbers: ");
        String str1 = scanner.nextLine();
        String str = str1;

        str = str.replaceAll("\\p{Punct}","");
        str = str.toLowerCase();
        int len = str.length();

        if(isPalindrome(str, 0, len - 1)){
            System.out.println("It is a strict palindrome");
        }
        else{
            str = str.replaceAll(" ","");
            len = str.length();
            if(isPalindrome(str,0,len - 1)){
                System.out.println("It is an ordinary palindrome");
            }
            else{
                System.out.println("It is not palindrome \n");
                System.out.println("The program will now exit");
                System.exit(1);
            }
        }
        String strrev1 = "";

        StringBuilder input1 = new StringBuilder();
        input1.append(str1);
        input1.reverse();

        System.out.println("Palindrome including spaces:   " + input1);
        for(int i = str.length() - 1; i >= 0;i-- )
            strrev1 = strrev1 + str.charAt(i);
        System.out.println("Palindrome with space removed: " + strrev1);

    }
    public static boolean isPalindrome(String str, int start, int end){
        if(start >= end)
            return true;
        if(str.charAt(start) != str.charAt(end))
            return false;
        return isPalindrome(str, start+1, end-1);
    }
}

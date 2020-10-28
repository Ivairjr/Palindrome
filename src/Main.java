/*
 * Save this in a file called Main.java and compile it. To test it
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;
import java.util.Scanner;

/* You may add any imports here, if you wish, but only from the
   standard library */

public class Main {
    public static int process(String str) {
        /*
         * Modify this method to process `str` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */

        //String to store character's frequency
        int count[] = new int[256];

        //Count characters of final Palindrome
        int countPalindrome = 0;

        //for loop to count characters that repeat from input.txt
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        //String declaration for the 3 mandatory parts of an Palindrome: Beginning(b), Middle(m), and Ending(e)
        String b = "", m = "", e = "";

        //For loop to analyze if current character frequency is even or odd
        //This solution considers any set of characters [A-z]
        for (char ch = 'A'; ch <= 'z'; ch++) {

            //Odd
            if (count[ch] % 2 == 1) {
                //Single character on Middle(m) will be overridden by next odd character frequency
                m = String.valueOf(ch);

               //Decrement character frequency to make it even
                count[ch--]--;
            }

            //Even
            else {
                //If (n) is even, then Beginning(b) String receives (n)/2
                for (int i = 0; i < count[ch] / 2; i++) {
                    b += ch;
                }
            }
        }

        // Assign Beginning(b) to Ending(e)
        e = b;
        // Call method reverse() to reverse characters
        e = reverse(e);

        //Palindrome counter counts all characters of the 3 parts of the Palindrome
        countPalindrome = b.length() + m.length() + e.length();

        // return int counter of Palindrome
        return countPalindrome;
    }

    //Method to reverse the Beginning(b) String and populate the Ending(e) String
    static String reverse(String str) {

        String ans = "";
        //Convert String to Character Array
        char[] try1 = str.toCharArray();

        for (int i = try1.length - 1; i >= 0; i--) {
            ans += try1[i];
        }
        //Return reversed characters as String
        return ans;
    }

    public static void main (String[] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            String line = in.nextLine().trim();
            int retVal = process(line);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
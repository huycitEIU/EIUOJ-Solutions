package eiu.cse201.week3;

import java.util.Scanner;

public class EISW3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int numOfSubstrings = count(s);
        System.out.println(numOfSubstrings);

    }

    static int count(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int numOfSubstrings = 0;
        char[] charArray = s.toCharArray();
        char ch1 = charArray[0];
        char ch2 = charArray[1];
        char ch3 = charArray[2];

        for (int i = 3; i < charArray.length; i++) {
            if (ch1 != ch2 && ch1 != ch3 && ch2 != ch3) {
                numOfSubstrings++;
            }
            ch1 = ch2;
            ch2 = ch3;
            ch3 = charArray[i];
        }
        if (ch1 != ch2 && ch1 != ch3 && ch2 != ch3) {
            numOfSubstrings++;
        }
        return numOfSubstrings;
    }
}

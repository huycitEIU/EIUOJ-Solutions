package eiu.cse201.noweek;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        // DDLLDDDDD

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = 0;
        int stage = 0;

        while (end < 9) {
            if (chars[end] >= '0' && chars[end] <= '9') {
                stage *= 10;
                stage += 1;
            } else {
                stage *= 10;
                stage += 2;
            }
            end++;
        }
//
//        while (end < chars.length) {
//            if (stage == form) {
//                while (start <= end) {
//                    sb.append(chars[start++]);
//                }
//                sb.append(" ");
//            } else {
//                stage %= 1
//            }
//        }
    }
}

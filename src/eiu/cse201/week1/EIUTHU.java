package eiu.cse201.week1;

import java.util.Scanner;

public class EIUTHU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String part1 = scanner.nextLine();
        String part2 = scanner.nextLine();

        int maxSameLength = 0;
        int subLength = 0;

        while (subLength <= part1.length() && subLength <= part2.length()) {
            String sub1 = part1.substring(part1.length() - subLength);
            String sub2 = part2.substring(0, subLength);

            if (sub1.equals(sub2)) {
                maxSameLength = sub1.length();
            }

            subLength++;
        }

        System.out.println(part1.length() + part2.length() - maxSameLength);
    }
}

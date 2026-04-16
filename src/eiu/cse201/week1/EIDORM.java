package eiu.cse201.week1;

import java.util.Scanner;

public class EIDORM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rooms = scanner.nextInt();
        int count = 0;

        while (rooms-- > 0) {
            int currentMembers = scanner.nextInt();
            int maxMembers = scanner.nextInt();

            if (maxMembers - currentMembers >= 2) {
                count++;
            }
        }

        System.out.println(count);
    }
}

package eiu.cse201.week2;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EIUGIFT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] giftSizeArr = new int[n];
        int[] sheetSizeArr = new int[m];

        for (int i = 0; i < n; i++) {
            giftSizeArr[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            sheetSizeArr[i] = scanner.nextInt();
        }

        Arrays.sort(giftSizeArr);
        Arrays.sort(sheetSizeArr);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n && j < m) {
            int giftSize = giftSizeArr[i];
            int sheetSize = sheetSizeArr[j];

            if (sheetSize < 2 * giftSize) {
                j++;
            } else if (sheetSize > 3 * giftSize) {
                i++;
            } else {
                count++;
                i++;
                j++;
            }
        }
        System.out.println(count);
    }
}


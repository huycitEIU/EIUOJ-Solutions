package eiu.cse201.week2;

import java.util.Arrays;
import java.util.Scanner;

public class EIPAIR {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int T = io.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = io.nextInt();
            long[] arr = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = io.nextLong();
            }

            Arrays.sort(arr);

            int numOfSamePriceGifts = 0;
            long totalWays = 0;

            for (int i = 1; i <= n; i++) {
                if (arr[i] == arr[i - 1]) {
                    totalWays += numOfSamePriceGifts;
                    numOfSamePriceGifts++;

                } else {
                    numOfSamePriceGifts = 1;
                }
            }
            sb.append(totalWays).append("\n");
        }

        System.out.println(sb.toString());
    }
}

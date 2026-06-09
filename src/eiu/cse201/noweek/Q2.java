package eiu.cse201.noweek;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double K = scanner.nextDouble();
        double S = scanner.nextDouble();

        double[] fileSize = new double[n];
        double[] segments = new double[m];

        for (int i = 0; i < n; i++) {
            fileSize[i] = scanner.nextDouble();
        }

        for (int i = 0; i < m; i++) {
            segments[i] = scanner.nextDouble();
        }

        Arrays.sort(fileSize);
        Arrays.sort(segments);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n && j < m) {
            double left = fileSize[i] * (K + S);
            double right = fileSize[i] * (1 + K);

            if (left > right) {
                i++;
            }

            if (segments[j] < left) {
                j++;
            } else if (segments[j] > right) {
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
/*
5 5 1 1
2 3 5 4 6
3 4 6 7 10
 */

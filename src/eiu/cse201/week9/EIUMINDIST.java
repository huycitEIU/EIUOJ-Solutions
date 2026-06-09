package eiu.cse201.week9;

import java.util.Arrays;
import java.util.Scanner;

public class EIUMINDIST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int low = 0;
        int high = arr[n - 1] - arr[0];
        int minDif = 0;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isValid(arr, k, mid)) {
                minDif = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(minDif);
    }

    static boolean isValid(int[] arr, int k, int diff) {
        int count = 1;
        int last_chosen = arr[0];

        for (int e : arr) {
            if (e - last_chosen >= diff) {
                count++;
                last_chosen = e;
                if (count == k) return true;
            }
        }
        return false;
    }
}

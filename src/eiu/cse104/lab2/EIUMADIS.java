package eiu.cse104.lab2;

import java.util.Scanner;

public class EIUMADIS {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // input
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // solve
        long result = 0;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[minIndex] > nums[i])
                minIndex = i;
            result = Math.max(nums[i] - nums[minIndex], result);
        }
        System.out.println(result);
    }
}

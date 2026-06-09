package eiu.cse201.week9;

import java.util.Scanner;

public class EIAPPLEBOX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long a = scanner.nextLong();
            long p = scanner.nextLong();

            long[] arr = generateArray(n, a, p);

            long count = countInversion(arr, 0, n - 1, 0);

            System.out.println(count);
        }


    }

    static long countInversion(long[] nums, int left, int right, long inversion) {
        if (left < right) {
            int mid = (left + right) >> 1;
            inversion += countInversion(nums, left, mid, 0);
            inversion += countInversion(nums, mid + 1, right, 0);

            return inversion + count(nums, left, mid, right, 0);
        }
        return inversion;
    }

    static long count(long[] nums, int left, int mid, int right, long inversion) {
        long[] sorted = new long[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sorted[index++] = nums[i++];
            } else {
                sorted[index++] = nums[j++];
                inversion += mid - i + 1;
            }
        }

        while (i <= mid) {
            sorted[index++] = nums[i++];
        }

        while (j <= right) {
            sorted[index++] = nums[j++];
        }

        System.arraycopy(sorted, 0, nums, left, sorted.length);

        return inversion;
    }

    static long[] generateArray(int n, long a, long p) {
        long[] arr = new long[n];

        arr[0] = (a * a) % p;

        for (int i = 1; i < n; i++) {
            arr[i] = (arr[i - 1] * a) % p;
        }
        return arr;
    }
}

package eiu.cse201.week9;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class EIUMEDARRAY4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long a = scanner.nextLong();
            long p = scanner.nextLong();
            int k = scanner.nextInt() - 1;

            long[] arr = generateArray(n, a, p);

            kthSmallestElement(arr, 0, n, k);

            sb.append(arr[k]).append('\n');
        }

        System.out.println(sb);
    }

    static void kthSmallestElement(long[] nums, int left, int right, int k) {
        // base condition
        if (left >= right) return;

        int mid = partition(nums, left, right);

        if (k < mid) {
            kthSmallestElement(nums, left, mid, k);
        } else if (mid < k) {
            kthSmallestElement(nums, mid + 1, right, k);
        }
    }

    static int partition(long[] nums, int left, int right) {
        Random random = new Random();
        swap(nums, left, random.nextInt(left, right));

        long pivot = nums[left];

        int j = left + 1;

        for (int i = left + 1; i < right; i++) {
            if (nums[i] < pivot || (nums[i] == pivot && random.nextBoolean())) {
                swap(nums, i, j);
                j++;
            }
        }

        swap(nums, left, j - 1);

        return j - 1;
    }

    static void swap(long[] nums, int left, int right) {
        long temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
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

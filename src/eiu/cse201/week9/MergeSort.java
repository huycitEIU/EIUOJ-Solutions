package eiu.cse201.week9;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (var e : arr) {
            sb.append(e).append('\n');
        }
        System.out.println(sb);
    }

    static void mergeSort(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;

        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    static void merge(int[] nums, int left, int mid, int right) {
        int[] sorted = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sorted[index++] = nums[i++];
            } else {
                sorted[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            sorted[index++] = nums[i++];
        }

        while (j <= right) {
            sorted[index++] = nums[j++];
        }

        System.arraycopy(sorted, 0, nums, left, sorted.length);
    }
}

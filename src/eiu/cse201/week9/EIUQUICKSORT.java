package eiu.cse201.week9;

import java.util.Random;
import java.util.Scanner;

public class EIUQUICKSORT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        quickSort(nums, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void quickSort(int[] nums, int left, int right) {
        // base condition
        if (left >= right) return;

        int mid = partition(nums, left, right);

        quickSort(nums, left, mid);
        quickSort(nums, mid + 1, right);
    }

    static int partition(int[] nums, int left, int right) {
        Random random = new Random();
        swap(nums, left, random.nextInt(left, right));

        int pivot = nums[left];

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

    static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

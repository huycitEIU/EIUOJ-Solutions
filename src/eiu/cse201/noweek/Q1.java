package eiu.cse201.noweek;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String f = scanner.next();

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        if (f.equals("sumOfSquareEqualsK")) {
            Arrays.sort(arr);

            while (q-- > 0) {
                long k = scanner.nextLong();
                long[] result = findPair(arr, k);

                if (result[0] == -1) {
                    System.out.println("-1");
                } else {
                    System.out.println(result[0] + " " + result[1]);
                }
            }
        } else {
            while (q-- > 0) {
                int size = scanner.nextInt();

                long count = count(arr, size);

                System.out.println(count);
            }
        }


    }

    static long[] findPair(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        long diff = 0;
        long[] result = {-1, -1};

        while (left < right) {
            long sum = arr[left] * arr[left] + arr[right] * arr[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            }
        }

        return result;
    }

    static int count(long[] arr, int size) {
        int start = 0;
        int end = 0;

        long sum = 0;

        while (end < size) {
            sum += arr[end++];
        }

        long maxSum = sum;
        int maxCount = 1;

        while (end < arr.length) {
            sum -= arr[start++];
            sum += arr[end++];

            if (sum == maxSum) {
                maxCount++;
            } else if (maxSum < sum) {
                maxSum = sum;
                maxCount = 1;
            }
        }

        return maxCount;
    }
}

/*
sumOfSquareEqualsK
5 2
9 0 4 5 6
16
1
 */

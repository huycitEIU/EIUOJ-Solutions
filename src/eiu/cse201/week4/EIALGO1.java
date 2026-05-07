package eiu.cse201.week4;

import java.util.Scanner;

public class EIALGO1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String function = scanner.next();

        int length = scanner.nextInt();
        int queries = scanner.nextInt();

        long[] array = new long[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLong();
        }

        StringBuilder sb = new StringBuilder();

        if (function.equals("SlidingWindow")) {
            while (queries-- > 0) {
                int size = scanner.nextInt();
                sb.append(slidingWindow(array, size));
                sb.append("\n");
            }
        } else {
            while (queries-- > 0) {
                long target = scanner.nextLong();
                sb.append(binarySearch(array, target));
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(long[] array, long target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                result = mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    static long slidingWindow(long[] array, int size) {
        int start = 0;
        int end = 0;
        long sum = 0;

        while (end < size) {
            sum += array[end++];
        }

        long minimum = sum;

        while (end < array.length) {
            sum -= array[start++];
            sum += array[end++];
            if (minimum > sum) {
                minimum = sum;
            }
        }

        return minimum;
    }
}


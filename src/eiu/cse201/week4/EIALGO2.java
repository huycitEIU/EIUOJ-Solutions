package eiu.cse201.week4;

import java.util.Scanner;

public class EIALGO2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String function = scanner.next();

        int arrayLength = scanner.nextInt();
        int queries = scanner.nextInt();

        long[] array = new long[arrayLength];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLong();
        }

        StringBuilder sb = new StringBuilder();

        if (function.equals("PrefixSum")) {
            long[] sumArray = prefixSum(array);
            while (queries-- > 0) {
                int L = scanner.nextInt();
                int R = scanner.nextInt() + 1;
                long sum = sumArray[R] - sumArray[L];
                sb.append(sum);
                sb.append("\n");
            }
        } else {
            while (queries-- > 0) {
                long target = scanner.nextInt();
                sb.append(binarySearch(array, target));
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(long[] array, long target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    static long[] prefixSum(long[] array) {
        long[] sum = new long[array.length + 1];
        int index = 1;

        while (index < sum.length) {
            sum[index] = sum[index - 1] + array[index - 1];
            index++;
        }

        return sum;
    }
}


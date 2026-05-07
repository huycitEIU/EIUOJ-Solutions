package eiu.cse201.week4;

import java.util.Arrays;
import java.util.Scanner;

public class EIALGO3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        int queries = scanner.nextInt();

        long[] array = new long[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextLong();
        }


        long[] sumArray = prefixSum(array);

        long[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        StringBuilder sb = new StringBuilder();

        while (queries-- > 0) {
            String function = scanner.next();

            switch (function) {
                case "SlidingWindow":
                    int windowSize = scanner.nextInt();
                    long maximum = slidingWindow(array, windowSize);
                    sb.append(maximum).append("\n");
                    break;

                case "TwoPointer":
                    long target = scanner.nextLong();
                    Pair pair = twoPointer(sortedArray, target);
                    sb.append(pair.first).append(" ").append(pair.second);
                    sb.append("\n");
                    break;
                case "PrefixSum":
                    int L = scanner.nextInt();
                    int R = scanner.nextInt() + 1;
                    long sum = sumArray[R] - sumArray[L];
                    sb.append(sum);
                    sb.append("\n");
                default:
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Pair {
        long first;
        long second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair twoPointer(long[] sortedArray, long target) {
        int left = 0;
        int right = sortedArray.length - 1;
        Pair result = new Pair(-1, -1);
        long minDifference = Integer.MAX_VALUE;

        while (left < right) {
            long first = sortedArray[left];
            long second = sortedArray[right];
            if (first + second == target) {
                long difference = second - first;
                if (minDifference > difference) {
                    result = new Pair(first, second);
                    minDifference = difference;
                }
            }

            if (first + second < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    static long slidingWindow(long[] arr, int windowSize) {
        int start = 0;
        int end = 0;
        long sum = 0;

        // initialize window
        while (end < windowSize) {
            sum += arr[end];
            end++;
        }

        long maximum = sum;
        while (end < arr.length) {
            sum -= arr[start++];
            sum += arr[end++];
            if (maximum < sum) {
                maximum = sum;
            }
        }

        return maximum;
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


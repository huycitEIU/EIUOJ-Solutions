package eiu.cse201.week2;

import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFTS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfItems = scanner.nextInt();
        long budget = scanner.nextLong();
        long[] items = new long[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            items[i] = scanner.nextLong();
        }

        Arrays.sort(items);
        long gift1 = 0;
        long gift2 = 0;
        long diff = Long.MAX_VALUE;

        for (int i = 0; i < numberOfItems; i++) {
            long temp1 = items[i];
            int index = smallerOrEqualBinarySearch(items, budget - temp1, i);
            if (index == -1) {
                continue;
            }
            long temp2 = items[index];
            long temp3 = Math.abs(temp1 - temp2);

            if (gift1 + gift2 <= temp1 + temp2 && diff > temp3) {
                diff = temp3;
                gift1 = temp1;
                gift2 = temp2;
            }
        }
        if (gift1 == 0 || gift2 == 0) {
            System.out.println("-1 -1");
        } else {
            System.out.printf((gift1 + gift2) + " " + diff);
        }
    }

    static int smallerOrEqualBinarySearch(long[] array, long target, int ignore) {
        if (array == null || array.length == 0) return -1;

        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            middle = (left + right) >>> 1;
            if (array[middle] == target && middle != ignore) {
                return middle;
            }
            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        while (middle >= 0 && (array[middle] > target || middle == ignore)) {
            middle--;
        }
        return middle;
    }
}

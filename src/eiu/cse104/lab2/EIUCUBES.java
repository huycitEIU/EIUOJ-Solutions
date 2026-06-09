package eiu.cse104.lab2;

import java.util.Scanner;

public class EIUCUBES {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int bricks = scanner.nextInt() - 1;
        int count = 1;
        int layers = 1;
        while (bricks - (layers + count + 1) >= 0) {
            count++;
            layers += count;
            bricks -= layers;
        }
        System.out.println(count);
    }
}
package eiu.cse104.lab7;

import java.util.Scanner;

public class EIVINFASTBATERY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double carCost = scanner.nextDouble();
        double remainValue = scanner.nextDouble();
        int months = scanner.nextInt();
        double bankRate = scanner.nextDouble() / 100.0;

        double ratio = bankRate / (Math.pow(1.0 + bankRate, months) - 1);

        double rentCost = (carCost - remainValue) * Math.pow(1.0 + bankRate, months) * ratio
                + remainValue * bankRate;

        System.out.println((long) Math.round(rentCost));
    }
}

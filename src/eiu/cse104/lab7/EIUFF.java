package eiu.cse104.lab7;

import java.util.Scanner;

public class EIUFF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double monthlyReturnRate = scanner.nextDouble() / 100.0;
        double monthlyInflationRate = scanner.nextDouble() / 100.0;
        double spendingMoney = scanner.nextDouble();
        int months = scanner.nextInt();

        double deposit = spendingMoney
                / (monthlyReturnRate - monthlyInflationRate)
                * (1.0 - Math.pow((1.0 + monthlyInflationRate) / (1.0 + monthlyReturnRate), months - 1));
        System.out.println(Math.round(deposit * 10000.0) / 10000.0);
    }
}

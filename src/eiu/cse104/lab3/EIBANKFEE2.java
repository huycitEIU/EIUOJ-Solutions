package eiu.cse104.lab3;

import java.util.Scanner;

public class EIBANKFEE2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int amountAccounts = scanner.nextInt();
        double currentMoney;
        double totalFee = 0.0;
        long numOfChecks;
        long totalChecks = 0;
        while (amountAccounts-- > 0) {
            currentMoney = scanner.nextDouble();
            numOfChecks = scanner.nextLong();

            totalChecks += numOfChecks;
            totalFee += calculateFee(currentMoney, numOfChecks);
        }
        System.out.println(totalFee / totalChecks);
    }

    private static double calculateFee(double money, double checks) {
        double feePerMonth = 0.0;
        double feeOfCheck = 0.0;

        if (money < 500) {
            feePerMonth = 12.0;
            feeOfCheck = 0.2;
        } else if (money < 2000) {
            feePerMonth = 7.5;
            feeOfCheck = 0.2;
        } else if (money < 5000) {
            feePerMonth = 5.0;
            feeOfCheck = 0.1;
        }

        return (feePerMonth + feeOfCheck * checks);
    }
}

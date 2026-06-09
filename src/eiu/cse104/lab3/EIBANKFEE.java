package eiu.cse104.lab3;

import java.util.Scanner;

public class EIBANKFEE {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double currentMoney = scanner.nextDouble();
        int numOfChecks = scanner.nextInt();
        double feePerMonth = 0.0;
        double feeOfCheck = 0.0;

        if (currentMoney < 500) {
            feePerMonth = 12.0;
            feeOfCheck = 0.2;
        } else if (currentMoney < 2000) {
            feePerMonth = 7.5;
            feeOfCheck = 0.2;
        } else if (currentMoney < 5000) {
            feePerMonth = 5.0;
            feeOfCheck = 0.1;
        }

        System.out.println(feePerMonth + feeOfCheck * numOfChecks);
    }
}

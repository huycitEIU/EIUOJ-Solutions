package eiu.cse104.finalexam;

import java.util.Scanner;

public class EIAPP21222FQ3 {
    public static void main(String[] args) {
        double[] rates = {
                0,
                3.90, 3.92, 3.95, 3.99, 4.04, 5.54,
                5.72, 5.92, 6.14, 6.38, 6.64, 6.92
        };

        Scanner scanner = new Scanner(System.in);
        double expectedAmount = scanner.nextDouble();
        int months = scanner.nextInt();

        double factor = 0.0;

        for (int i = 1; i <= months; i++) {
            int years = i / 12;
            int remainMonths = i % 12;

            double rateYear = Math.pow(1 + rates[12] / 100, years);
            double rateMonth = rates[remainMonths] / 100 / 12 * remainMonths;

            factor += rateYear * (1 + rateMonth);
        }

        double deposit = expectedAmount / factor;

        System.out.println((Math.round(deposit * 10000) / 10000.0));
    }
}

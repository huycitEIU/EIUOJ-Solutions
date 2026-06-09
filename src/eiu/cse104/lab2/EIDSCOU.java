package eiu.cse104.lab2;

import java.util.Scanner;

public class EIDSCOU {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double bill = scanner.nextDouble();
        double totalDiscount = 0;
        double[] level = {2_000_000.0, 10_000_000.0, 50_000_000.0, 100_000_000.0, 200_000_000.0, 500_000_000.0, Long.MAX_VALUE};
        double[] rate = {0.03, 0.05, 0.07, 0.10, 0.12, 0.15};

        for (int i = 0; i < rate.length; i++) {
            if (bill > level[i]) {
                if (bill > level[i + 1]) {
                    totalDiscount += (level[i + 1] - level[i]) * rate[i];
                } else {
                    totalDiscount += (bill - level[i]) * rate[i];
                }
            }
        }
        System.out.println(Math.round(bill - totalDiscount));
    }
}
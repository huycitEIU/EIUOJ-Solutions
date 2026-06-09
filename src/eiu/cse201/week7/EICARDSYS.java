package eiu.cse201.week7;

import java.util.*;

public class EICARDSYS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalDiscount = 0.0;
        int n = scanner.nextInt();

        Map<String, Customer> customerMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            double money = scanner.nextDouble();

            var customer = customerMap.computeIfAbsent(id, Customer::new);

            totalDiscount += money * customer.discountRate;
            customer.addExpense(money);
        }

        System.out.println(totalDiscount);
    }

    static class Customer {
        String id;
        double totalExpense;
        double discountRate;

        public Customer(String id) {
            this.id = id;
            totalExpense = 0.0;
            discountRate = 0.0;
        }

        public void addExpense(double money) {
            if (totalExpense >= 200e6) return;
            totalExpense += money;
            if (totalExpense >= 200e6) {
                discountRate = 0.07;
            } else if (totalExpense >= 50e6) {
                discountRate = 0.05;
            } else if (totalExpense >= 20e6) {
                discountRate = 0.03;
            } else if (totalExpense >= 1e6) {
                discountRate = 0.02;
            }
        }
    }
}

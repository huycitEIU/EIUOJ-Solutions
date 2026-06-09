package eiu.cse201.week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EIHPROFIT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long k = scanner.nextInt();

        List<Product> productList = new ArrayList<>();

        for (long i = 0; i < n; i++) {
            Product product = new Product(
                    scanner.nextInt(),
                    scanner.next(),
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextInt()
            );

            product.profit = (product.price - product.cost) * product.quantity;

            productList.add(product);
        }

        productList.sort((p1, p2) -> {
            var compare = Long.compare(p2.profit, p1.profit);
            if (compare == 0) {
                compare = Long.compare(p1.id, p2.id);
            }
            return compare;
        });

        StringBuilder sb = new StringBuilder();
        long currentProfit = 0;
        long rank = 0;
        long index = 1;
        for (Product product : productList) {
            if (currentProfit != product.profit) {
                rank = index;
                currentProfit = product.profit;
            }
            if (rank > k) {
                break;
            }
            sb.append(product).append('\n');
            index++;
        }
        System.out.println(sb);
    }

    public static class Product {
        public long id;
        public String name;
        public long price;
        public long cost;
        public long quantity;
        public long profit;

        public Product(long id, String name, long price, long cost, long quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.cost = cost;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + profit;
        }
    }
}

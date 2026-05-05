package eiu.cse201.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class EI20213Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            int value = hashMap.getOrDefault(key, 0) + 1;
            hashMap.put(key, value);
        }

        var keySet = hashMap.keySet().toArray();
        Arrays.sort(keySet);

        StringBuilder sb = new StringBuilder();

        for (Object key : keySet) {
            sb.append(key);
            sb.append(" ");
            sb.append(hashMap.get(key));
            sb.append("\n");
        }
        System.out.println(sb);
    }


}


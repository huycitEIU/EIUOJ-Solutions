package eiu.cse201.week2;

import java.util.Scanner;

public class EIDRAW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int spaces = (i - 1) * 2;
            int indents = (n - i);
            sb.append(generateLine(spaces, indents));
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static StringBuilder generateLine(int spaces, int indent) {
        StringBuilder sb = new StringBuilder();

        // first part: \/
        sb.append(" ".repeat(Math.max(0, indent)));
        sb.append("\\");
        sb.append(" ".repeat(Math.max(0, spaces)));
        sb.append("/");
        sb.append(" ".repeat(Math.max(0, indent)));

        // second part: \/
        sb.append(sb);
        return sb;
    }
}

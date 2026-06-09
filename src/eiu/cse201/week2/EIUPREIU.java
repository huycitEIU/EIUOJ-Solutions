package eiu.cse201.week2;

import java.util.Scanner;

public class EIUPREIU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt() / 2;

        StringBuilder sb = new StringBuilder();
        final String UNDERSCORE = "_";
        final String VERTICAL_BAR = "|";
        final String SPACE = " ";

        // line:  _
        sb.append(" ");
        sb.append(generateText(UNDERSCORE, n));
        sb.append(generateText(SPACE, 5 + n));
        sb.append("\n");

        // line: |  | | |
        for (int j = 0; j < n - 1; j++) {
            sb.append("|");
            sb.append(generateText(SPACE, n));
            sb.append(" | |");
            sb.append(generateText(SPACE, n));
            sb.append("|\n");
        }

        // line: |_ | | |
        sb.append("|");
        sb.append(generateText(UNDERSCORE, n));
        sb.append(" | |");
        sb.append(generateText(SPACE, n));
        sb.append("|\n");

        // line: |  | | |
        for (int j = 0; j < n - 1; j++) {
            sb.append("|");
            sb.append(generateText(SPACE, n));
            sb.append(" | |");
            sb.append(generateText(SPACE, n));
            sb.append("|\n");
        }

        // line: |_ | | |
        sb.append("|");
        sb.append(generateText(UNDERSCORE, n));
        sb.append(" | |");
        sb.append(generateText(UNDERSCORE, n));
        sb.append("|");

        System.out.println(sb);
    }

    static StringBuilder generateText(String symbol, int nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums; i++) {
            sb.append(symbol);
        }
        return sb;
    }
}


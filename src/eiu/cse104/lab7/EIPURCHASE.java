package eiu.cse104.lab7;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EIPURCHASE {
    public static void main(String[] args) {
        FastIO io = new FastIO();

        double originalPrice = io.nextDouble();
        int months = io.nextInt();

        double paidAmount = io.nextDouble();
        double monthlyPayment = io.nextDouble();

        io.println(calculateInterestRate(originalPrice - paidAmount, monthlyPayment, months));
        io.close();
    }

    /**
     * Tính lãi suất hàng tháng bằng phương pháp Newton-Raphson
     *
     * @param principal      tiền nợ cần trả
     * @param monthlyPayment tiền trả mỗi tháng
     * @param months         số tháng trả góp
     * @return lãi suất hàng tháng (độ chính xác 1e-6)
     */
    static double calculateInterestRate(double principal, double monthlyPayment, int months) {
        double error = 1e-6;
        double interestRate = 1.0; // Dự đoán lãi suất ban đầu.

        if (monthlyPayment * months <= principal) {
            return 0;
        }

        for (int i = 0; i < 100; i++) {
            // f(r) = m(1 - (1 + r)^(-n)) - p*r = 0
            double f = monthlyPayment * (1 - Math.pow(1 + interestRate, -months)) - principal * interestRate;

            // Đạo hàm f'(r) = m * n * (1 + r) ^ (-n - 1) - p
            double fPrime = monthlyPayment * months * Math.pow(1 + interestRate, (-months - 1)) - principal;

            double nextInterestRate = interestRate - (f / fPrime);

            if (Math.abs(nextInterestRate - interestRate) <= error) {
                return nextInterestRate;
            }
            interestRate = nextInterestRate;
        }
        return 0;
    }

    static class FastIO {
        // --- OUTPUT ---
        private final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        // --- INPUT ---
        private InputStream is = System.in;
        private byte[] inbuf = new byte[1 << 24]; // 16MB Input Buffer
        private int lenbuf = 0, ptrbuf = 0;

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isWhitespace(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isWhitespace(b)) ;
            return b;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            return (char) skip();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isWhitespace(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] nextCharArray(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isWhitespace(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public void print(Object o) {
            out.print(o);
        }

        public void println(Object o) {
            out.println(o);
        }

        public void printf(String format, Object... args) {
            out.printf(format, args);
        }

        // Bắt buộc gọi hàm này khi kết thúc chương trình
        public void close() {
            out.flush();
            out.close();
        }
    }
}
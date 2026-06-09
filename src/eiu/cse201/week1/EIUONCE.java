package eiu.cse201.week1;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EIUONCE {
    public static void main(String[] args) {
        FastIO io = new FastIO();

        int T = io.nextInt();

        while (T-- > 0) {
            int n = io.nextInt();
            long[] array = new long[n];

            for (int i = 0; i < n; i++) {
                array[i] = io.nextLong();
            }

            Arrays.sort(array);

            StringBuilder sb = new StringBuilder();

            if (n > 1 && array[0] != array[1] || n == 1) {
                sb.append(array[0]).append(" ");
            }
            for (int i = 1; i < n; i++) {
                if (i == n - 1 && array[i] != array[i - 1]) {
                    sb.append(array[i]);
                } else if (array[i] != array[i - 1] && array[i] != array[i + 1]) {
                    sb.append(array[i]);
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }

    static class FastIO {
        // --- OUTPUT ---
        private final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        // --- INPUT ---
        private final InputStream is = System.in;
        private final byte[] inbuf = new byte[1 << 24]; // 16MB Input Buffer
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

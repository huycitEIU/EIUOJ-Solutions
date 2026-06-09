package eiu.cse201.week8;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class EISTOCK {
    public static void main(String[] args) {
        FastIO io = new FastIO();

        int noTransactions = io.nextInt();

        Map<Integer, Item> itemMap = new TreeMap<>();

        for (int i = 0; i < noTransactions; i++) {
            char type = io.nextChar();
            int code = io.nextInt();
            int quantity = io.nextInt();
            int price = io.nextInt();

            var item = itemMap.get(code);

            if (item == null) {
                if (type == '+') {
                    item = new Item(code);
                    itemMap.put(code, item);
                } else {
                    continue;
                }
            }

            if (type == '+') {
                item.buy(quantity, price);
            } else {
                item.ship(quantity, price);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (var entry : itemMap.entrySet()) {
            Item item = entry.getValue();
            if (item.totalImport > 0) {
                sb.append(item.code).append(' ')
                        .append(item.totalImport).append(' ')
                        .append(item.totalShip).append('\n');
            }
        }

        io.println(sb);
        io.close();
    }

    static class Item {
        int code;
        public int quantity;
        long totalImport;
        long totalShip;

        public Item(int code) {
            this.code = code;
            this.quantity = 0;
            this.totalImport = 0;
            this.totalShip = 0;
        }

        public void buy(int quantity, int price) {
            this.totalImport += (long) price * quantity;
            this.quantity += quantity;
        }

        public void ship(int quantity, int price) {
            if (this.quantity >= quantity){
                this.totalShip += (long) price * quantity;
                this.quantity -= quantity;
            }
        }
    }

    static class FastIO {
        // --- OUTPUT ---
        private final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        // --- INPUT ---
        private final InputStream is = System.in;
        private final byte[] inbuf = new byte[1 << 16]; // 64KB tối ưu cho CPU Cache
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

        // Tối ưu hóa đọc String: Thêm capacity ban đầu và dùng ép kiểu char trực tiếp
        public String next() {
            int b = skip();
            if (b == -1) return null;
            StringBuilder sb = new StringBuilder(32); // Cấp phát trước tránh resize liên tục
            do {
                sb.append((char) b);
                b = readByte();
            } while (b >= 33 && b <= 126); // Tận dụng vùng ký tự không phải khoảng trắng
            return sb.toString();
        }

        public char[] nextCharArray(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && (b >= 33 && b <= 126)) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        // Đã tối ưu bằng do-while
        public int nextInt() {
            int b = skip();
            boolean minus = (b == '-');
            if (minus) {
                b = readByte();
            }
            int num = 0;
            do {
                num = num * 10 + (b - '0');
                b = readByte();
            } while (b >= '0' && b <= '9');

            return minus ? -num : num;
        }

        public long nextLong() {
            int b = skip();
            boolean minus = (b == '-');
            if (minus) {
                b = readByte();
            }
            long num = 0;
            do {
                num = num * 10 + (b - '0');
                b = readByte();
            } while (b >= '0' && b <= '9');

            return minus ? -num : num;
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

        // Bắt buộc gọi hàm này khi kết thúc chương trình để đẩy dữ liệu ra ngoài
        public void close() {
            out.flush();
            out.close();
        }
    }
}


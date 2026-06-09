package eiu.cse201.week9;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EIUASSEMBLY {
    public static void main(String[] args) {
        FastIO scanner = new FastIO();

        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long m = scanner.nextLong();

            List<Robot> robotList = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                robotList.add(new Robot(
                        scanner.nextInt(),
                        scanner.nextLong()
                ));
            }

            robotList.sort(Comparator.comparingInt(r -> r.productPerHour));

            long low = robotList.get(0).productPerHour;

            long minCostPerUpgrade = robotList.get(0).cost;
            for (Robot robot : robotList) {
                if (minCostPerUpgrade > robot.cost) {
                    minCostPerUpgrade = robot.cost;
                }
            }

            long high = low + (m / minCostPerUpgrade);
            long ans = low;

            while (low <= high) {
                long mid = (low + high) >> 1;

                if (canAchive(robotList, m, mid)) {
                    low = mid + 1;
                    ans = mid;
                } else {
                    high = mid - 1;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    static boolean canAchive(List<Robot> list, long limit, long target) {
        long total = 0;

        for (Robot robot : list) {
            if (robot.productPerHour < target) {
                long unitsNeeded = target - robot.productPerHour;

                if (unitsNeeded > limit / robot.cost) {
                    return false;
                }

                total += unitsNeeded * robot.cost;

                if (total > limit) {
                    return false;
                }
            } else {
                break;
            }
        }

        return total <= limit;
    }

    static class Robot {
        int productPerHour;
        long cost;

        public Robot(int productPerHour, long cost) {
            this.productPerHour = productPerHour;
            this.cost = cost;
        }
    }

    static class FastIO {
        // --- OUTPUT MỚI: DÙNG BỘ ĐỆM BYTE THÔ NGUYÊN BẢN ---
        private final byte[] outbuf = new byte[1 << 16]; // 64KB Output Buffer
        private int outptr = 0;

        // Hàm phụ trợ ghi 1 byte thô vào bộ đệm
        private void writeByte(int b) {
            if (outptr >= outbuf.length) {
                flush();
            }
            outbuf[outptr++] = (byte) b;
        }

        // Ghi một số nguyên trực tiếp dạng Byte, không qua String, không mã hóa!
        public void printInt(int num) {
            if (num == 0) {
                writeByte('0');
                return;
            }
            if (num < 0) {
                writeByte('-');
                num = -num;
            }
            // Gộp các chữ số vào một mảng tạm thời
            int localPtr = 0;
            byte[] temp = new byte[12];
            while (num > 0) {
                temp[localPtr++] = (byte) ('0' + (num % 10));
                num /= 10;
            }
            // Ghi ngược lại vào bộ đệm chính
            while (localPtr > 0) {
                writeByte(temp[--localPtr]);
            }
        }
        // Ghi một số nguyên lớn (long) trực tiếp dạng Byte
        public void printLong(long num) {
            if (num == 0) {
                writeByte('0');
                return;
            }
            if (num < 0) {
                writeByte('-');
                num = -num; // Lưu ý: Nếu num là Long.MIN_VALUE sẽ bị tràn số, nhưng testcase thi đấu hiếm khi gài trị này
            }
            int localPtr = 0;
            byte[] temp = new byte[21]; // Long.MAX_VALUE có 19 chữ số, kích thước 21 là hoàn toàn an toàn
            while (num > 0) {
                temp[localPtr++] = (byte) ('0' + (num % 10));
                num /= 10;
            }
            // Đẩy ngược các chữ số vào bộ đệm chính
            while (localPtr > 0) {
                writeByte(temp[--localPtr]);
            }
        }

        // Ghi ký tự khoảng trắng hoặc xuống dòng
        public void printChar(char c) {
            writeByte(c);
        }

        // Đẩy toàn bộ dữ liệu thô ra console
        public void flush() {
            if (outptr > 0) {
                System.out.write(outbuf, 0, outptr);
                outptr = 0;
            }
        }

        // Bắt buộc gọi khi kết thúc chương trình
        public void close() {
            flush();
        }
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
    }
}

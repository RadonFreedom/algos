package leetcode;

/**
 * @author Shaman
 * @date 2019/9/3 16:04
 */

public class _1017 {
    public static void main(String[] args) {
        baseNeg2(1000001);
    }
    public static String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }

        StringBuilder rst = new StringBuilder();
        while (N != 0) {
            int bit = N % -2;
            N /= -2;
            // 我们需要让 -1 / -2 = 1 % 1
            if (bit == -1) {
                // 余数置1
                bit = 1;
                // 商加上1
                N++;
            }
            rst.insert(0, bit);
        }

        return rst.toString();
    }
}

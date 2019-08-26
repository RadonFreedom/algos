package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2019/8/26 20:14
 */

public class _751_2 {

    public static List<String> ipToCIDR(String ip, int n) {

        long ipVal = 0;
        for (String seg : ip.split("\\.")) {
            ipVal *= 256;
            ipVal += Long.parseLong(seg);
        }

        LinkedList<String> rst = new LinkedList<>();
        while (n > 0) {
            long bitVal = ipVal & -ipVal;

            while (bitVal > n) {
                bitVal /= 2;
            }

            int bit = 32;
            for (long i = bitVal; i > 1; i /= 2) {
                bit--;
            }

            rst.add(ipVal2Ip(ipVal) + "/" + bit);
            n -= bitVal;
            ipVal += bitVal;
        }
        return rst;
    }

    private static String ipVal2Ip(long ipVal) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            res.insert(0, (ipVal & 255));
            ipVal >>>= 8;
            if (i < 3) {
                res.insert(0, '.');
            }
        }
        return res.toString();
    }
}

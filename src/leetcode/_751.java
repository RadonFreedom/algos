package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shaman
 * @date 2019/8/24 21:02
 */

public class _751 {

    public static void main(String[] args) {
        ipToCIDR("255.0.0.7"
                , 10);
    }

    public static List<String> ipToCIDR(String ip, int n) {

        long ipVal = 0;
        for (String seg : ip.split("\\.")) {
            ipVal *= 256;
            ipVal += Long.parseLong(seg);
        }
        int bitInit = 0;
        for (int i = 2; i < 1024; i *= 2) {
            if (n >= i) {
                bitInit++;
            }
        }

        LinkedList<String> rst = new LinkedList<>();
        while (n > 0) {
            int bit = bitInit;
            int bitVal = 1 << bit;

            while (bitVal > 0) {
                // ipVal后bit位为0
                if ((ipVal & (bitVal - 1)) == 0 && n >= bitVal) {
                    rst.add(ipVal2Ip(ipVal) + "/" + (32 - bit));
                    n -= bitVal;
                    ipVal += bitVal;
                    break;
                }
                bit--;
                bitVal /= 2;
            }
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

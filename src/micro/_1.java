package micro;

import java.util.LinkedList;

/**
 * 将定长的int(4byte)转正不定长的byte数组，数组第一位表示长度
 *
 * @author Shaman
 * @date 2020/2/18 15:45
 */

public class _1 {
    public static byte[] int2byte(int a) {
        LinkedList<Byte> bytes = new LinkedList<>();
        if (a < 0) {
            bytes.add((byte) 1);
            a = -a;
        } else {
            bytes.add((byte) 0);
        }
        while (a != 0) {
            bytes.addFirst((byte) (a & 0xff));
            a = a >>> 8;
        }

        byte[] res = new byte[bytes.size() + 1];
        res[0] = (byte) (res.length);
        for (int i = 1; i < res.length; i++) {
            res[i] = bytes.removeFirst();
        }
        return res;
    }

    public static int byte2int(byte[] bytes) {
        int res = 0;
        for (int i = 1; i < bytes[0] - 1; i++) {
            res = res << 8;
            res += bytes[i];
        }
        if (bytes[bytes[0] - 1] > 0) {
            res = -res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(byte2int(int2byte(Integer.MAX_VALUE)));
    }
}

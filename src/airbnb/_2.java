package airbnb;

import java.util.HashMap;

/**
 * @author Shaman
 * @date 2019/9/27 20:18
 */

public class _2 {

    public static String divide(int a, int b) {

        StringBuilder rst = new StringBuilder(String.valueOf(a / b));
        a %= b;
        if (a == 0) {
            return rst.toString();
        }

        Integer infinite = null;
        rst.append(".");
        int head = a;
        int tail = a;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (true) {
            if (map.containsKey(a)) {
                infinite = a;
                map.remove(tail);
                break;
            }
            int next = a;
            while (next < b) {
                next *= 10;
            }
            next %= b;
            if (next == 0) {
                break;
            }
            map.put(a, next);
            tail = a;
            a = next;
        }

        while (true) {
            if (infinite != null && head == infinite) {
                rst.append("(");
            }
            while (head < b) {
                head *= 10;
            }
            rst.append(head / b);
            head %= b;
            if (map.containsKey(head)) {
                head = map.get(head);
            } else {
                break;
            }
        }
        if (infinite != null) {
            rst.append(")");
        }
        return rst.toString();

    }

    public static void main(String[] args) {
        System.out.println(divide(10, 7));
    }
}

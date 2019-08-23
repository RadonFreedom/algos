package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author xufeng
 * created at 2019.08.19 19:05
 */

public class _772 {

    private static final HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('+', 1);
        map.put('-', 2);
        map.put('*', 3);
        map.put('/', 4);
        map.put(')', 5);
    }

    private int right = -1;
    private String s;

    public int calculate(String s) {
        this.s = s.replace(" ", "");
        return (int) cal(0);
    }

    private long cal(int begin) {
        LinkedList<Long> nums = new LinkedList<>();
        LinkedList<Character> cals = new LinkedList<>();
        if (s.charAt(begin) == '-') {
            s = s.replace(s.substring(begin), '0' + s.substring(begin));
        }
        int pre = begin;
        for (int i = begin; i < s.length(); i++) {
            char cal = s.charAt(i);
            if (cal == '(') {
                nums.add(cal(i + 1));
                i = right;
                pre = i + 1;
            }  else if (map.containsKey(cal)) {
                if (pre < i) {
                    nums.add(Long.valueOf(s.substring(pre, i)));
                }
                if (cal == ')') {
                    right = i;
                    break;
                }
                cals.add(cal);
                pre = i + 1;
            }
        }
        if (pre > right && pre < s.length()) {
            nums.add(Long.parseLong(s.substring(pre)));
        }

        //计算所有* /
        long currNum = nums.removeFirst();
        int cnt = cals.size();
        while (cnt > 0) {
            while (cnt > 0 && map.get(cals.getFirst()) > 2) {
                if (cals.removeFirst() == '*') {
                    currNum *= nums.removeFirst();
                } else {
                    currNum /= nums.removeFirst();
                }
                cnt--;
            }
            if (cnt > 0) {
                nums.addLast(currNum);
                currNum = nums.removeFirst();
                cals.addLast(cals.removeFirst());
                cnt--;
            }
        }
        nums.addLast(currNum);
        currNum = nums.removeFirst();
        //计算所有+ -
        while (!cals.isEmpty()) {
            if (cals.removeLast() == '+') {
                currNum += nums.removeLast();
            } else {
                currNum -= nums.removeLast();
            }
        }
        return currNum;
    }
}

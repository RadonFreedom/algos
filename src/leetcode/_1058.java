package leetcode;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author xufeng
 * created at 2019.08.12 09:22
 */

public class _1058 {

    public String minimizeError(String[] prices, int target) {

        List<Double> fracs = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            double val = Double.parseDouble(prices[i]);
            double frac = val - Math.floor(val);
            if (frac != 0.0) {
                fracs.add(frac);
                target -= Math.round(Math.floor(val));
            } else {
                target -= Math.round(val);
            }
        }

        if (target > fracs.size() || target < 0) {
            return "-1";
        }

        double rst = 0;
        PriorityQueue<Double> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (Double frac : fracs) {
            q.add(frac);
            if (q.size() > fracs.size() - target) {
                rst += (1 - q.poll());
            }
        }
        while (!q.isEmpty()) {
            rst += q.poll();
        }
        DecimalFormat format = new DecimalFormat("0.000");
        return format.format(rst);
    }

    public static void main(String[] args) {
        args = new String[]{"2.000","2.000","2.000","2.000","2.000"};
        new _1058().minimizeError(args, 11);
    }
}

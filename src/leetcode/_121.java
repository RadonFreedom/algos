package leetcode;

/**
 * @author Shaman
 * @date 2020/2/12 19:12
 */

public class _121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length < 2) {
            return res;
        }
        int min = prices[0];
        for (int num : prices) {
            min = Math.min(num, min);
            res = Math.max(res, num - min);
        }
        return res;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xufeng
 * created at 2019.07.21 15:25
 */

public class _218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        return mergeSkyline(buildings, 0 ,buildings.length - 1);
    }


    private List<List<Integer>> mergeSkyline(int[][] buildings, int lo, int hi) {

        if (lo == hi) {
            List<List<Integer>> l = new LinkedList<>();
            l.add(Arrays.asList(buildings[lo][0], buildings[lo][2]));
            l.add(Arrays.asList(buildings[lo][1], 0));
            return l;
        }

        int mid = (hi - lo) / 2 + lo;
        List<List<Integer>> ll = mergeSkyline(buildings, lo, mid);
        List<List<Integer>> rl = mergeSkyline(buildings, mid + 1, hi);
        List<List<Integer>> res = new LinkedList<>();

        int i = 0, j = 0;
        while (i < ll.size() || j < rl.size()) {
            if (i >= ll.size()) {
                res.addAll(rl.subList(j, rl.size()));
                return res;
            }
            if (j >= rl.size()) {
                res.addAll(ll.subList(i, ll.size()));
                return res;
            }

            List<Integer> l = ll.get(i);
            List<Integer> r = rl.get(i);
            boolean f = false;
            if (l.get(0) > r.get(0)) {
                f = !f;
            }
        }

        return res;
    }
}

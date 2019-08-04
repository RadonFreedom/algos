package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xufeng
 * created at 2019.08.04 23:09
 */

public class _56 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] l = list.get(list.size() - 1);
            if (l[1] < intervals[i][1] && l[1] >= intervals[i][0]) {
                list.set(list.size() - 1, new int[]{l[0], intervals[i][1]});
            }
            if (l[1] < intervals[i][0]) {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

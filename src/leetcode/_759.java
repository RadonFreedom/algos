package leetcode;

import java.util.*;

/**
 * @author Shaman
 * @date 2019/8/27 11:04
 */

public class _759 {

    private static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start,int _end) {
            start = _start;
            end = _end;
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        ArrayList<Interval> intervals = new ArrayList<>();
        for (List<Interval> intervalList : schedule) {
            intervals.addAll(intervalList);
        }

        // 按照所有时间区间的开始时间排序
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        LinkedList<Interval> rst = new LinkedList<>();

        int currEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > currEnd) {
                rst.add(new Interval(currEnd, interval.start));
            }
            currEnd = Math.max(currEnd, interval.end);
        }

        return rst;
    }
}

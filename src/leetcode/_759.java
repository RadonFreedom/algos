package leetcode;

import java.util.*;

/**
 * @author Shaman
 * @date 2019/8/27 11:04
 */

public class _759 {

    static class Interval {
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
        schedule.forEach(intervals::addAll);

        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        LinkedList<Interval> rst = new LinkedList<>();

        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                rst.add(new Interval(end, interval.start));
            }
            if (interval.end > end) {
                end = interval.end;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        LinkedList<List<Interval>> schedule = new LinkedList<>();
        schedule.add(Arrays.asList(
                new Interval(1,2),
                new Interval(5,6),
                new Interval(1, 3),
                new Interval(4, 10)
        ));

        employeeFreeTime(schedule);
    }
}

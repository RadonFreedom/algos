package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Shaman
 * @date 2019/9/3 16:35
 */

public class _787 {
    private static class Path {
        int stop;
        int cost;
        int remain;
        public Path(int stop, int cost, int remain) {
            this.stop = stop;
            this.cost = cost;
            this.remain = remain;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, LinkedList<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new LinkedList<>());
            map.get(flight[0]).addLast(flight);
        }

        PriorityQueue<Path> cost = new PriorityQueue<>(Comparator.comparingInt(path -> path.cost));
        cost.add(new Path(src, 0, K));
        while (!cost.isEmpty()) {
            Path curPath = cost.poll();
            if (curPath.stop == dst) {
                return curPath.cost;
            } else if (curPath.remain >= 0) {
                for (int[] flight : map.getOrDefault(curPath.stop, new LinkedList<>())) {
                    cost.add(new Path(flight[1], flight[2] + curPath.cost, curPath.remain - 1));
                }
            }
        }
        return -1;
    }
}

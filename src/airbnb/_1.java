package airbnb;

import java.util.*;

/**
 * @author Shaman
 * @date 2019/9/27 18:32
 */

public class _1 {

    public static List<String> costsOfNodes(List<String> lines) {

        Map<String, Integer> nodes = new HashMap<>();
        HashMap<String, LinkedList<String>> map = new HashMap<>();

        for (String line : lines) {
            String[] splits = line.split(",");
            String child = splits[0];
            nodes.put(splits[0], 0);
            for (int i = 1; i < splits.length; i++) {
                map.putIfAbsent(splits[i], new LinkedList<>());
                map.get(splits[i]).add(child);
            }
        }

        HashSet<String> set = new HashSet<>();
        Queue<String>  queue = new LinkedList<>();
        for (String s : map.keySet()) {
            set.clear();
            queue.clear();
            queue.add(s);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    String curr = queue.poll();
                    set.addAll(map.getOrDefault(curr, new LinkedList<>()));
                    queue.addAll(map.getOrDefault(curr, new LinkedList<>()));
                }
            }
            nodes.put(s, set.size());
        }

        List<String> rst = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : nodes.entrySet()) {
            rst.add(entry.getKey() + "," + (entry.getValue() + 1));
        }
        return rst;
    }
}

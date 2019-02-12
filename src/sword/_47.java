package sword;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.12 14:23
 */

public class _47 {

    private class Entry implements Map.Entry<Integer, Character> {

        private Integer key;
        private Character value;

        Entry(Integer key, Character value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public Character getValue() {
            return value;
        }

        @Override
        public Character setValue(Character value) {
            this.value = value;
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry other = (Entry) obj;
            //只判断索引是否相同就够了
            return other.key.equals(key);
        }
    }

    private PriorityQueue<Entry> priorityQueue = new PriorityQueue<>(Comparator.comparing(entry -> entry.key));
    private Map<Character, Integer> map = new HashMap<>();
    private int index = 0;

    /**
     * Insert one char from string stream. <p/>
     * map的作用是查重，priorityQueue的作用是最快找到最小索引的只出现一次的字符
     *
     * @param ch one char to be inserted into the string stream
     */
    public void Insert(char ch) {
        //如果出现超过一次，就把索引值从priorityQueue中删除
        if (map.containsKey(ch)) {
            priorityQueue.remove(new Entry(map.get(ch), ch));
        }
        else {
            //如果第一次出现，在map中存入这个字符和第一次出现的索引值
            map.put(ch, index);
            //把索引值加入到优先队列中
            priorityQueue.add(new Entry(index, ch));
            index++;
        }
    }

    /**
     * @return the first appearence once char in current string stream
     */
    public char FirstAppearingOnce() {
        Entry retVal = priorityQueue.peek();
        return retVal == null ? '#' : retVal.value;
    }
}

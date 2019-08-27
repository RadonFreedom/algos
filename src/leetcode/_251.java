package leetcode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Shaman
 * @date 2019/8/27 11:50
 */

public class _251 {

    class Vector2D {
        private Iterator<Integer> iterator;

        public Vector2D(int[][] v) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                    l.add(v[i][j]);
                }
            }
            iterator = l.iterator();
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}

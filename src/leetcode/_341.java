package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.06.17 17:02
 */

public class _341 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private Stack<NestedInteger> s = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                s.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return s.pop().getInteger();
        }


        @Override
        public boolean hasNext() {

            while (!s.empty()) {
                if (s.peek().isInteger()) {
                    return true;
                } else {
                    List<NestedInteger> l = s.pop().getList();
                    for (int i = l.size() - 1; i >= 0; i--) {
                        s.push(l.get(i));
                    }
                }
            }
            return false;
        }
    }
}

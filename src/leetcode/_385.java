package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shaman
 * @date 2019/8/28 17:32
 */

public class _385 {

    public static void main(String[] args) {
        deserialize("[[123],456]");
    }

    public static NestedInteger deserialize(String s) {

        if (s.isEmpty()) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        NestedInteger curr = null;
        Stack<NestedInteger> stack = new Stack<>();

        int lo = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                lo = i + 1;
            } else if (c == ',') {
                if (lo < i) {
                    curr.add(new NestedInteger(Integer.parseInt(s.substring(lo, i))));
                }
                lo = i + 1;
            } else {
                if (c == ']') {
                    if (lo < i) {
                        curr.add(new NestedInteger(Integer.parseInt(s.substring(lo, i))));
                    }
                    if (!stack.isEmpty()) {
                        NestedInteger outer = stack.pop();
                        outer.add(curr);
                        curr = outer;
                    }
                    lo = i + 1;
                }
            }
        }
        return curr;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private interface Nested {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    private static class NestedInteger implements Nested {

        Integer val;
        LinkedList<NestedInteger> l;

        NestedInteger(int val) {
            this.val = val;
        }

        NestedInteger() {
            l = new LinkedList<>();
        }

        @Override
        public boolean isInteger() {
            return val != null;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public void setInteger(int value) {
            val = value;
        }

        @Override
        public void add(NestedInteger ni) {
            if (l == null) l = new LinkedList<>();
            l.addLast(ni);
        }

        @Override
        public List<NestedInteger> getList() {
            return l;
        }
    }
}

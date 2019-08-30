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
        if (s.isEmpty())
            return null;
        if (s.charAt(0) != '[') // ERROR: special case
            return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int i = 0; // i shall point to the start of a number substring;
        // j shall point to the end+1 of a number substring
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                i = j + 1;
            } else if (ch == ']') {
                if (i < j)
                    curr.add(new NestedInteger(Integer.valueOf(s.substring(i, j))));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                i = j + 1;
            } else if (ch == ',') {
                if (s.charAt(j - 1) != ']') {
                    String num = s.substring(i, j);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                i = j + 1;
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

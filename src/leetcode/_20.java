package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.05.29 15:12
 */

public class _20 {

    private Map<Character, Character> map = new HashMap<>();
    {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.empty()) return false;
            if (map.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}

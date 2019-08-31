package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Shaman
 * @date 2019/8/24 18:49
 */

public class _772_2 {

    public static void main(String[] args) {
        new _772_2().calculate("2*(5+5*2)/3+(6/2+8)");
    }

    /**
     * 存储'('对应的')'
     */
    private HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 迭代会遇到 + - * / 1-9 ( )
     * intuitively:
     * 1. 遇到'(', 找到对应的')'索引，递归调用方法
     * 2. 遇到 + - * / 把运算符先保留，等遇到下一个运算符时进行前一个算式的计算
     * 3. 遇到 + - 把刚计算出来的前一个算式的结果累加到rst
     * 4. 索引到底时进行特殊处理，计算最后一个算式，把结果累加到rst
     */
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                this.map.put(stack.pop(), i);
            }
        }

        return cal(s, 0 ,s.length() - 1);
    }

    private int cal(String s, int lo, int hi) {
        int rst = 0;
        // 上一个算式的运算符
        char operator = '+';
        // 当前数字，遇到1～9进行运算
        int currNum = 0;
        // 当前结果，遇到 + - 累加到rst
        int tmpRst = 0;

        for (int i = lo; i <= hi; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                int j = map.get(i);
                currNum = cal(s, i + 1, j - 1);
                i = j;
            } else if (c >= '0' && c <= '9') {
                currNum = currNum * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == hi) {
                // 计算上一个算式的结果
                switch (operator) {
                    case '+':
                        tmpRst += currNum;
                        break;
                    case '-':
                        tmpRst -= currNum;
                        break;
                    case '*':
                        tmpRst *= currNum;
                        break;
                    case '/':
                        tmpRst /= currNum;
                        break;
                }
                // 更新运算符
                operator = c;
                // 当前数字置0
                currNum = 0;

                if (c == '+' || c == '-' || i == hi) {
                    rst += tmpRst;
                    tmpRst = 0;
                }

            }
        }

        return rst;
    }
}

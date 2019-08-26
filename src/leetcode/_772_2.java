package leetcode;

/**
 * @author Shaman
 * @date 2019/8/24 18:49
 */

public class _772_2 {

    public int calculate (String s) {
        int res = 0;
        // 保存乘除式结果
        // 遇到加、减或者s结束将部分结果累加到res
        int currRes = 0;
        //当前数字
        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int cnt = 0;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        cnt++;
                    }
                    if (s.charAt(j) == ')') {
                        cnt--;
                    }
                    if (cnt == 0) {
                        num = calculate(s.substring(i + 1, j));
                        i = j;
                        break;
                    }
                }
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        currRes += num;
                        break;
                    case '-':
                        currRes -= num;
                        break;
                    case '*':
                        currRes *= num;
                        break;
                    case '/':
                        currRes /= num;
                        break;
                }
                // 遇到加、减或者s结束将部分结果累加到res
                if (c == '+' || c == '-' || i == s.length() - 1) {
                    res += currRes;
                    currRes = 0;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }
}

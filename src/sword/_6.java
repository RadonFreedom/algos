package sword;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 圆圈中最后剩下的数
 * https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.22 8:29
 */

public class _6 {

    public static int solution(int n, int m) {

        if (n < 1 || m < 1) {

            System.out.println("ParameterError!");
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int result;
        int index = (m - 1) % n;

        while (list.size() > 1) {

            list.remove(index);
            index = (index + m - 1) % list.size();
        }

        result = list.get(0);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(solution(6, 7));
    }
}

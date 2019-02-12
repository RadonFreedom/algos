package sword;

/**
 *
 * 求1+2+3+...+n
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.22 9:03
 */

public class _5 {

    private int result = 0;

    public int solution(int n) {

        if (n < 0) {
            return -1;
        }

        add(n);
        return result;
    }

    private boolean add(int n){

        return n > 0 && (result = result + n) > 0 && add(n - 1);
    }
}

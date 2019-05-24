package sword;

/**
 *
 * 构建乘积数组
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.11 11:00
 */

public class _44 {

    public int[] multiply(int[] A) {

        if (A == null || A.length == 0) {
            return new int[0];
        }

        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 0; i < B.length - 1; i++) {
            B[i + 1] = B[i] * A[i];
        }

        int[] C = new int[A.length];
        C[C.length - 1] = 1;
        for (int i = C.length - 1; i > 0; i--) {
            C[i - 1] = C[i] * A[i];
        }

        for (int i = 0; i < B.length; i++) {
            B[i] = B[i] * C[i];
        }

        return B;
    }
}

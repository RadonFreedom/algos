package leetcode;

/**
 * @author xufeng
 * created at 2019.08.21 17:33
 */

public class _657 {
    public boolean judgeCircle(String moves) {
        int[] coor = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            char m = moves.charAt(i);
            if (m == 'R') {
                coor[0]++;
            }
            if (m == 'L') {
                coor[0]--;
            }
            if (m == 'U') {
                coor[1]++;
            }
            if (m == 'D') {
                coor[1]--;
            }
        }
        return coor[0] == 0 && coor[1] == 0;
    }
}

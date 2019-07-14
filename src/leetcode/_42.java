package leetcode;

import java.util.LinkedList;

/**
 * @author Radon Freedom
 * created at 2019.05.29 15:37
 */

public class _42 {
    public int trap(int[] height) {

        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < height.length; i++) {
            if (list.isEmpty() || height[list.getLast()] >= height[i]) {
                list.add(i);
            }
            else {
                //不再递减，从当前高度，从右往左一个一个地观察可存水量
                while (list.size() >= 2) {
                    int waterPoolIndex = list.removeLast();
                    int waterPoolDis = i - list.getLast() - 1;
                    int waterPoolHei = Math.min(height[list.getLast()], height[i]) - height[waterPoolIndex];
                    res += waterPoolHei * waterPoolDis;
                    if (height[list.getLast()] > height[i]) {
                        break;
                    }
                }
                if (height[list.getLast()] <= height[i]) {
                    list.removeLast();
                }
                list.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {


        new _42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}

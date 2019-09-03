package leetcode;

/**
 * @author Shaman
 * @date 2019/8/26 22:40
 */

public class _755 {

    public static int[] pourWater(int[] heights, int V, int K) {
        while (V > 0) {

            int best = K;
            for (int i = K; i > 0 && heights[i] >= heights[i - 1]; i--) {
                if (heights[i] > heights[i - 1]) {
                    best = i - 1;
                }
            }
            if (best != K) {
                heights[best]++;
                V--;
                continue;
            }
            for (int i = K; i < heights.length - 1 && heights[i] >= heights[i + 1]; i++) {
                if (heights[i] > heights[i + 1]) {
                    best = i + 1;
                }
            }
            heights[best]++;
            V--;
        }
        return heights;
    }
}

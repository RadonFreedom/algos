package sword;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.02.05 9:58
 */

public class _35 {

    public String PrintMinNumber(int[] numbers) {

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }

        // Arrays.sort会把比较结果小的放在前面
        Arrays.sort(nums, (i, j) -> {
            //举例说明 i=1, j=2 即可理解lambda表达式
            String s1 = i + "" + j;
            String s2 = j + "" + i;
            return s1.compareTo(s2);
        });

        StringBuilder builder = new StringBuilder();
        for (Integer num : nums) {
            builder.append(num);
        }

        return builder.toString();
    }
}

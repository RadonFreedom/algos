package sword;

import java.util.ArrayList;

/**
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.24 7:35
 */

public class _9 {


    /**
     * @param array 传入的数组
     * @param num1 长度为1的数组，传出参数
     * @param num2 长度为1的数组，传出参数
     */
    public void FindNumsAppearOnce(int[] array,int[] num1, int[] num2) {

        if (array == null || array.length <= 2) {
            return;
        }

        //将传入数组array中的所有数异或，将结果存入resultOfNum1XorNum2中
        int resultOfNum1XorNum2 = array[0];
        for (int i = 1; i < array.length; i++) {
            resultOfNum1XorNum2 = array[i] ^ resultOfNum1XorNum2;
        }

        //异或结果为0，说明所有数字都出现了偶数次，不存在出现奇数次或者出现一次的数字
        if (resultOfNum1XorNum2 == 0) {
            return;
        }

        //将resultOfNum1XorNum2中一个不为0的位保存在temp
        int temp = 1;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((temp & resultOfNum1XorNum2) == temp) {
                break;
            }
            temp = temp << 1;
        }

        //将数组array按照temp位为0或为1分为2个数组
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int num : array) {

            if ((temp & num) == temp) {
                arrayList1.add(num);
            }
            else {
                arrayList2.add(num);
            }
        }

        //分别将两个数组中的数字异或，并将异或结果放在传出参数num1, num2中
        num1[0] = arrayList1.get(0);
        num2[0] = arrayList2.get(0);
        for (int i = 1; i < arrayList1.size(); i++) {
            num1[0] = num1[0] ^ arrayList1.get(i);
        }
        for (int i = 1; i < arrayList2.size(); i++) {
            num2[0] = num2[0] ^ arrayList2.get(i);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1], num2 = new int[1];

        new _9().FindNumsAppearOnce(array, num1, num2);

        System.out.println(num1[0]+"\n"+ num2[0]);
    }
}

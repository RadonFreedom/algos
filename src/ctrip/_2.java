package ctrip;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Radon Freedom
 * created at 2019.04.08 下午7:47
 */

public class _2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String s = in.next();
        s = s.substring(1, s.length() - 1);
        String[] inputs = s.split(",");
        int cnt = in.nextInt();
        int begin = 0;

        LinkedList<String> linkedList = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        while (begin + cnt <= inputs.length) {
            for (int i = begin; i < begin + cnt; i++) {
                stack.push(inputs[i]);
            }
            for (int i = begin; i < begin + cnt; i++) {
                linkedList.add(stack.pop());
            }
            begin = begin + cnt;
        }

        linkedList.addAll(Arrays.asList(inputs).subList(begin, inputs.length));
        System.out.println(linkedList.toString().replaceAll(" ", ""));
    }
}

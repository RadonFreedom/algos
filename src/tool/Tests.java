package tool;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author xufeng
 * created at 2019.08.07 09:58
 */

public class Tests {
    public static void main(String[] args) {

        LinkedList<Long> longs = new LinkedList<>();
        Collections.addAll(longs,
        1000L,
        200L);
        System.out.println(longs);
    }
}

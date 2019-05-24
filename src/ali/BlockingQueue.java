package ali;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Radon Freedom
 * created at 2019.04.21 上午11:18
 */

public class BlockingQueue<T> {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new BlockingQueue<>();

        new Thread(() -> {
            int cnt = 0;
            int sum = 0;
            while (cnt < 100) {
                Integer i = queue.get();
                if (i != null) {
                    sum += i;
                    cnt++;
                }
            }
            System.out.println(sum);
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.put(i);
            }
        }).start();
    }

    private final Queue<T> queue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public T get() {

        //假设锁阻塞时间很短(小于该线程在CPU上占用的一个时间片), 避免线程上下文切换导致的开销
        while (!lock.tryLock()) {
        }
        try {
            return queue.isEmpty()? null : queue.poll();
        }finally {
            lock.unlock();
        }
    }

    public void put(T e) {

        if (e == null) {
            return;
        }

        //避免线程上下文切换导致的开销
        while (!lock.tryLock()) {
        }
        try {
            queue.add(e);
        } finally {
            lock.unlock();
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class ConcurrencyFirstTask {

    public static class BlockingQueue {

        private final Object lock = new Object();
        private final int maxSize;
        private final Queue<Integer> queue = new LinkedList<>();

        public BlockingQueue(int maxSize) {
            this.maxSize = maxSize;
        }

        public int size() {
            synchronized (lock) {
                return queue.size();
            }
        }

        public void enqueue(int element) {
            synchronized (lock) {
                while (queue.size() == maxSize) {
                    System.out.println("Queue is full");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.add(element);
                System.out.println("Added: " + element);
                lock.notifyAll();
            }
        }

        public int dequeue() {
            synchronized (lock) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int value = queue.remove();
                System.out.println("Removed: " + value);
                lock.notifyAll();
                return value;
            }
        }
    }
}


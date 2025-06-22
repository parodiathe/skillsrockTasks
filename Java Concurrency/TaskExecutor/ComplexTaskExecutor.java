import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {

    private final ExecutorService executor;
    private CyclicBarrier barrier;

    private boolean started = false;

    public ComplexTaskExecutor(int size) {
        this.executor = Executors.newFixedThreadPool(size);
        this.barrier = new CyclicBarrier(size);
    }

    public synchronized void executeTasks(int TasksNumber) {
        if (started)
            return;

        started = true;

        barrier = new CyclicBarrier(TasksNumber, ()
                -> {System.out.println("Задачи выполнены, объединение результатов");
        });

        for (int i = 0; i < TasksNumber; i++) {
            int taskId = i;
            executor.submit(() -> {
                ComplexTask task = new ComplexTask(taskId);
                task.run();
                try {
                    barrier.await();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
    }
}

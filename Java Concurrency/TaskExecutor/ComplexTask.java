public class ComplexTask implements Runnable {
    private final int taskId;

    public ComplexTask(int taskId) {
        this.taskId = taskId;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " работает над задачей №"
                + taskId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " Завершил работу над задачей №"
                + taskId);
    }

    @Override
    public void run() {
        execute();
    }
}

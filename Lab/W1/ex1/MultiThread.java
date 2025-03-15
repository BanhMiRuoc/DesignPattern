public class MultiThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            LoggerSynchronized log = LoggerSynchronized.getInstance();
            log.log(Thread.currentThread().getName() + " writing");
        };
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(task, "Thread " + (i + 1));
        }
        for (Thread t : thread) {
            t.start();
        }

        for (Thread t : thread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("log count: " + LoggerSynchronized.count);

    }
}
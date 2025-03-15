public class LoggerSynchronized {
    public static int count;
    private volatile static LoggerSynchronized instance;

    private LoggerSynchronized() {}
    public static LoggerSynchronized getInstance() {
        if (instance == null) {
            synchronized (LoggerSynchronized.class) {
                if (instance == null) {
                    instance = new LoggerSynchronized();
                    count++;
                    System.out.println("Log address" + instance);
                }
            }

        }
        return instance;
    }
    public void log(String message) {
        System.out.println(message);
    }
    public void writeLine(String message) {
        System.out.println(message);
    }
    public String readLine() {
        return "Log Entries here";
    }
}

public class Logger {
    public static int count;
    private Logger() {}
    private static Logger uniqueInstance;

    public static Logger getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Logger();
        }
        count++;
        System.out.println("logger address: " + System.identityHashCode(uniqueInstance));
        return uniqueInstance;
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
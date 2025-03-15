public class SingleThread {
    public static void main(String[] args) {
        Logger log = Logger.getUniqueInstance();
        log.log("BMR");
        log.writeLine("2");
        System.out.println("Log count: " + Logger.count);
    }
}
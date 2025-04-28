package ex3;

public class ConsoleLogger implements FileChangeObserver {
    @Override
    public void onFileChanged(String eventType, String fileName) {
        System.out.println("Sự kiện: " + eventType + " trên file: " + fileName);
    }
}

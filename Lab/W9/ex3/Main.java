package ex3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "E:\\HK2\\DP\\lab";
            FileWatcher watcher = new FileWatcher(path);
            watcher.addObserver(new ConsoleLogger());
            watcher.startWatching();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}


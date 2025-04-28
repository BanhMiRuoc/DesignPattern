package ex3;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileWatcher {
    private final List<FileChangeObserver> observers = new ArrayList<>();
    private final Path pathToWatch;

    public FileWatcher(String path) {
        this.pathToWatch = Paths.get(path);
    }

    public void addObserver(FileChangeObserver observer) {
        observers.add(observer);
    }

    public void startWatching() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        pathToWatch.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        System.out.println("Đang theo dõi thư mục: " + pathToWatch.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take();  // chờ sự kiện xảy ra
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path changedFile = (Path) event.context();

                // Thông báo cho tất cả Observer
                notifyObservers(kind.name(), changedFile.toString());
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

    private void notifyObservers(String eventType, String fileName) {
        for (FileChangeObserver observer : observers) {
            observer.onFileChanged(eventType, fileName);
        }
    }
}


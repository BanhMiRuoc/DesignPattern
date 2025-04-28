package ex3;

public interface FileChangeObserver {
    void onFileChanged(String eventType, String fileName);
}


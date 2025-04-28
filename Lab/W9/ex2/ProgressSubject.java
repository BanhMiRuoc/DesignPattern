package ex2;

public interface ProgressSubject {
    void addObserver(ProgressObserver observer);
    void removeObserver(ProgressObserver observer);
    void notifyProgress(int current, int total);
    void notifyComplete();
}

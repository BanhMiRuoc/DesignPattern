package ex2;

public interface ProgressObserver {
    void onProgressUpdate(int current, int total);
    void onComplete();
}

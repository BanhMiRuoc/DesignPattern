package ex2;

import java.util.ArrayList;
import java.util.List;

public class ProcessingTask implements Runnable, ProgressSubject {
    private int total;
    private List<ProgressObserver> observers;

    public ProcessingTask(int total) {
        this.total = total;
        observers = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 1; i <= total; i++) {
            try {
                Thread.sleep(1000);
                notifyProgress(i, total);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyComplete();
    }

    @Override
    public void addObserver(ProgressObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ProgressObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyProgress(int current, int total) {
        for (ProgressObserver o : observers) {
            o.onProgressUpdate(current, total);
        }
    }

    @Override
    public void notifyComplete() {
        for (ProgressObserver o : observers) {
            o.onComplete();
        }
    }
}

import java.util.ArrayList;

public class SortedList {
    private ArrayList<Integer> list = new ArrayList<>();
    private SortStrategy sortStrategy;

    public void add(int number) {
        list.add(number);
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort() {
        if (sortStrategy == null) {
            System.out.println("No sorting strategy set!");
        } else {
            sortStrategy.sort(list);
        }
    }

    public void printList() {
        System.out.println(list);
    }
}
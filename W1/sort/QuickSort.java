import java.util.ArrayList;
import java.util.Collections;

public class QuickSort implements SortStrategy {
    @Override
    public void sort(ArrayList<Integer> list) {
        System.out.println("Sorting using QuickSort...");
        Collections.sort(list);
    }
}
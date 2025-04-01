import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort implements SortStrategy {
    @Override
    public void sort(ArrayList<Integer> list) {
        System.out.println("Sorting using InsertionSort...");
        Collections.sort(list, Collections.reverseOrder());
    }
}
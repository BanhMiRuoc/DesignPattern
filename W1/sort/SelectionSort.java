import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SelectionSort implements SortStrategy {
    @Override
    public void sort(ArrayList<Integer> list) {
        System.out.println("Sorting using SelectionSort...");
        list.sort(Comparator.reverseOrder());
    }
}
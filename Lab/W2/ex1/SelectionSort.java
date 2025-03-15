import java.util.List;

public class SelectionSort implements IStrategySort {
    public void selectionSort(int[] arr) {
        {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[min_idx])
                        min_idx = j;
                }
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public void sort(List<String> sort, int[] arr) {
        for(String s: sort) {
            if (s.equals("SelectionSort")) {
                System.out.println("SelectionSort");
                selectionSort(arr);
                break;
            }
        }
    }
}
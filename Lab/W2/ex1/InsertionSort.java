import java.util.List;

public class InsertionSort implements IStrategySort{
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }
    public void sort(List<String> sort, int[] arr) {
        for(String s: sort) {
            if (s.equals("InsertionSort")) {
                System.out.println("InsertionSort");
                insertionSort(arr);
                break;
            }
        }
    }
}
import java.util.List;

public class BubbleSort implements IStrategySort{
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public void sort(List<String> sort, int[] arr) {
        for(String s: sort) {
            if (s.equals("BubbleSort")) {
                System.out.println("BubbleSort");
                bubbleSort(arr);
                break;
            }
        }
    }
}
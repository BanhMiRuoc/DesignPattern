package ex02;

import java.util.ArrayList;

public class QuickSort implements ISort{
    @Override
    public void sort(ArrayList<Integer> list) {
        quickSort(list, 0, list.size()-1);

    }
    private void quickSort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int pivot = partition(list, left, right);
            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }
    private int partition(ArrayList<Integer> list, int left, int right) {
        int pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j) > pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        i+=1;
        int temp = list.get(i);
        list.set(i, list.get(right));
        list.set(right, temp);
        return i;
    }

}

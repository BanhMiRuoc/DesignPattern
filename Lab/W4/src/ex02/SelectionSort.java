package ex02;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort implements ISort {

    @Override
    public void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > list.get(maxIdx)) {
                    maxIdx = j;
                }
            }
            Collections.swap(list, i, maxIdx);
        }
    }
}

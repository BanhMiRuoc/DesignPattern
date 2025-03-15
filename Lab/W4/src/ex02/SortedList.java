package ex02;

import java.util.ArrayList;

public class SortedList {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public void add(int number){
        list.add(number);
    }
    public void sort(SortStyle type){
        ISort sort = SortFactory.getSort(type);
        sort.sort(list);
    }
    public void print(){
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}

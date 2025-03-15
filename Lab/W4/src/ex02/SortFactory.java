package ex02;

public class SortFactory {
    public static ISort getSort(SortStyle type){
        ISort sort = null;
        switch (type){
            case QUICK:
                sort = new QuickSort();
            case INSERTION:
                sort = new InsertionSort();
            case SELECTION:
                sort = new SelectionSort();
       }
       return sort;
    }
}

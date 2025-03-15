import java.util.ArrayList;
import java.util.List;

public class StrategySort {
    private IStrategySort strategy;
    private final List<String> typeSort;
    private final int[] array;

    public StrategySort(IStrategySort sort, int[] array) {
        this.strategy = sort;
        typeSort = new ArrayList<String>();
        this.array = array;
    }

    public void setStrategy(IStrategySort strategy) {
        this.strategy = strategy;
    }
    public void add(String name) {
        typeSort.add(name);
    }
    public void sort() {
        strategy.sort(typeSort, array);
        for(int i: array) {
            System.out.print(i + ", ");
        }
    }
}
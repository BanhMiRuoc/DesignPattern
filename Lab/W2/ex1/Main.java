import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        CreateArray arr = new CreateArray(size);

        System.out.println("Array before sorting");
        int[] arr1 = arr.getArray();
        System.out.println(Arrays.toString(arr1));

        StrategySort strategy = new StrategySort(new SelectionSort(), arr1);
        strategy.add("SelectionSort");
        strategy.sort();
        System.out.println();

        strategy.setStrategy(new InsertionSort());
        strategy.add("InsertionSort");
        strategy.sort();
        System.out.println();

        strategy.setStrategy(new BubbleSort());
        strategy.add("BubbleSort");
        strategy.sort();
        System.out.println();

    }
}

import java.util.Arrays;
import java.util.Random;

public class CreateArray {
    private int size;

    public CreateArray(int size) {
        this.size = size;
    }

    public int[] getArray() {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }
}
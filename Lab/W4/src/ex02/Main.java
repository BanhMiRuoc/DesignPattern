package ex02;

public class Main {
    public static void main(String[] args) {
        SortedList test = new SortedList();
        test.add(2);
        test.add(5);
        test.add(3);
        test.add(9);
        test.add(4);

        test.sort(SortStyle.QUICK);
        test.print();

        System.out.println();

        test.add(10);
        test.add(20);
        test.sort(SortStyle.INSERTION);
        test.print();

        System.out.println();

        test.add(15);
        test.add(28);
        test.sort(SortStyle.SELECTION);
        test.print();
    }
}

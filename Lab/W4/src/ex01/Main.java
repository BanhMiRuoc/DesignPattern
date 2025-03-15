package ex01;

public class Main {
    public static void main(String[] args) {
        int shape = 1;
        int style = 2;
        IShape ishape = DrawShape.draw(shape, style);
        ishape.draw();
        if (ishape != null)
            System.out.println("ex01.IShape is drawn");
        else
            System.out.println("ex01.IShape is null");

    }
}
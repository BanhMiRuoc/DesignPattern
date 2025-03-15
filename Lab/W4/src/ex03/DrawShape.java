package ex03;

public abstract class DrawShape {

    public static IShape draw(int shape, int style) {
        IShape ishape = null;
        if (style == 2) {
            if (shape == 1)
                ishape = new SolidCircle();
            else if (shape == 2)
                ishape = new SolidSquares();
            else
                ishape = new SolidRectangle();
        }
        else {
            if (shape == 1)
                ishape = new Circle();
            else if (shape == 2)
                ishape = new Squares();
            else
                ishape = new Rectangle();
        }
        return ishape;

    }
}

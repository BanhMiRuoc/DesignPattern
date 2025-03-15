package ex03;

public class Squares implements IShape {
    private double x;
    public Squares() {}
    public Squares(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    @Override
    public void draw() {
        System.out.println("ex01.Squares");
    }
}

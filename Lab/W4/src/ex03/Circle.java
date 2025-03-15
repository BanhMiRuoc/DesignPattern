package ex03;

public class Circle implements IShape {
    private double radius;
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("ex01.Circle");
    }
}

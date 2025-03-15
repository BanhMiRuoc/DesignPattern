package ex01;

public class Rectangle implements IShape {
    private int w;
    private int h;
    public Rectangle() {}
    public Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public void setWidth(int w) {
        this.w = w;
    }
    public void setHeight(int h) {
        this.h = h;
    }
    @Override
    public void draw() {
        System.out.println("ex01.Rectangle");
    }


}

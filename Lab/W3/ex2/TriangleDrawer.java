import java.awt.*;

abstract class TriangleDrawer {
    protected Point A, B, C;

    public void setPoints(Point A, Point B) {
        if (A.y > B.y) {
            Point temp = A;
            A = B;
            B = temp;
        }
        this.A = A;
        this.B = B;
        calculateThirdPoint();
    }

    protected abstract void calculateThirdPoint();
    
    public void draw(Graphics g) {
        if (A != null && B != null && C != null) {
            g.setColor(Color.RED);
            g.drawLine(A.x, A.y, B.x, B.y);
            g.drawLine(B.x, B.y, C.x, C.y);
            g.drawLine(C.x, C.y, A.x, A.y);
        }
    }
}
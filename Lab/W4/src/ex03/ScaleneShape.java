package ex03;

class ScaleneShape extends ShapeDrawer {
    @Override
    protected void calculateThirdPoint() {
        C = (A.y < B.y) ? new Point(A.x + (B.x - A.x) / 3, B.y - (B.y - A.y) / 2) : new Point(B.x + (A.x - B.x) / 3, A.y - (A.y - B.y) / 2);
    }
}

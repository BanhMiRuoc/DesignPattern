class RightTriangleTop extends TriangleDrawer {
    @Override
    protected void calculateThirdPoint() {
        C = (A.y < B.y) ? new Point(A.x, B.y) : new Point(B.x, A.y);
    }
}